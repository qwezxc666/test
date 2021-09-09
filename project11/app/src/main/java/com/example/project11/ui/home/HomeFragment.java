package com.example.project11.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.NewBean;
import com.example.project11.Bean.NewsBean;
import com.example.project11.Bean.RecBean;
import com.example.project11.Bean.TypeBean;
import com.example.project11.CommAdapter;
import com.example.project11.MainActivity;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Smart.FoodActivity;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.NewInforActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Banner banner;
    private RecyclerView rec;
    private SearchView search;
    private TabLayout tab;
    private RecyclerView news;
    private List<NewBean.RowsBean> rows2;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        banner = root.findViewById(R.id.banner);
        rec = root.findViewById(R.id.rec);
        rec.setLayoutManager(new GridLayoutManager(getContext(), 5));
        tab = root.findViewById(R.id.tab);
        search = root.findViewById(R.id.search);
        news=root.findViewById(R.id.news);
        news.setLayoutManager(new LinearLayoutManager(getContext()));
        getbanner();
        getRec();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Bundle bundle = new Bundle();
                bundle.putString("key",query);
                ((MainActivity)requireActivity()).navController.navigate(R.id.navigation_notifications,bundle);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return root;
    }

    private void getnews(int i) {
        Okhttp.get("/prod-api/press/press/list?type=" + i, new MyCallBack(getActivity(),NewBean.class) {
            @Override
            public void onFinish(Object object) {
                NewBean newsBean = (NewBean) object;
                news.setAdapter(new CommAdapter<NewBean.RowsBean>(getContext(),newsBean.rows,R.layout.news_item) {
                    @Override
                    public void convert(Vh holder, NewBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.title);
                        holder.setText(R.id.tv2,rowsBean.content.replace("<p>",""));
                        holder.setText(R.id.tv3,rowsBean.publishDate);
                        holder.setText(R.id.tv4,"评论数："+rowsBean.commentNum);
                        holder.setGlide(R.id.iv1,rowsBean.cover,getContext());
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.rowsBean=rowsBean;
                                startActivity(new Intent(getActivity(), NewInforActivity.class));
                            }
                        });
                    }

                });
            }
        });

    }

    private void getRec() {
        Okhttp.get("/prod-api/press/press/list",new MyCallBack(getActivity(),NewBean.class) {
            @Override
            public void onFinish(Object object) {
                NewBean newBean= (NewBean) object;
                rows2=newBean.rows;
            }
        });


        Okhttp.get("/prod-api/api/service/list?orderByColumn=sort asc", new MyCallBack(requireActivity(), RecBean.class) {
            @Override
            public void onFinish(Object object) {
                RecBean recBean = (RecBean) object;
                rec.setAdapter(new CommAdapter<RecBean.RowsBean>(getContext(), recBean.rows.subList(0, 10), R.layout.rec_item) {
                    @Override
                    public void convert(Vh holder, RecBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1, rowsBean.serviceName);
                        holder.setGlide(R.id.iv1, rowsBean.imgUrl, getContext());
                        if (holder.getAdapterPosition() == 9) {
                            holder.setText(R.id.tv1, "全部服务");
                            holder.setimg(R.id.iv1, R.drawable.fw);

                        }
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (holder.getAdapterPosition()==6){
                                    startActivity(new Intent(getActivity(), FoodActivity.class));
                                }
                                if (holder.getAdapterPosition()==9){
                                    ((MainActivity)requireActivity()).navController.navigate(R.id.navigation_dashboard);
                                }
                            }
                        });

                    }


                });
            }
        });
        Okhttp.get("/prod-api/press/category/list", new MyCallBack(getActivity(), TypeBean.class) {
            @Override
            public void onFinish(Object object) {
                TypeBean typeBean = (TypeBean) object;
                for (TypeBean.DataBean dataBean : typeBean.data) {
                    tab.addTab(tab.newTab().setText(dataBean.name));
                }
                tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        if (tab.getPosition()==0){
                            getnews(9);
                        }
                        if (tab.getPosition()==1){
                            getnews(17);
                        }
                        if (tab.getPosition()==2){
                            getnews(19);
                        }
                        if (tab.getPosition()==3){
                            getnews(20);
                        }
                        if (tab.getPosition()==4){
                            getnews(21);
                        }
                        if (tab.getPosition()==5){
                            getnews(22);
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        });
        getnews(9);
    }

    private void getbanner() {
        Okhttp.get("/prod-api/api/rotation/list?pageNum=1&pageSize=8&type=2", new MyCallBack(requireActivity(), NewsBean.class) {
            @Override
            public void onFinish(Object object) {
                NewsBean newsBean = (NewsBean) object;
                banner.setAdapter(new BannerImageAdapter<NewsBean.RowsBean>(newsBean.rows) {
                    @Override
                    public void onBindView(BannerImageHolder bannerImageHolder, NewsBean.RowsBean rowsBean, int i, int i1) {
                        Tool.getGlide(getActivity(), rowsBean.advImg, bannerImageHolder.imageView);
                    }
                });
                banner.setIndicator(new CircleIndicator(getContext()));
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(Object o, int i) {
                        if (i==0){
                            Tool.rowsBean=rows2.get(27);
                        }
                        if (i==1){
                            Tool.rowsBean=rows2.get(28);
                        }
                        if (i==2){
                            Tool.rowsBean=rows2.get(29);
                        }
                        startActivity(new Intent(getContext(),NewInforActivity.class));
                    }
                });
            }
        });
    }
}