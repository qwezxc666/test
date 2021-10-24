package com.example.cse01.ui.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class TgActivity extends BaseActivity {

    private TextView tv1;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tg);
        setTitle("推广详情");

        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv1.setText(Tool.tbbean.s1);
        iv1.setImageResource(Tool.tbbean.i1);
    }
}