package com.example.project07.ui.Acitvity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.UserBody;
import com.example.project07.Bean.UserResult;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setTitle("登入页面");
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
            Toast.makeText(this, "账号：", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2String = et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2String)) {
            Toast.makeText(this, "密码：", Toast.LENGTH_SHORT).show();
            return;
        }
//        UserBody userBody = new UserBody(et1String, et2String);
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("username",et1String);
//            jsonObject.put("password",et2String);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        Okhttp.post("/prod-api/api/login", new UserBody(et1String, et2String), new MyCallback(getthis(), UserResult.class) {
                    @Override
                    public void onFish(Object o) {
                        UserResult data = (UserResult) o;
                        Log.e("qwe",data.code+"-"+data.msg);
                        if (data.code == 200) {

                        } else {

                        }
                    }


                });


    }

    }
