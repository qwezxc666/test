package com.example.project02.ui.Smart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project02.BaseActivity;
import com.example.project02.R;

public class S12Activity extends BaseActivity {

    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s12);
        setTitle("意见反馈");
        initView();
    }

    private void initView() {
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maketoast("保存成功");
            }
        });
    }
}