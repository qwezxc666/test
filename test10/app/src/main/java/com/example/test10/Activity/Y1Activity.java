package com.example.test10.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;

public class Y1Activity extends BaseAcitivity {

    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y1);
        setTitle("健康评估");
        initView();
    }

    private void initView() {
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),Y12Activity.class));
            }
        });
    }
}