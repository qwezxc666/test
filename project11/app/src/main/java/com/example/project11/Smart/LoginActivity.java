package com.example.project11.Smart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project11.Bean.LgoinBean;
import com.example.project11.Bean.LoginBody;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.ui.Activity.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String et1String = et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1String)) {
            Toast.makeText(this, "账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2String = et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2String)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }
        Okhttp.post("/prod-api/api/login", new LoginBody(et1String, et2String), new MyCallBack(getthis(), LgoinBean.class) {
            @Override
            public void onFinish(Object object) {
                LgoinBean lgoinBean= (LgoinBean) object;
                    if (lgoinBean.code==200){
                        SharedPreferences.Editor sp=getSharedPreferences("app",MODE_PRIVATE).edit();
                        sp.putString("token",lgoinBean.token);
                        sp.apply();
                        startActivity(new Intent(getApplicationContext(),FoodActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(),lgoinBean.msg,Toast.LENGTH_LONG).show();

                    }
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                submit();
                break;
        }
    }
}