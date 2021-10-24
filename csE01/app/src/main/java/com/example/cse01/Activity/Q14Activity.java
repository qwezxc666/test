package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q14Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private Button b1;
    private Button b2;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q14);
        initView();
        setTitle("智慧巴士");
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        t1 = (TextView) findViewById(R.id.t1);
        t1.setText(Tool.busbean.first+"-->"+Tool.busbean.end);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                finish();
                break;
            case R.id.b2:
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

        String et4String = et4.getText().toString().trim();
        if (TextUtils.isEmpty(et4String)) {
            Toast.makeText(this, "et4String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Tool.person = new person(et1String, et2String, et3String, et4String);
        startActivity(new Intent(getthis(),Q15Activity.class));
    }

    public static class person {
        public String s1;
        public String s2;
        public String s3;

        public person(String s1, String s2, String s3, String s4) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.s4 = s4;
        }

        public String s4;

    }
}