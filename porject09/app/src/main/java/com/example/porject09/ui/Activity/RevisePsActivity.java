package com.example.porject09.ui.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.porject09.BaseActivity;
import com.example.porject09.Bean.PassSBody;
import com.example.porject09.Bean.ResultBean;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;

public class RevisePsActivity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise_ps);
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
            Toast.makeText(this, "新的密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2String = et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2String)) {
            Toast.makeText(this, "旧的密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        Okhttp.post("/prod-api/api/common/user/resetPwd", new PassSBody(et1String, et2String), new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFinsh(Object o) {
                ResultBean resultBean= (ResultBean) o;
                if (resultBean.code==200){
                    maketoast("保存成功");
                }
            }
        });

    }
}