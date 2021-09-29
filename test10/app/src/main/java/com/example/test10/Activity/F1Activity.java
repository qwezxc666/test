package com.example.test10.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;

public class F1Activity extends BaseAcitivity {

    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1);
        initView();
    }

    private void initView() {
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
                maketoast("提交成功");
            }
        });
    }
}