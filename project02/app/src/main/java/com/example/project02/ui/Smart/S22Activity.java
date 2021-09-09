package com.example.project02.ui.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.project02.BaseActivity;
import com.example.project02.R;

public class S22Activity extends BaseActivity {

    private CardView l1;
    private TextView b1;
    private CardView l2;
    private TextView b2;
    private CardView l3;
    private TextView tv1;
    private TextView b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s22);
        setTitle("快递点详情");
        initView();
    }

    private void initView() {
        l1 = (CardView) findViewById(R.id.l1);
        b1 = (TextView) findViewById(R.id.b1);
        l2 = (CardView) findViewById(R.id.l2);
        b2 = (TextView) findViewById(R.id.b2);
        l3 = (CardView) findViewById(R.id.l3);
        tv1 = (TextView) findViewById(R.id.tv1);
        b3 = (TextView) findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S23Activity.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S23Activity.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S23Activity.class));
            }
        });
    }
}