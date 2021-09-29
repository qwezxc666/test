package com.example.test10.Activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;
import com.example.test10.Tool;

public class F32Activity extends BaseAcitivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f32);
        setTitle("求助详情");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv1.setText(Tool.jzbean.s2);
        tv2.setText(Tool.jzbean.s3);
        tv3.setText("联系电话："+Tool.jzbean.s4+"\n"+Tool.jzbean.s1);
    }
}