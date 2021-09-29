package com.example.test10.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;
import com.example.test10.Tool;

public class F22Activity extends BaseAcitivity {

    private ImageView iv1;
    private TextView tv1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f22);
        setTitle("扶贫案例详情");
        initView();
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv1 = (TextView) findViewById(R.id.tv1);
        b1 = (Button) findViewById(R.id.b1);
        iv1.setImageResource(Tool.fpbean.i1);
        tv1.setText(Tool.fpbean.s1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
                maketoast("点赞成功");
            }
        });
    }
}