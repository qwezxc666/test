package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.cse01.BaseActivity;
import com.example.cse01.MainActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q27Activity extends BaseActivity {

    private TextView tv1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q27);
        setTitle("挂号信息");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        b1 = (Button) findViewById(R.id.b1);
        tv1.setText("预约科室 ："+ Tool.name +"\n\n门诊类型：普通号\n\n预约时间：2020-9-21周一 \n\n下午 14:00");
        b1.setOnClickListener(v -> startActivity(new Intent(getthis(), MainActivity.class)));
    }
}