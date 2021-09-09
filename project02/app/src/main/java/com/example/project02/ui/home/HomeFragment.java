package com.example.project02.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.Bean.AdvBean;
import com.example.project02.Bean.NewTypeBean;
import com.example.project02.Bean.SerBean;
import com.example.project02.CommAdapter;
import com.example.project02.MainActivity;
import com.example.project02.MyCallback;
import com.example.project02.NewsBean;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;
import com.example.project02.ui.Activity.M1Activity;
import com.example.project02.ui.Activity.M2Activity;
import com.example.project02.ui.Activity.M3Activity;
import com.example.project02.ui.Activity.NewsInforActivity;
import com.example.project02.ui.Activity.SearchActivity;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Banner banner;
    private SearchView search;
    private RecyclerView ser;
    private RecyclerView hot;
    private TabLayout tab;
    private RecyclerView news;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initView(root);
        getbanner();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Tool.name=query;
                ((MainActivity)requireActivity()).navController.navigate(R.id.navigation_notifications);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return root;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        search = (SearchView) view.findViewById(R.id.search);
        ser = (RecyclerView) view.findViewById(R.id.ser);
        ser.setLayoutManager(new GridLayoutManager(getContext(), 5));
        hot = (RecyclerView) view.findViewById(R.id.hot);
        hot.setLayoutManager(new GridLayoutManager(getContext(), 2));
        tab = view.findViewById(R.id.tab);
        news=view.findViewById(R.id.news);
        news.setLayoutManager(new LinearLayoutManager(getContext()));
        Okhttp.get("/prod-api/press/category/list", new MyCallback(getActivity(), NewTypeBean.class) {
            @Override
            public void onFish(Object o) {
                NewTypeBean newTypeBean = (NewTypeBean) o;
                for (NewTypeBean.DataBean newTypeBean1 : newTypeBean.data) {
                    tab.addTab(tab.newTab().setText(newTypeBean1.name));
                }
                tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        if (tab.getPosition()==0){
                            getnew(9);
                        }
                        if (tab.getPosition()==1){
                            getnew(17);
                        }
                        if (tab.getPosition()==2){
                            getnew(19);
                        }
                        if (tab.getPosition()==3){
                            getnew(20);
                        }
                        if (tab.getPosition()==4){
                            getnew(21);
                        }
                        if (tab.getPosition()==5){
                            getnew(22);
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
    }

    private void getbanner() {
        Okhttp.get("/prod-api/api/rotation/list?pageNum=1&pageSize=8&type=2", new MyCallback(getActivity(), AdvBean.class) {
            @Override
            public void onFish(Object o) {
                final AdvBean advBean = (AdvBean) o;
                banner.setImages(advBean.rows).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object o, ImageView imageView) {
                        final AdvBean.RowsBean adv = (AdvBean.RowsBean) o;
                        Tool.setGlide(getContext(), adv.advImg, imageView);
                        banner.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int i) {
                                Tool.hotid=adv.targetId;
                                startActivity(new Intent(getContext(),NewsInforActivity.class));
                            }
                        });
                    }
                }).start();
            }
        });
        Okhttp.get("/prod-api/api/service/list?orderByColumn=sort desc", new MyCallback(getActivity(), SerBean.class) {
            @Override
            public void onFish(Object o) {
                SerBean rowsBean = (SerBean) o;
                ser.setAdapter(new CommAdapter<SerBean.RowsBean>(rowsBean.rows.subList(0, 10), getContext(), R.layout.re_item) {
                    @Override
                    public void convert(Vh holder, SerBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1, rowsBean.serviceName);
                        holder.setGlide(R.id.iv1, rowsBean.imgUrl, getContext());
                        if (holder.getAdapterPosition() == 9) {
                            holder.setText(R.id.tv1, "全部服务");
                            holder.setimg(R.id.iv1, R.mipmap.qwe);
                            holder.setOnListen(R.id.l1, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ((MainActivity)requireActivity()).navController.navigate(R.id.navigation_dashboard);
                                }
                            });
                        }
                        if (holder.getAdapterPosition()==0){
                            holder.setOnListen(R.id.l1, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(getActivity(), M1Activity.class));
                                }
                            });
                        }
                        if (holder.getAdapterPosition()==4){
                            holder.setOnListen(R.id.l1, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(getActivity(), M2Activity.class));
                                }
                            });
                        }
                        if (holder.getAdapterPosition()==3){
                            holder.setOnListen(R.id.l1, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(getActivity(), M3Activity.class));
                                }
                            });
                        }
                    }


                });
            }
        });
        Okhttp.get("/prod-api/press/press/list?hot=Y", new MyCallback(getActivity(), NewsBean.class) {
            @Override
            public void onFish(Object o) {
                NewsBean newsBean = (NewsBean) o;
                hot.setAdapter(new CommAdapter<NewsBean.RowsBean>(newsBean.rows, getActivity(), R.layout.hot_item) {

                    @Override
                    public void convert(final Vh holder, final NewsBean.RowsBean rowsBean) {
                        holder.setGlide(R.id.iv1, rowsBean.cover, getContext());
                        holder.getWeb(R.id.tv1).loadData(rowsBean.content.substring(0,10),"text/html","utf-8");
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.hotid=rowsBean.id;
                                startActivity(new Intent(getActivity(),NewsInforActivity.class));
                            }
                        });
                    }

                });
            }
        });
    }

    private void getnew(int i) {
        Okhttp.get("/prod-api/press/press/list?type=" + i, new MyCallback(getActivity(), NewsBean.class) {
            @Override
            public void onFish(Object o) {
                NewsBean newsBean = (NewsBean) o;
                news.setAdapter(new CommAdapter<NewsBean.RowsBean>(newsBean.rows,getActivity(),R.layout.new_item) {

                    @Override
                    public void convert(Vh holder, NewsBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.title);
                        ///\<[^>]+>/g
                        String s="<.+?>";
                        Pattern pa=Pattern.compile(s,Pattern.DOTALL);
                        Matcher matcher=pa.matcher(rowsBean.content);
//                        pa.matcher()
                        holder.setText(R.id.tv2,matcher.replaceAll(""));
                        holder.setText(R.id.tv3,"评论总数："+rowsBean.commentNum+"\n"+rowsBean.publishDate);
                        holder.setGlide(R.id.iv1,rowsBean.cover,getContext());
                    }
                });
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getnew(9);

    }
}