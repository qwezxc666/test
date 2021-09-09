package com.example.porject09.ui.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.porject09.BaseActivity;
import com.example.porject09.Bean.AdviseBody;
import com.example.porject09.Bean.ResultBean;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;

public class AdviseActivity extends BaseActivity implements View.OnClickListener {

    private EditText et;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advise);
        initView();
        setTitle("意见反馈");
    }

    private void initView() {
        et = (EditText) findViewById(R.id.et);
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
        String etString = et.getText().toString().trim();
        if (TextUtils.isEmpty(etString)) {
            Toast.makeText(this, "etString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        Okhttp.post("/prod-api/api/common/feedback", new AdviseBody(etString), new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFinsh(Object o) {
                ResultBean resultBean= (ResultBean) o;
                maketoast(resultBean.msg);
            }
        });

    }
}