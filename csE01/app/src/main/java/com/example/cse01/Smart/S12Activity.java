package com.example.cse01.Smart;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class S12Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s12);
        initView();
        if (Tool.cardbaen!=null) {
            setTitle("修改车辆信息");
            et1.setText(Tool.cardbaen.s1);
            et2.setText(Tool.cardbaen.s2);
            et3.setText(Tool.cardbaen.s3);
            et4.setText(Tool.cardbaen.s4);
            et5.setText(Tool.cardbaen.s5);
            et6.setText(Tool.cardbaen.s6);
            et7.setText(Tool.cardbaen.s7);

        } else {
            setTitle("新添车辆信息");
        }
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
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

        String et4String = et4.getText().toString().trim();
        if (TextUtils.isEmpty(et4String)) {
            Toast.makeText(this, "et4String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et5String = et5.getText().toString().trim();
        if (TextUtils.isEmpty(et5String)) {
            Toast.makeText(this, "et5String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et6String = et6.getText().toString().trim();
        if (TextUtils.isEmpty(et6String)) {
            Toast.makeText(this, "et6String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et7String = et7.getText().toString().trim();
        if (TextUtils.isEmpty(et7String)) {
            Toast.makeText(this, "et7String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Tool.id!=-1){
            S1Activity.card card = Tool.cardList.get(Tool.id);
            card.s1=et1String;
            card.s2=et1String;
            card.s3=et3String;
            card.s4=et4String;
            card.s5=et5String;
            card.s6=et6String;
            card.s7=et7String;
        }

    }
}