package com.example.cse01.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.CommAdapter;
import com.example.cse01.R;
import com.example.cse01.Smart.InforActivity;
import com.example.cse01.Smart.S1Activity;
import com.example.cse01.Smart.S2Activity;
import com.example.cse01.Smart.S3Activity;
import com.example.cse01.Smart.S4Activity;
import com.example.cse01.Tool;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        re = (RecyclerView) view.findViewById(R.id.re);
        re2 = (RecyclerView) view.findViewById(R.id.re2);
        List<Tb> tbList=new ArrayList<>(Arrays.asList(
                new Tb("车辆管理","",R.drawable.a1),
                new Tb("快件管理","",R.drawable.a2),
                new Tb("友邻社交","",R.drawable.a3),
                new Tb("物业服务","",R.drawable.a4)

                ));
        List<Tb> tbList1=new ArrayList<>(Arrays.asList(
                new Tb("物业通知","2021-10-21 10:00",R.drawable.b1),
                new Tb("社区居委会的通知","2021-10-22 10:00",R.drawable.b2),
                new Tb("社区居委会的通知","2021-10-23 10:00",R.drawable.b3),
                new Tb("物业通知","2021-10-24 10:00",R.drawable.b4)
                ));
        List<Tb> tbList2=new ArrayList<>(Arrays.asList(
                new Tb("咖啡机","",R.drawable.r1),
                new Tb("PiPi","",R.drawable.r2),
                new Tb("奶粉","",R.drawable.r3),
                new Tb("洗护","",R.drawable.r4)
                ));
        List<String > strings=new ArrayList<>(Arrays.asList(
                "物业通知  2021-10-21 10:00","社区居委会的通知  2021-10-22 10:00","社区居委会的通知  2021-10-23 10:00",
                "物业通知  2021-10-24 10:00"
        ));
        banner.setBannerTitles(strings)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImages(tbList1)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object o, ImageView view) {
                        Tb tb= (Tb) o;
                        view.setImageResource(tb.i1);

                    }
                })
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int i) {
                        Tool.tbbean=tbList1.get(i);
                        startActivity(new Intent(getContext(), InforActivity.class));
                    }
                });
        banner.start();
        re.setLayoutManager(new GridLayoutManager(getContext(),4));
        re.setAdapter(new CommAdapter<Tb>(getContext(),tbList,R.layout.tb_item) {
            @Override
            public void convert(Vh holder, Tb tb) {
                holder.setText(R.id.tv1,tb.s1);
                holder.setGlide(R.id.iv1,tb.i1);
                holder.seton(R.id.l1,v -> {
                    if (holder.getAdapterPosition()==0){
                        startActivity(new Intent(getContext(), S1Activity.class));
                    }
                    if (holder.getAdapterPosition()==1){
                        startActivity(new Intent(getContext(), S2Activity.class));
                    }
                    if (holder.getAdapterPosition()==2){
                        startActivity(new Intent(getContext(), S3Activity.class));
                    }
                    if (holder.getAdapterPosition()==3){
                        startActivity(new Intent(getContext(), S4Activity.class));
                    }
                });
            }

        });
        re2.setLayoutManager(new LinearLayoutManager(getContext()));
        re2.setAdapter(new CommAdapter<Tb>(getContext(),tbList2,R.layout.tg_item) {
            @Override
            public void convert(Vh holder, Tb tb) {
                holder.setText(R.id.tv1,tb.s1);
                holder.setGlide(R.id.iv1,tb.i1);
                holder.seton(R.id.l1,v -> {
                    Tool.tbbean=tb;
                    startActivity(new Intent(getContext(),TgActivity.class));
                });
            }
        });
    }
    public static class Tb{
        public String s1,s2,s3;
        public int i1,i2;

        public Tb(String s1, String s2, String s3, int i1, int i2) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.i1 = i1;
            this.i2 = i2;
        }

        public Tb(String s1, String s2, int i1, int i2) {
            this.s1 = s1;
            this.s2 = s2;
            this.i1 = i1;
            this.i2 = i2;
        }

        public Tb(String s1, String s2, int i1) {
            this.s1 = s1;
            this.s2 = s2;
            this.i1 = i1;
        }
    }
}