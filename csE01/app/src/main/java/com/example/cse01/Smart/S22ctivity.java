package com.example.cse01.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;

public class S22ctivity extends BaseActivity {

    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s22ctivity);
        setTitle("快件管理");
        initView();
    }

    private void initView() {
        t1 = (TextView) findViewById(R.id.t1);
        t1.setOnClickListener(v -> {
            startActivity(new Intent(getthis(),S23Activity.class));
        });
    }
}