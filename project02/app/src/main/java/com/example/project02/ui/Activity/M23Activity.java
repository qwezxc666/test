package com.example.project02.ui.Activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.project02.BaseActivity;
import com.example.project02.R;
import com.example.project02.Tool;

public class M23Activity extends BaseActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m23);
        setTitle("详情页面");

        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        if (Tool.ill!=null){
            tv1.setText("违法行为："+Tool.ill.trafficOffence);
            tv3.setText(Tool.ill.illegalSites);
            tv2.setText("通知书号："+Tool.ill.noticeNo);
            tv4.setText("-"+Tool.ill.deductMarks+"分\t\t\t\t罚款金额："+Tool.ill.money+"\n"+Tool.ill.badTime);
        }
    }
}