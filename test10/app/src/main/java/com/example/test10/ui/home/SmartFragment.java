package com.example.test10.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.Smart.AdvInforActivity;
import com.example.test10.Smart.S1Activity;
import com.example.test10.Smart.S2Activity;
import com.example.test10.Smart.S3Activity;
import com.example.test10.Smart.S4Activity;
import com.example.test10.Tool;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SmartFragment extends Fragment {

    private Banner banner;
    private RecyclerView re;
    private RecyclerView re2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smart, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        re = (RecyclerView) view.findViewById(R.id.re);
        re2 = (RecyclerView) view.findViewById(R.id.re2);

        re.setLayoutManager(new GridLayoutManager(getContext(), 4));
        re2.setLayoutManager(new LinearLayoutManager(getContext()));

        List<tb> tbList = new ArrayList<>(Arrays.asList(
                new tb("物业通知", R.drawable.s1),
                new tb("社区居委会", R.drawable.s2),
                new tb("物业通知", R.drawable.s3)

        ));
        List<tb> tbList1 = new ArrayList<>(Arrays.asList(
                new tb("物业服务", R.drawable.d1),
                new tb("快件管理", R.drawable.d2),
                new tb("友邻社交", R.drawable.d3),
                new tb("车辆管理", R.drawable.d4)

        ));
        List<tb> tbList2 = new ArrayList<>(Arrays.asList(
                new tb("蓝月亮", R.drawable.adv1),
                new tb("百事可乐", R.drawable.adv2),
                new tb("好吃的", R.drawable.adv3)

        ));
        re2.setAdapter(new CommAdapter<tb>(getContext(),tbList2,R.layout.adv_item) {
            @Override
            public void convert(Vh convert, tb tb) {
                convert.setText(R.id.tv1,tb.s1);
                convert.setGlide(R.id.iv1,tb.i1);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.tbbean=tb;
                        startActivity(new Intent(getActivity(),AdvInforActivity.class));
                    }
                });
            }
        });
        re.setAdapter(new CommAdapter<tb>(getContext(),tbList1,R.layout.tb_item) {
            @Override
            public void convert(Vh convert, tb tb) {
                convert.setText(R.id.tv1,tb.s1);
                convert.setGlide(R.id.iv1,tb.i1);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (convert.getAdapterPosition()==0){
                            startActivity(new Intent(getActivity(), S1Activity.class));
                        }
                        if (convert.getAdapterPosition()==1){
                            startActivity(new Intent(getActivity(), S2Activity.class));
                        }
                        if (convert.getAdapterPosition()==2){
                            startActivity(new Intent(getActivity(), S3Activity.class));
                        }
                        if (convert.getAdapterPosition()==3){
                            startActivity(new Intent(getActivity(), S4Activity.class));
                        }
                    }
                });
            }

        });
        banner.setIndicator(new CircleIndicator(getContext()))
                .setAdapter(new BannerImageAdapter<tb>(tbList) {
                    @Override
                    public void onBindView(BannerImageHolder bannerImageHolder, tb tb, int i, int i1) {
                        bannerImageHolder.imageView.setImageResource(tb.i1);
                    }

                }).setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(Object o, int i) {
                Tool.tbbean=tbList.get(i);
                startActivity(new Intent(getContext(), AdvInforActivity.class));
            }
        });
    }

    public static class tb {
        public String s1;
        public int i1;

        public tb(String s1, int i1) {
            this.s1 = s1;
            this.i1 = i1;
        }
    }
}