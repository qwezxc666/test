package com.example.test10.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;

public class Y3Activity extends BaseAcitivity {

    private CardView l1;
    private ImageView iv1;
    private CardView l2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y3);
        setTitle("巡检记录");

        initView();
    }

    private void initView() {
        l1 = (CardView) findViewById(R.id.l1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        l2 = (CardView) findViewById(R.id.l2);
        b1 = (Button) findViewById(R.id.b1);
    }
}