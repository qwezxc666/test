package com.example.porject09.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

import com.example.porject09.R;
import com.example.porject09.ui.smart.S1Activity;
import com.example.porject09.ui.smart.S2Activity;
import com.example.porject09.ui.smart.S3Activity;
import com.example.porject09.ui.smart.S4Activity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class SmartFragment extends Fragment {


    private Banner banner;
    private List<Integer> list = new ArrayList<>();
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smart, container, false);
        initView(view);
        getbanner();

        return view;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        rb1 = (RadioButton)view. findViewById(R.id.rb1);
        rb2 = (RadioButton) view.findViewById(R.id.rb2);
        rb3 = (RadioButton)view. findViewById(R.id.rb3);
        rb4 = (RadioButton) view.findViewById(R.id.rb4);
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), S1Activity.class));
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), S3Activity.class));
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), S2Activity.class));
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), S4Activity.class));
            }
        });
    }

    private void getbanner() {
        list.add(R.drawable.find_hot_jiangnan);
        list.add(R.drawable.find_pk1);
        banner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                Integer integer = (Integer) o;
                imageView.setImageResource(integer);
            }
        }).start();
    }
    public static class re{
        public String s1;

        public re(String s1) {
            this.s1 = s1;
        }
    }
    public static class infor{
        public String s1,s2,s3;

        public infor(String s1, String s2, String s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
    }
}