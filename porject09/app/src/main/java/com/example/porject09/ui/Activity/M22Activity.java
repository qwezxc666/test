package com.example.porject09.ui.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.porject09.BaseActivity;
import com.example.porject09.Bean.ResultBean;
import com.example.porject09.Bean.idCarBoyd;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;

public class M22Activity extends BaseActivity implements View.OnClickListener {

    private TextView textView8;
    private EditText et1;
    private EditText et2;
    private EditText et6;
    private TextView textView16;
    private TextView textView17;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m22);
        initView();
        setTitle("驾驶证绑定");
        getcar();
    }

    private void getcar() {

    }

    private void initView() {
        textView8 = (TextView) findViewById(R.id.textView8);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et6 = (EditText) findViewById(R.id.et6);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        final String et1String = et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1String)) {
            Toast.makeText(this, "et1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        final String et2String = et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2String)) {
            Toast.makeText(this, "et2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        final String et6String = et6.getText().toString().trim();
        if (TextUtils.isEmpty(et6String)) {
            Toast.makeText(this, "et6String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        idCarBoyd idCarBoyd = new idCarBoyd(et6String,et1String,et2String);

        Okhttp.post("/prod-api/api/traffic/license", Tool.getToken(getthis()),idCarBoyd , new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFinsh(Object o) {
                ResultBean resultBean = (ResultBean) o;
                if (resultBean.code == 200) {
                    maketoast("保存成功");
                }else {
                    maketoast(resultBean.msg);
                }
            }
        });

    }
}