package com.example.project11.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.CommAdapter;
import com.example.project11.R;
import com.example.project11.Tool;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;


public class SmartFragment extends Fragment {

    private Banner banner;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private RecyclerView re;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smart, container, false);
        banner = view.findViewById(R.id.banner);
        r1 = view.findViewById(R.id.r1);
        r2 = view.findViewById(R.id.r2);
        r3 = view.findViewById(R.id.r3);
        r4 = view.findViewById(R.id.r4);
        re= view.findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        setBanner();
        setre();
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(getActivity(),S1Activity.class));
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),S2Activity.class));
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),S3Activity.class));
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),S4Activity.class));
            }
        });
        return view;
    }

    private void setre() {
        re.setAdapter(new CommAdapter<SmartFragment.advBean>(getContext(),Tool.advList,R.layout.adv_item) {
            @Override
            public void convert(Vh holder, advBean advBean) {
                holder.setText(R.id.tv1,advBean.s1);
                holder.setimg(R.id.iv1,advBean.src);
                holder.setOnListen(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.adv=Tool.advList.get(holder.getAdapterPosition());
                        startActivity(new Intent(getActivity(),AdvInforActivity.class));
                    }
                });
            }

        });
    }

    @SuppressLint("WrongConstant")
    private void setBanner() {
        banner.setAdapter(new BannerImageAdapter<notifyBean>(Tool.notfiylist) {
            @Override
            public void onBindView(BannerImageHolder bannerImageHolder, notifyBean notifyBean, int i, int i1) {
                bannerImageHolder.imageView.setImageResource(notifyBean.src);
            }
        });
        banner.setIndicator(new CircleIndicator(getContext()));
//        banner.set
    }

    public static class notifyBean {
        int src;
        String t1, t2;

        public notifyBean(int src, String t1, String t2) {
            this.src = src;
            this.t1 = t1;
            this.t2 = t2;
        }
    }
    public static class advBean{
        int src;
        String s1;

        public advBean(int src, String s1) {
            this.src = src;
            this.s1 = s1;
        }
    }
}