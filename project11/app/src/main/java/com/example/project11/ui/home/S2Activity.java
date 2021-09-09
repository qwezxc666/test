package com.example.project11.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.project11.R;
import com.example.project11.ui.Activity.BaseActivity;

public class S2Activity extends BaseActivity {

    private TextView tv1;
    private CardView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2);
        initView();
        setTitle("快件管理");

    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        l1 = (CardView) findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(getthis(),S22Activity.class));
            }
        });
    }
}