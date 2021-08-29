package com.example.project07.ui.Acitvity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project07.BaseActivity;
import com.example.project07.R;

public class RemoveActivity extends BaseActivity {

    private EditText et1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        setTitle("场内找车");

        initView();
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}