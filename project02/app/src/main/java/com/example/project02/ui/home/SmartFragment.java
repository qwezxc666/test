package com.example.project02.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.CommAdapter;
import com.example.project02.R;
import com.example.project02.Tool;
import com.example.project02.ui.Smart.AdvInforActivity;
import com.example.project02.ui.Smart.NotifyActivity;
import com.example.project02.ui.Smart.S1Activity;
import com.example.project02.ui.Smart.S2Activity;
import com.example.project02.ui.Smart.S3Activity;
import com.example.project02.ui.Smart.S4Activity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class SmartFragment extends Fragment {


    private Banner banner;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private List<Integer> list = new ArrayList<>();
    private RecyclerView adv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smart, container, false);
        initView(view);
        set();
        return view;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        rb1 = (RadioButton) view.findViewById(R.id.rb1);
        rb2 = (RadioButton) view.findViewById(R.id.rb2);
        rb3 = (RadioButton) view.findViewById(R.id.rb3);
        rb4 = (RadioButton) view.findViewById(R.id.rb4);
        list.add(R.drawable.s1);
        list.add(R.drawable.s2);
        list.add(R.drawable.s3);
        list.add(R.drawable.s4);
        ArrayList<String> string = new ArrayList<>();
        ArrayList<Integer> integer = new ArrayList<>();
        adv = (RecyclerView) view.findViewById(R.id.adv);
        adv.setLayoutManager(new LinearLayoutManager(getContext()));
        for (babean babean : Tool.bannerlist) {
            string.add(babean.s1);
        }
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE).setImages(Tool.bannerlist).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                babean i = (babean) o;
                imageView.setImageResource(i.s3);
            }
        }).setBannerTitles(string).setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                Tool.notifid = i;
                startActivity(new Intent(getContext(), NotifyActivity.class));
            }
        }).start();
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), S4Activity.class));
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), S3Activity.class));
            }
        });
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), S1Activity.class));
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), S2Activity.class));
            }
        });
    }

    private void set() {
        adv.setAdapter(new CommAdapter<SmartFragment.adv>(Tool.advlist, getContext(), R.layout.adv_item) {
            @Override
            public void convert(Vh holder, final SmartFragment.adv adv) {
                holder.setText(R.id.tv1, adv.s1);
                holder.setimg(R.id.iv1, adv.s2);
                holder.setOnListen(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.adbBean = adv;
                        startActivity(new Intent(getActivity(), AdvInforActivity.class));
                    }
                });
            }

        });
    }

    public static class adv {
        public String s1;
        public int s2;

        public adv(String s1, int s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    public static class babean {
        public String s1, s2;
        public int s3;

        public babean(String s1, String s2, int s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
    }

    public static class car {
        public String s1, s2, s3, s4, s5, s6, s7;

        public car(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.s4 = s4;
            this.s5 = s5;
            this.s6 = s6;
            this.s7 = s7;
        }
    }
}