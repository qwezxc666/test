package com.example.cse01.Activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.NewsInforBean;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class AdvInforActivity extends BaseActivity {

    private TextView tv1;
    private ImageView iv1;
    private WebView we;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_infor);
        setTitle("新闻详情");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        we = (WebView) findViewById(R.id.we);
        Okhttp.get("/prod-api/press/press/" + Tool.id, new MyCallback(getthis(), NewsInforBean.class) {
            @Override
            public void onFish(Object o) {
                NewsInforBean newsInforBean= (NewsInforBean) o;
                tv1.setText(newsInforBean.data.title);
                Tool.setGlide(getthis(),newsInforBean.data.cover,iv1);
                we.loadData(newsInforBean.data.content,"text/html","utf-8");

            }
        });
    }
}