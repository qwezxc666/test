package com.example.porject09.ui.smart;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.porject09.BaseActivity;
import com.example.porject09.R;
import com.example.porject09.Tool;
import com.example.porject09.ui.home.SmartFragment;

public class S3Activity extends BaseActivity implements View.OnClickListener {

    private TextView textView9;
    private EditText et3;
    private EditText et1;
    private TextView textView10;
    private TextView textView11;
    private EditText et4;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3);
        initView();
        setTitle("信息预留");
        if (Tool.infor==null){

        }else {
            et1.setText(Tool.infor.s1);
            et3.setText(Tool.infor.s2);
            et4.setText(Tool.infor.s3);
        }
    }

    private void initView() {
        textView9 = (TextView) findViewById(R.id.textView9);
        et3 = (EditText) findViewById(R.id.et3);
        et1 = (EditText) findViewById(R.id.et1);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        et4 = (EditText) findViewById(R.id.et4);
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
        String et3String = et3.getText().toString().trim();
        if (TextUtils.isEmpty(et3String)) {
            Toast.makeText(this, "et3String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et1String = et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1String)) {
            Toast.makeText(this, "et1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et4String = et4.getText().toString().trim();
        if (TextUtils.isEmpty(et4String)) {
            Toast.makeText(this, "et4String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        maketoast("保存成功");
        if (Tool.infor==null){
            Tool.infor=new SmartFragment.infor(et1String,et3String,et4String);

        }
        finish();

    }
}