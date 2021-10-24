package com.example.cse01.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.CardBody;
import com.example.cse01.Bean.ResultBean;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q24Activity extends BaseActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q24);
        initView();
        setTitle("创建就诊人卡片");
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
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

        Okhttp.post("/prod-api/api/hospital/patient", Tool.gettoken(getthis()),
                new CardBody(et6String, et4String, et3String, et1String, et2String, et5String)
                , new MyCallback(getthis(), ResultBean.class) {
                    @Override
                    public void onFish(Object o) {
                        ResultBean resultBean= (ResultBean) o;
                        maketast(resultBean.msg);
                        if (resultBean.code==200){
                            finish();
                        }
                    }
                });

    }
}