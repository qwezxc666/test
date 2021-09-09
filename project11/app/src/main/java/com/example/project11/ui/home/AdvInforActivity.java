package com.example.project11.ui.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

public class AdvInforActivity extends BaseActivity {

    private TextView tv1;
    private ImageView iv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_infor);
        initView();
        setTitle("店铺详情");
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv1.setText(Tool.adv.s1);
        iv1.setImageResource(Tool.adv.src);
    }
}