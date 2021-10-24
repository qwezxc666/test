package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q32Activity extends BaseActivity {

    private ImageView iv1;
    private TextView tv2;
    private Button b1;
    private Button b2;
    private TextView tv1;
    private TextView tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q32);
        setTitle("房源详情");
        initView();
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        Tool.setGlide(getthis(), Tool.hobean.pic, iv1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(Tool.hobean.sourceName);
        tv2.setText("房源类型:" + Tool.hobean.houseType + "\t\t\t建筑面积:" + Tool.hobean.areaSize + "m/2\t\t\t房源单价:" + Tool.hobean.price);
        b1.setOnClickListener(v -> finish());
        b2.setOnClickListener(v -> {
            startActivityForResult(new Intent(Intent.ACTION_DIAL).setType("tel:" + Tool.hobean.tel), 666);
        });
        tv5 = (TextView) findViewById(R.id.tv5);
        tv5.setText(Tool.hobean.description);

    }
}