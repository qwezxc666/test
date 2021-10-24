package com.example.cse01.Smart;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;

public class S42Activity extends BaseActivity {

    private EditText et1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s42);
        setTitle("意见反馈");
        initView();
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(v -> {
            finish();
            maketast("提交成功");
        });
    }
}