package com.example.project07.ui.Acitvity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project07.BaseActivity;
import com.example.project07.R;
import com.example.project07.Tool;

public class NewsInforActivity extends BaseActivity {

    private TextView tv1;
    private TextView tv2;
    private ImageView iv1;
    private WebView we;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_infor);
        setTitle("新闻详情");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        iv1 = (ImageView) findViewById(R.id.iv1);
        we = (WebView) findViewById(R.id.we);
        tv1.setText(Tool.newsBean.title);
        tv2.setText(Tool.newsBean.createTime);
        Tool.setGlide(getApplicationContext(),Tool.newsBean.cover,iv1);
        we.loadData(Tool.newsBean.content,"text/html","utf-8");
    }
}