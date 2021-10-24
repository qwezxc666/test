package com.example.cse01.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.AdvBean;
import com.example.cse01.Bean.HoBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3Activity extends BaseActivity {

    private Banner banner;
    private SearchView search;
    private RecyclerView re;
    private RecyclerView re2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);
        setTitle("找房子");
        initView();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.isEmpty()){
                    maketast("请输入搜索内容");
                }else {
                    sear(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        search = (SearchView) findViewById(R.id.search);
        re = (RecyclerView) findViewById(R.id.re);
        re2 = (RecyclerView) findViewById(R.id.re2);
        Okhttp.get("/prod-api/api/rotation/list?pageNum=1&pageSize=8&type=2", new MyCallback(getthis(), AdvBean.class) {
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
                        startActivity(new Intent(getthis(), AdvInforActivity.class));
                    }
                }).start();
            }
        });
        List<String >list=new ArrayList<>(Arrays.asList(
                "二手","租房","楼盘","中介"
        ));
        re.setLayoutManager(new GridLayoutManager(getthis(),4));
        re2.setLayoutManager(new LinearLayoutManager(getthis()));
        re.setAdapter(new CommAdapter<String>(getthis(),list,R.layout.ser_item) {
            @Override
            public void convert(Vh holder, String s) {
                holder.setText(R.id.tv1,s);
                holder.seton(R.id.l1,v -> {
                    gethos(s);
                });
            }
        });
        Okhttp.get("/prod-api/api/house/housing/list", new MyCallback(getthis(), HoBean.class) {
            @Override
            public void onFish(Object o) {
                HoBean hoBean= (HoBean) o;
                re2.setAdapter(new CommAdapter<HoBean.RowsBean>(getthis(),hoBean.rows,R.layout.ho_item) {
                    @Override
                    public void convert(Vh holder, HoBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.sourceName);
                        holder.setText(R.id.tv2,rowsBean.description);
                        holder.setText(R.id.tv3,"房源面积:"+ rowsBean.areaSize+"m/2\t\t\t价格"+rowsBean.price);
                        holder.setGlide(R.id.iv1,rowsBean.pic);
                        holder.seton(R.id.l1,v -> {
                            Tool.hobean=rowsBean;
                            startActivity(new Intent(getthis(),Q32Activity.class));
                        });
                    }
                });
            }
        });


    }
    private void sear(String str){
        Okhttp.get("/prod-api/api/house/housing/list", new MyCallback(getthis(), HoBean.class) {
            @Override
            public void onFish(Object o) {
                HoBean hoBean= (HoBean) o;
                List<HoBean.RowsBean> list=new ArrayList<>();
                for (HoBean.RowsBean rowsBean:hoBean.rows){
                    if (rowsBean.sourceName.contains(str)){
                        list.add(rowsBean);
                    }
                }
                if (list.size()==0){
                    maketast("未找到相关结果");
                }
                re2.setAdapter(new CommAdapter<HoBean.RowsBean>(getthis(),list,R.layout.ho_item) {
                    @Override
                    public void convert(Vh holder, HoBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.sourceName);
                        holder.setText(R.id.tv2,rowsBean.description);
                        holder.setText(R.id.tv3,"房源面积:"+ rowsBean.areaSize+"m/2\t\t\t价格"+rowsBean.price);
                        holder.setGlide(R.id.iv1,rowsBean.pic);
                        holder.seton(R.id.l1,v -> {
                            Tool.hobean=rowsBean;
                            startActivity(new Intent(getthis(),Q32Activity.class));
                        });
                    }
                });
            }
        });
    }
    private void gethos(String str){
        Okhttp.get("/prod-api/api/house/housing/list?houseType="+str, new MyCallback(getthis(), HoBean.class) {
            @Override
            public void onFish(Object o) {
                HoBean hoBean= (HoBean) o;
                re2.setAdapter(new CommAdapter<HoBean.RowsBean>(getthis(),hoBean.rows,R.layout.ho_item) {
                    @Override
                    public void convert(Vh holder, HoBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.sourceName);
                        holder.setText(R.id.tv2,rowsBean.description);
                        holder.setText(R.id.tv3,"房源面积:"+ rowsBean.areaSize+"m/2\t\t\t价格:"+rowsBean.price);
                        holder.setGlide(R.id.iv1,rowsBean.pic);
                        holder.seton(R.id.l1,v -> {
                           Tool.hobean=rowsBean;
                           startActivity(new Intent(getthis(),Q32Activity.class));
                        });
                    }
                });
            }
        });
    }
}