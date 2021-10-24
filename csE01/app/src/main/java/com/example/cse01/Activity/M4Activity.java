package com.example.cse01.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.AdBody;
import com.example.cse01.Bean.ResultBean;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class M4Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m4);
        initView();
        setTitle("意见反馈");
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
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
            Toast.makeText(this, "反馈内容", Toast.LENGTH_SHORT).show();
            return;
        }

        Okhttp.post("/prod-api/api/common/feedback", Tool.gettoken(getthis())
                , new AdBody(et1String), new MyCallback(getthis(), ResultBean.class) {
                    @Override
                    public void onFish(Object o) {
                        ResultBean resultBean= (ResultBean) o;
                        maketast(resultBean.msg);
                    }
                });

    }
}