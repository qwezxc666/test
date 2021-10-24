package com.example.cse01.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.HosBanBean;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

public class Q22Activity extends BaseActivity {

    private ImageView iv1;
    private WebView we;
    private CardView l1;
    private Banner banner;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q22);
        setTitle("医院详情");
        initView();
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);

        we = (WebView) findViewById(R.id.we);
        l1 = (CardView) findViewById(R.id.l1);
        Okhttp.get("/prod-api/api/hospital/banner/list?hospitalId=" + Tool.hosbean.id,
                new MyCallback(getthis(), HosBanBean.class) {
                    @Override
                    public void onFish(Object o) {
                        HosBanBean hosBanBean = (HosBanBean) o;
                        banner.setImages(hosBanBean.data)
                                .setImageLoader(new ImageLoader() {
                                    @Override
                                    public void displayImage(Context context, Object o, ImageView view) {
                                        HosBanBean.DataBean dataBean = (HosBanBean.DataBean) o;
                                        Tool.setGlide(context, dataBean.imgUrl, view);
                                    }
                                });
                        banner.start();
                    }
                });
        we.loadData(Tool.hosbean.brief, "text/html", "utf-8");
        l1.setOnClickListener(v -> startActivity(new Intent(getthis(), Q23Activity.class)));
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(Tool.hosbean.hospitalName+"\n\n:简介");
    }
}