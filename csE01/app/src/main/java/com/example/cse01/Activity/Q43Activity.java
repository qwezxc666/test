package com.example.cse01.Activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q43Activity extends BaseActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q43);
        setTitle("违法详情");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv1.setText(Tool.illbean.trafficOffence);
        tv2.setText(Tool.illbean.illegalSites);
        tv4.setText("处理状态：" + Tool.illbean.disposeState);
        tv3.setText("通知书号:"+Tool.illbean.noticeNo+"\n\n违章记分:"+Tool.illbean.deductMarks+"分\n\n罚款金额:"+Tool.illbean.money+"￥");
    }
}