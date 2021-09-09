package com.example.project11.ui.Activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project11.Bean.NewBean;
import com.example.project11.R;
import com.example.project11.Tool;

public class NewInforActivity extends BaseActivity {

    private TextView tv1;
    private ImageView iv1;
    private WebView we;
    private NewBean.RowsBean rowsBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_infor);
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        we = (WebView) findViewById(R.id.we);
        rowsBean= Tool.rowsBean;
        tv1.setText(rowsBean.title);
        Tool.getGlide(getApplicationContext(),rowsBean.cover,iv1);
        we.loadData(rowsBean.content,"text/html","utf-8");
    }
}