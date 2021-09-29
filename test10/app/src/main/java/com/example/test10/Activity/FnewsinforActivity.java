package com.example.test10.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;
import com.example.test10.Tool;

public class FnewsinforActivity extends BaseAcitivity {

    private ImageView iv1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fnewsinfor);
        setTitle("新闻详情");
        initView();
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1.setImageResource(Tool.newbean.i1);
        tv1.setText(Tool.newbean.s1);

    }
}