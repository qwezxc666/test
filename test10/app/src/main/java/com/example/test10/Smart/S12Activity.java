package com.example.test10.Smart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test10.BaseAcitivity;
import com.example.test10.R;

public class S12Activity extends BaseAcitivity {

    private EditText et1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s12);
        setTitle("意见反馈");
        initView();
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maketoast("反馈成功");
                finish();
            }
        });
    }
}