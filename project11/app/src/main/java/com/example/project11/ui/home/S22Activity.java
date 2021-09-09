package com.example.project11.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.project11.R;
import com.example.project11.ui.Activity.BaseActivity;

public class S22Activity extends BaseActivity {

    private TextView tv1;
    private CardView l1;
    private TextView tv2;
    private TextView tv3;
    private TextView b1;
    private TextView b3;
    private TextView b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s22);
        initView();
        setTitle("包裹信息");
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        l1 = (CardView) findViewById(R.id.l1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        b1 = (TextView) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(), S23Activity.class));
            }
        });
        b3 = (TextView) findViewById(R.id.b3);

        b2 = (TextView) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(), S23Activity.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(), S23Activity.class));
            }
        });

    }
}