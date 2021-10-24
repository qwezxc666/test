package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;

public class Q4Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private Spinner sp;
    private EditText et2;
    private EditText et3;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        initView();
        setTitle("违章查询");
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        sp = (Spinner) findViewById(R.id.sp);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String et1String = et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1String)) {
            Toast.makeText(this, "et1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2String = et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2String)) {
            Toast.makeText(this, "et2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et3String = et3.getText().toString().trim();
        if (TextUtils.isEmpty(et3String)) {
            Toast.makeText(this, "et3String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        startActivity(new Intent(getthis(),Q42Activity.class));

    }
}