package com.example.porject09.ui.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.porject09.BaseActivity;
import com.example.porject09.Bean.BindBody;
import com.example.porject09.Bean.ResultBean;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;

import javax.xml.transform.Result;

public class M1Activity extends BaseActivity implements View.OnClickListener {

    private TextView textView;
    private EditText editText;
    private EditText editText2;
    private TextView textView2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
        initView();
        setTitle("绑定车辆");

    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView2 = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String editTextString = editText.getText().toString().trim();
        if (TextUtils.isEmpty(editTextString)) {
            Toast.makeText(this, "editTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String editText2String = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(editText2String)) {
            Toast.makeText(this, "editText2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        Okhttp.post("/prod-api/api/traffic/car", Tool.getToken(getthis()), new BindBody(editText2String, editTextString), new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFinsh(Object o) {
                ResultBean result= (ResultBean) o;
                if (result.code==200){
                    maketoast("保存成功");
                }else {
                    maketoast(result.msg);
                }
            }
        });

    }
}