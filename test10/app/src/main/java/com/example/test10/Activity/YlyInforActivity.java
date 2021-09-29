package com.example.test10.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;
import com.example.test10.Tool;

public class YlyInforActivity extends BaseAcitivity {

    private TextView tv1;
    private TextView tv2;
    private Button b1;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yly_infor);
        setTitle("养老院详情");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        b1 = (Button) findViewById(R.id.b1);
        tv1.setText(Tool.ylybean.s1);

        iv1 = (ImageView) findViewById(R.id.iv1);
        iv1.setImageResource(Tool.ylybean.i1);
        tv2.setText(""+Tool.ylybean.s2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maketoast("预约成功");
                finish();
            }
        });
    }
}