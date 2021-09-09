package com.example.project11.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.FoodBean;
import com.example.project11.Bean.NewsBean;
import com.example.project11.Bean.ThemeBean;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;


public class StartFragment extends Fragment {


    private Banner banner;
    private SearchView search;
    private RecyclerView ser;
    private RecyclerView hot;
    private RecyclerView food;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        banner = view.findViewById(R.id.banner);
        ser = view.findViewById(R.id.ser);
        hot = view.findViewById(R.id.hot);
        food=view.findViewById(R.id.food);
        search = view.findViewById(R.id.search);
        ser.setLayoutManager(new GridLayoutManager(getContext(), 5));
        hot.setLayoutManager(new GridLayoutManager(getContext(), 2));
        food.setLayoutManager(new LinearLayoutManager(getContext()));
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Tool.foodname=query;
                startActivity(new Intent(getContext(),ListActivity.class));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        getbanner();
        getser();
        return view;
    }

    private void getser() {
        Okhttp.get("/prod-api/api/takeout/theme/list", new MyCallBack(getActivity(), ThemeBean.class) {
            @Override
            public void onFinish(Object object) {
                ThemeBean recBean = (ThemeBean) object;
                ser.setAdapter(new CommAdapter<ThemeBean.DataBean>(getContext(), recBean.data, R.layout.rec_item) {
                    @Override
                    public void convert(Vh holder, ThemeBean.DataBean rowsBean) {
                        holder.setText(R.id.tv1, rowsBean.themeName);
                        holder.setGlide(R.id.iv1, rowsBean.imgUrl, getContext());
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (holder.getAdapterPosition()==0){
                                    Tool.i=1;
                                }
                                if (holder.getAdapterPosition()==1){
                                    Tool.i=2;
                                }
                                if (holder.getAdapterPosition()==2){
                                    Tool.i=3;
                                }
                                if (holder.getAdapterPosition()==3){
                                    Tool.i=4;
                                }
                                if (holder.getAdapterPosition()==4){
                                    Tool.i=5;
                                }
                                startActivity(new Intent(getActivity(),SLActivity.class));
                            }
                        });
                    }


                });
            }
        });
        Okhttp.get("/prod-api/api/takeout/seller/list?recommend=Y", new MyCallBack(getActivity(), FoodBean.class) {
            @Override
            public void onFinish(Object object) {
                FoodBean foodBean = (FoodBean) object;
                hot.setAdapter(new CommAdapter<FoodBean.RowsBean>(getContext(), foodBean.rows, R.layout.hot2_item) {
                    @Override
                    public void convert(Vh holder, FoodBean.RowsBean rowsBean) {
                        holder.setGlide(R.id.iv1, rowsBean.imgUrl, getContext());
                        holder.setText(R.id.tv1, rowsBean.name);
                        holder.setText(R.id.tv2, "近三小时销量：" + rowsBean.saleNum3hour);
                        holder.setRat(R.id.tv3, (int) rowsBean.score);
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.shopid=rowsBean.id;
                                startActivity(new Intent(getActivity(),ShopInforActivity.class));
                            }
                        });
                    }

                });
            }
        });
        Okhttp.get("/prod-api/api/takeout/seller/near?pageNum=1&pageSize=8", new MyCallBack(getActivity(), FoodBean.class) {
            @Override
            public void onFinish(Object object) {
                FoodBean foodBean = (FoodBean) object;
                food.setAdapter(new CommAdapter<FoodBean.RowsBean>(getContext(),foodBean.rows,R.layout.near_item) {
                    @Override
                    public void convert(Vh holder, FoodBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.name);
                        holder.setText(R.id.tv2,"月销量："+rowsBean.saleQuantity+"    "+rowsBean.distance+"m     "+rowsBean.deliveryTime+"分钟");
                        holder.setRat(R.id.ra, (int) rowsBean.score);
                        holder.setText(R.id.tv3,"人均消费："+rowsBean.avgCost);
                        holder.setGlide(R.id.iv1,rowsBean.imgUrl,getContext());
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Tool.shop=rowsBean;
                                Tool.shopid=rowsBean.id;
                                Log.e("qwe",Tool.shopid+"?");
                                startActivity(new Intent(getActivity(),ShopInforActivity.class));
                            }
                        });
                    }

                });
            }
        });
    }

    private void getbanner() {
        Okhttp.get("/prod-api/api/takeout/rotation/list", new MyCallBack(getActivity(), NewsBean.class) {
            @Override
            public void onFinish(Object object) {
                NewsBean newsBean = (NewsBean) object;
                banner.setAdapter(new BannerImageAdapter<NewsBean.RowsBean>(newsBean.rows) {
                    @Override
                    public void onBindView(BannerImageHolder bannerImageHolder, NewsBean.RowsBean rowsBean, int i, int i1) {
                        Tool.getGlide(getContext(), rowsBean.advImg, bannerImageHolder.imageView);
                    }


                });
                banner.setIndicator(new CircleIndicator(getContext()));
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(Object o, int i) {

                        Tool.shopid=newsBean.rows.get(i).targetId;
                        startActivity(new Intent(getContext(),ShopInforActivity.class));
                    }


                });

            }
        });
    }
}