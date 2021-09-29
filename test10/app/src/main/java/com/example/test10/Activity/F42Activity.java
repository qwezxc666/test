package com.example.test10.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;
import com.example.test10.Tool;

public class F42Activity extends BaseAcitivity {

    private ImageView iv1;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f42);
        setTitle("村子详情");

        initView();
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        iv1.setImageResource(Tool.czbean.i1);
        tv1.setText(Tool.czbean.s1);
        tv2.setText("地址：xxx");
    }
}