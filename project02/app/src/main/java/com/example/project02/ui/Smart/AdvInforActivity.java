package com.example.project02.ui.Smart;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project02.BaseActivity;
import com.example.project02.R;
import com.example.project02.Tool;

public class AdvInforActivity extends BaseActivity {

    private TextView tv1;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_infor);
        setTitle("广告详情");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv1.setText(Tool.adbBean.s1);
        iv1.setImageResource(Tool.adbBean.s2);
    }
}