package com.example.project11.ui.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

public class S42Activity extends BaseActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_s42);
        initView();
        setTitle("车辆个人信息");
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
        if (Tool.carid!=-1){
            et1.setText(Tool.car.s1);
            et2.setText(Tool.car.s2);
            et3.setText(Tool.car.s3);
            et4.setText(Tool.car.s4);
            et5.setText(Tool.car.s5);
            et6.setText(Tool.car.s6);
            et7.setText(Tool.car.s7);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                submit();
                finish();
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

        // TODO validate success, do something
        if (Tool.carid!=-1){
        S4Activity.car car=Tool.carList.get(Tool.carid);
        car.s1=et1String;
        car.s2=et2String;
        car.s3=et3String;
        car.s4=et4String;
        car.s5=et5String;
        car.s6=et6String;
        car.s7=et7String;
        maketoast("修改成功");

        }else {
            Tool.carList.add(new S4Activity.car(et1String,et2String,et3String,et4String,et5String,et6String,et7String));
        }

    }
}