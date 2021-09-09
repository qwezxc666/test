package com.example.project02.ui.Activity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.SBean;
import com.example.project02.MyCallback;
import com.example.project02.NewsBean;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;

public class NewsInforActivity extends BaseActivity {

    private TextView tv1;
    private ImageView iv1;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_infor);
        initView();
        setTitle("新闻详情");
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        web = (WebView) findViewById(R.id.web);
//        Log.e("qwe",Tool.hotid+"");
        if (Tool.hotid!=-1){
            getnews(Tool.hotid);
        }
    }
    private void getnews(int i){
        Okhttp.get("/prod-api/press/press/" + i, new MyCallback(getthis(), SBean.class) {
            @Override
            public void onFish(Object o) {
                SBean newsBean= (SBean) o;

                tv1.setText(newsBean.data.title);
                Tool.setGlide(getthis(),newsBean.data.cover,iv1);
                web.loadData(newsBean.data.content,"text/html","utf-8");
            }
        });
    }
}