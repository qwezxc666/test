package com.example.project02.ui.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.project02.BaseActivity;
import com.example.project02.R;

public class S2Activity extends BaseActivity {

    private CardView l1;
    private TextView tv1;
    private TextView b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2);
        setTitle("快件管理");
        initView();
    }

    private void initView() {
        l1 = (CardView) findViewById(R.id.l1);
        tv1 = (TextView) findViewById(R.id.tv1);
        b1 = (TextView) findViewById(R.id.b1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S22Activity.class));
            }
        });
    }
}