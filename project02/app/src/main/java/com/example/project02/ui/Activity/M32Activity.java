package com.example.project02.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.Adv3Bean;
import com.example.project02.Bean.AdvBean;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

public class M32Activity extends BaseActivity {

    private Banner banner;
    private WebView web;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m32);
        setTitle("医院详情");
        initView();
        getbanner();
        if (Tool.hosBean!=null){
            web.loadData(Tool.hosBean.brief,"text/html","utf-8");

        }
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        web = (WebView) findViewById(R.id.web);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),M33Activity.class));
            }
        });
    }
    private void getbanner(){
        //空指针--数据解析问题 不同的轮播图要单独写Bean
        Okhttp.get("/prod-api/api/hospital/banner/list?hospitalId="+Tool.hosBean.id, new MyCallback(getthis(), Adv3Bean.class) {
            @Override
            public void onFish(Object o) {
                final Adv3Bean advBean= (Adv3Bean) o;
                banner.setImages(advBean.data).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object o, ImageView imageView) {
                        Adv3Bean.DataBean rowsBean= (Adv3Bean.DataBean) o;
                        Tool.setGlide(getthis(),rowsBean.imgUrl,imageView);
                    }
                }).start();

            }
        });
    }
}