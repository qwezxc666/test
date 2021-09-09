package com.example.project02.ui.Activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.project02.BaseActivity;
import com.example.project02.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GActivity extends BaseActivity {


    private Banner banner;
    private List<Integer> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g);
        initView();
    }

    private void initView() {

        banner = (Banner) findViewById(R.id.banner);
        list.add(R.drawable.smartcity1);
        list.add(R.drawable.smartcity2);
        list.add(R.drawable.smartcity3);
        list.add(R.drawable.smartcity4);
        list.add(R.drawable.smartcity5);
        banner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                Integer integer= (Integer) o;
                imageView.setImageResource(integer);

//                if ()
            }
        });
    }
}