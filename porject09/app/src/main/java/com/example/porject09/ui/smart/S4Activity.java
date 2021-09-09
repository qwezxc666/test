package com.example.porject09.ui.smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

import com.example.porject09.BaseActivity;
import com.example.porject09.R;

public class S4Activity extends BaseActivity {

    private CardView l1;
    private ImageView iv1;
    private CardView l2;
    private CardView l3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s4);
        setTitle("附近回收机");
        initView();
    }

    private void initView() {
        l1 = (CardView) findViewById(R.id.l1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        l2 = (CardView) findViewById(R.id.l2);
        l3 = (CardView) findViewById(R.id.l3);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S42Activity.class));
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S42Activity.class));
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S42Activity.class));
            }
        });
    }
}