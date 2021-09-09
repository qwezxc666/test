package com.example.project02.ui.Smart;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project02.BaseActivity;
import com.example.project02.R;
import com.example.project02.Tool;

public class NotifyActivity extends BaseActivity {

    private TextView tv1;
    private TextView tv2;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        setTitle("通知详情");

        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        iv1 = (ImageView) findViewById(R.id.iv1);
        if (Tool.notifid != -1) {
            tv1.setText(Tool.bannerlist.get(Tool.notifid).s1);
            tv2.setText(Tool.bannerlist.get(Tool.notifid).s2);
            iv1.setImageResource(Tool.bannerlist.get(Tool.notifid).s3);
        }
    }
}