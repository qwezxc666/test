package com.example.project11.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project11.R;
import com.example.project11.ui.Activity.BaseActivity;

public class S1Activity extends BaseActivity implements View.OnClickListener {

    private TextView tv1;
    private Button b1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1);
        initView();
        setTitle("物业服务");
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + tv1.getText().toString().toString())));

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + tv1.getText().toString())));

            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + tv1.getText().toString().toString())));

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + tv1.getText().toString().toString())));

            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + tv1.getText().toString().toString())));

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                Intent intent = new Intent(getApplicationContext(), S12Activity.class);
                startActivity(intent);
                break;
        }
    }
}