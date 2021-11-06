package com.example.cse01.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.Activity.AdvInforActivity;
import com.example.cse01.Activity.Q14Activity;
import com.example.cse01.Activity.Q15Activity;
import com.example.cse01.Activity.Q2Activity;
import com.example.cse01.Activity.Q3Activity;
import com.example.cse01.Activity.Q4Activity;
import com.example.cse01.Activity.QActivity;
import com.example.cse01.Bean.AdvBean;
import com.example.cse01.Bean.NewsBean;
import com.example.cse01.Bean.SerBean;
import com.example.cse01.Bean.TypeBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MainActivity;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

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

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        if (ispad(getContext())){
            ser.setLayoutManager(new GridLayoutManager(getContext(),6));
            hot.setLayoutManager(new GridLayoutManager(getContext(),4));
        }else {
            ser.setLayoutManager(new GridLayoutManager(getContext(),5));
            hot.setLayoutManager(new GridLayoutManager(getContext(),2));
        }
        getbanner();
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

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query==null){
                    Toast.makeText(getContext(), "请输入内容", Toast.LENGTH_SHORT).show();
                }else {

                Tool.name=query;
                ((MainActivity)getActivity()).navController.navigate(R.id.navigation_notifications);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void getbanner() {
        Okhttp.get("/prod-api/api/rotation/list?pageNum=1&pageSize=8&type=2", new MyCallback(getActivity(), AdvBean.class) {
            @Override
            public void onFish(Object o) {
                AdvBean advBean= (AdvBean) o;
                banner.setImages(advBean.rows)
                        .setImageLoader(new ImageLoader() {
                            @Override
                            public void displayImage(Context context, Object o, ImageView view) {
                                AdvBean.RowsBean rowsBean= (AdvBean.RowsBean) o;
                                Tool.setGlide(context,rowsBean.advImg,view);
                            }
                        });
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int i) {
                        Tool.id=advBean.rows.get(i).id;
                        startActivity(new Intent(getContext(), AdvInforActivity.class));
                    }
                }).start();
            }
        });

        Okhttp.get("/prod-api/api/service/list", new MyCallback(getActivity(), SerBean.class) {
            @Override
            public void onFish(Object o) {
                SerBean serBean= (SerBean) o;
                ser.setAdapter(new CommAdapter<SerBean.RowsBean>(getContext(),serBean.rows.subList(0,10),R.layout.ser_item) {
                    @Override
                    public void convert(Vh holder, SerBean.RowsBean rowsBean) {

                        if (holder.getAdapterPosition()==9){
                            holder.setText(R.id.tv1,"更多服务");
                            holder.setGlide(R.id.iv1,R.drawable.fw3);
                        }else {
                            holder.setText(R.id.tv1,rowsBean.serviceName);
                            holder.setGlide(R.id.iv1,rowsBean.imgUrl);
                        }
                        holder.seton(R.id.l1,v -> {
                            if (holder.getAdapterPosition()==9){
                                ((MainActivity)getActivity()).navController.navigate(R.id.navigation_dashboard);
                            }
                            if (holder.getAdapterPosition()==2){
                                startActivity(new Intent(getContext(), QActivity.class));
                            }
                            if (holder.getAdapterPosition()==3){
                                startActivity(new Intent(getContext(), Q2Activity.class));
                            }
                            if (holder.getAdapterPosition()==7){
                                startActivity(new Intent(getContext(), Q3Activity.class));
                            }
                            if (holder.getAdapterPosition()==4){
                                startActivity(new Intent(getContext(), Q4Activity.class));
                            }
//                            if (holder.getAdapterPosition()==1){
//                                startActivity(new Intent(getContext(), Q14Activity.class));
//                            }
                        });
                    }

                });
            }
        });

        Okhttp.get("/prod-api/press/category/list", new MyCallback(getActivity(), TypeBean.class) {
            @Override
            public void onFish(Object o) {
                TypeBean typeBean= (TypeBean) o;
                for (TypeBean.DataBean dataBean:typeBean.data){
                    tab.addTab(tab.newTab().setText(dataBean.name));
                }
            }
        });

        Okhttp.get("/prod-api/press/press/list?hot=Y", new MyCallback(getActivity(), NewsBean.class) {
            @Override
            public void onFish(Object o) {
                NewsBean newsBean= (NewsBean) o;
                hot.setAdapter(new CommAdapter<NewsBean.RowsBean>(getContext(),newsBean.rows,R.layout.hot_item) {
                    @Override
                    public void convert(Vh holder, NewsBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.title);
                        holder.setGlide(R.id.iv1,rowsBean.cover);
                        holder.seton(R.id.l1,v -> {
                            Tool.id=rowsBean.id;
                            startActivity(new Intent(getContext(),AdvInforActivity.class));
                        });
                    }

                });
            }
        });


    }
    public void getnew(int id){
        Okhttp.get("/prod-api/press/press/list?type=" + id, new MyCallback(getActivity(),NewsBean.class) {
            @Override
            public void onFish(Object o) {
                NewsBean newsBean= (NewsBean) o;
                news.setLayoutManager(new LinearLayoutManager(getContext()));
                news.setAdapter(new CommAdapter<NewsBean.RowsBean>(getContext(),newsBean.rows,R.layout.news_item) {
                    @Override
                    public void convert(Vh holder, NewsBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.title);
                        holder.setText(R.id.tv2,rowsBean.content.replaceAll("</?[^>]+>",""));
                        holder.setText(R.id.tv3,"评论总数："+rowsBean.commentNum+"\n"+rowsBean.createTime);
                        holder.setGlide(R.id.iv1,rowsBean.cover);
                    }
                });
            }
        });
    }
    private boolean ispad(Context context){
        WindowManager manager= (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display=manager.getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
         if (point.x>point.y){
            return true;
        }else {
            return false;
        }
    }
    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        search = (SearchView) view.findViewById(R.id.search);
        ser = (RecyclerView) view.findViewById(R.id.ser);
        hot = (RecyclerView) view.findViewById(R.id.hot);
        tab = (TabLayout) view.findViewById(R.id.tab);
        news = (RecyclerView) view.findViewById(R.id.news);
    }
}