package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q26Activity extends BaseActivity {

    private Button b1;
    private Button b2;
    private CardView l1;
    private TextView t1;
    private Button b3;
    private TextView l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q26);
        setTitle("专家/普通可挂号");
        initView();
    }

    private void initView() {
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        l1 = (CardView) findViewById(R.id.l1);
        t1 = (TextView) findViewById(R.id.t1);
        b3 = (Button) findViewById(R.id.b3);
        l2 = (TextView) findViewById(R.id.l2);
        b1.setOnClickListener(v -> {
            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.GONE);
        });
        b2.setOnClickListener(v -> {
            l2.setVisibility(View.VISIBLE);
            l1.setVisibility(View.GONE);
        });
        t1.setText("2020-9-21周一\n\n下午14:00\n\n"+ Tool.name);
        b3.setOnClickListener(v -> startActivity(new Intent(getthis(),Q27Activity.class)));
    }
}