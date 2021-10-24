package com.example.cse01.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.Re2Body;
import com.example.cse01.Bean.ResultBean;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class M3Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3);
        initView();
        setTitle("修改密码");
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
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
            Toast.makeText(this, "旧密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2String = et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2String)) {
            Toast.makeText(this, "新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        Okhttp.put("/prod-api/api/common/user/resetPwd", Tool.gettoken(getthis()),
                new Re2Body(et2String, et1String), new MyCallback(getthis(), ResultBean.class) {
                    @Override
                    public void onFish(Object o) {
                        ResultBean resultBean= (ResultBean) o;
                        maketast(resultBean.msg);
                    }
                });

    }
}