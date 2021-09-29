package com.example.test10.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;
import com.example.test10.S23Activity;

public class S22Activity extends BaseAcitivity {

    private TextView tv3;
    private TextView tv2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s22);
        setTitle("快递点详情");
        initView();
    }

    private void initView() {
        tv3 = (TextView) findViewById(R.id.tv3);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(v -> startActivity(new Intent(getthis(), S23Activity.class)));
        tv2.setOnClickListener(v -> startActivity(new Intent(getthis(), S23Activity.class)));
        tv3.setOnClickListener(v -> startActivity(new Intent(getthis(), S23Activity.class)));
    }
}