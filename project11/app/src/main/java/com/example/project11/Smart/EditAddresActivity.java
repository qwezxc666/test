package com.example.project11.Smart;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project11.Bean.AddAddress;
import com.example.project11.Bean.MyAdress;
import com.example.project11.Bean.PostResultBean;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

public class EditAddresActivity extends BaseActivity implements View.OnClickListener {

    private TextView textView2;
    private TextView textView5;
    private TextView textView3;
    private TextView textView4;
    private EditText et1;
    private EditText et3;
    private EditText et2;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    String s = "";
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_addres);
        initView();
        if (Tool.address==null){
            setTitle("新增收货地址");
            b1.setText("保存");
            //用户个人信息没写
        }else {
            setTitle("修改收货地址");
            et1.setText(Tool.address.name);
            et2.setText(Tool.address.phone);
            et3.setText(Tool.address.addressDetail);
            if (Tool.address.label.equals("家")) {
                rb1.setChecked(true);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                s = "家";
            }
            if (Tool.address.label.equals("公司")) {
                rb1.setChecked(true);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                s = "公司";
            }
            if (Tool.address.label.equals("学校")) {
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(true);
                rb4.setChecked(false);
                s = "学校";
            }
            if (Tool.address.label.equals("其他")) {
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(true);
                s = "其他";
            }
        }



        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "家";
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "公司";
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "学校";
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "其他";
            }
        });
    }

    private void initView() {
        textView2 = (TextView) findViewById(R.id.textView2);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        et1 = (EditText) findViewById(R.id.et1);
        et3 = (EditText) findViewById(R.id.et3);
        et2 = (EditText) findViewById(R.id.et2);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String et1String = et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1String)) {
            Toast.makeText(this, "et1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et3String = et3.getText().toString().trim();
        if (TextUtils.isEmpty(et3String)) {
            Toast.makeText(this, "et3String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2String = et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2String)) {
            Toast.makeText(this, "et2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Tool.address!=null){
            MyAdress myAdress = new MyAdress(Tool.address.id, et1String, et2String, et3String, s);
            Okhttp.put("/prod-api/api/takeout/address", Tool.getToken(getthis()), myAdress, new MyCallBack(getthis(), PostResultBean.class) {
                @Override
                public void onFinish(Object object) {
                    PostResultBean postResultBean = (PostResultBean) object;
                    if (postResultBean.code == 200) {
                        maketoast("修改成功");
                    } else {
                        maketoast("修改失败");
                    }
                }
            });
        }else {
            AddAddress myAdress = new AddAddress( et3String,s, et1String, et2String);
            Okhttp.postheand("/prod-api/api/takeout/address", Tool.getToken(getthis()), myAdress, new MyCallBack(getthis(),PostResultBean.class) {
                @Override
                public void onFinish(Object object) {
                    PostResultBean resultBean = (PostResultBean) object;

                    if (resultBean.code == 200) {
                        maketoast("保存成功");
                    } else {
                        maketoast("保存失败");
                    }
                }
            });
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                submit();
                break;
        }
    }
}