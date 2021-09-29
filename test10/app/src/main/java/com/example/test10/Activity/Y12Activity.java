package com.example.test10.Activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;

import java.util.Random;

public class Y12Activity extends BaseAcitivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y12);
        setTitle("计算费用");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        int i=new Random().nextInt(8000)+1000;
        tv1.setText("总共服务费用：\n\n"+i+"￥");
    }
}