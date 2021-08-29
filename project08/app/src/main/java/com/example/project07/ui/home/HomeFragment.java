package com.example.project07.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project07.Bean.AdbBean;
import com.example.project07.Bean.NewBean;
import com.example.project07.CommAdapter;
import com.example.project07.MainActivity;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;
import com.example.project07.ui.Acitvity.FindPActivity;
import com.example.project07.ui.Acitvity.Remove2Activity;
import com.example.project07.ui.Acitvity.RemoveActivity;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Banner banner;
    private SearchView search;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RecyclerView hot;
    private Button b1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        getbanner();
        return view;
    }


    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        search = (SearchView) view.findViewById(R.id.search);
        rb1 = (RadioButton) view.findViewById(R.id.rb1);
        rb2 = (RadioButton) view.findViewById(R.id.rb2);
        rb3 = (RadioButton) view.findViewById(R.id.rb3);
        hot = (RecyclerView) view.findViewById(R.id.hot);
        b1=view.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).navController.navigate(R.id.carlive);
            }
        });
    }

    private void getbanner() {
        banner.setIndicator(new CircleIndicator(getContext()));
        Okhttp.get("/prod-api/api/park/rotation/list", new MyCallback(getActivity(), AdbBean.class) {
            @Override
            public void onFish(Object o) {
                AdbBean adbBean = (AdbBean) o;
                banner.setAdapter(new BannerImageAdapter<AdbBean.RowsBean>(adbBean.rows) {
                    @Override
                    public void onBindView(BannerImageHolder bannerImageHolder, AdbBean.RowsBean rowsBean, int i, int i1) {
                        Tool.setGlide(getContext(), rowsBean.advImg, bannerImageHolder.imageView);
                    }

                });
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RemoveActivity.class));
            }
        });
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Remove2Activity.class));
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FindPActivity.class));
            }
        });
        hot.setLayoutManager(new LinearLayoutManager(getContext()));
        Okhttp.get("/prod-api/api/park/press/press/list?top=Y", new MyCallback(getActivity(), NewBean.class) {
            @Override
            public void onFish(Object o) {
                NewBean newBean = (NewBean) o;

                hot.setAdapter(new CommAdapter<NewBean.RowsBean>(getContext(), newBean.rows, R.layout.hot_item) {
                    @Override
                    public void convert(Vh holder, NewBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1, rowsBean.title);
                        holder.setText(R.id.tv2, "阅读数:" + rowsBean.readNum);
                        holder.setText(R.id.tv3, rowsBean.publishDate);
                        holder.setGlide(R.id.iv1, getContext(), rowsBean.cover);
                        holder.setonListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }


                });
            }
        });

    }
}