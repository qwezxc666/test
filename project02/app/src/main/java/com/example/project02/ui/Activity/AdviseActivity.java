package com.example.project02.ui.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.AdviseBody;
import com.example.project02.Bean.ResultBean;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;

import javax.xml.transform.Result;

public class AdviseActivity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advise);
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
            Toast.makeText(this, "et1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        Okhttp.post("/prod-api/api/common/feedback", new AdviseBody(et1String), new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFish(Object o) {
                ResultBean resultBean= (ResultBean) o;
                if (resultBean.code.equals(200)){
                    maketoast("提交成功 ");
                }else {
                    maketoast(resultBean.msg);
                }
            }
        });

    }
}