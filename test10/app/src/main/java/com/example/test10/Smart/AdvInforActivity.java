package com.example.test10.Smart;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;
import com.example.test10.Tool;

public class AdvInforActivity extends BaseAcitivity {

    private TextView tv1;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_infor);
        setTitle("智慧社区");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv1.setText(Tool.tbbean.s1);
        iv1.setImageResource(Tool.tbbean.i1);
    }
}