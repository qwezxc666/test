package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.OrderBody;
import com.example.cse01.Bean.ResultBean;
import com.example.cse01.MainActivity;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q15Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private Button b1;
    private Button b2;
    private EditText et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q15);
        initView();
        setTitle("智慧巴士");
        if (Tool.person!=null){
            et1.setText(Tool.person.s1);
            et2.setText(Tool.person.s2);
            et3.setText(Tool.person.s3);
            et4.setText(Tool.person.s4);
            et5.setText(Tool.time);
        }

    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        et5 = (EditText) findViewById(R.id.et5);
        et5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                finish();
                break;
            case R.id.b2:
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
        Okhttp.post("/prod-api/api/bus/order", Tool.gettoken(getthis()),
                new OrderBody(et1String, et2String, Tool.busbean.price + "", Tool.busbean.name, 0)
                , new MyCallback(getthis(), ResultBean.class) {
                    @Override
                    public void onFish(Object o) {
                        ResultBean resultBean= (ResultBean) o;
                        maketast(resultBean.msg);
                        if (resultBean.code==200){
                            Intent intent=new Intent(getthis(), MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });
    }


}