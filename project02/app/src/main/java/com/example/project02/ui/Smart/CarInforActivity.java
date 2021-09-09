package com.example.project02.ui.Smart;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project02.BaseActivity;
import com.example.project02.R;
import com.example.project02.Tool;
import com.example.project02.ui.home.SmartFragment;

public class CarInforActivity extends BaseActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_car_infor);

        initView();
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
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        if (Tool.carBean != null) {
            setTitle("完善车辆详情");
            et1.setText(Tool.carBean.s1);
            et2.setText(Tool.carBean.s2);
            et3.setText(Tool.carBean.s3);
            et4.setText(Tool.carBean.s4);
            et5.setText(Tool.carBean.s5);
            et6.setText(Tool.carBean.s6);
            et7.setText(Tool.carBean.s7);
        } else {
            setTitle("新增个人车辆信息卡");
        }
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
        SmartFragment.car car = new SmartFragment.car(et1String, et2String, et3String, et4String, et5String, et6String, et7String);
        if (Tool.carBean!=null){
            SmartFragment.car mycar = Tool.carlist.get(Tool.carid);
            mycar.s1 = et1String;
            mycar.s2 = et2String;
            mycar.s3 = et3String;
            mycar.s4 = et4String;
            mycar.s5 = et5String;
            mycar.s6 = et6String;
            mycar.s7 = et7String;
        }else {
            Tool.carlist.add(car);
        }

    }
}