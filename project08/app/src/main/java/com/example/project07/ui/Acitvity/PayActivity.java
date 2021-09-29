package com.example.project07.ui.Acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.ResultBean;
import com.example.project07.Bean.UserInforBean;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

public class PayActivity extends BaseActivity implements View.OnClickListener {

    private Button b1;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private EditText et1;
    private TextView money;
    private CheckBox cb1;
    private CheckBox cb2;
    private int m;
    private String type;
    private Button b2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();
        setTitle("钱包充值");
        getinfor();
    }

    private void getinfor() {
        Okhttp.getheand("/prod-api/api/common/user/getInfo", Tool.gettoken(getthis()), new MyCallback(getthis(), UserInforBean.class) {
            @Override
            public void onFish(Object o) {
                UserInforBean userInforBean = (UserInforBean) o;
                if (userInforBean.code == 200) {
                    tv1.setText("账户余额："+userInforBean.user.balance);

                }
            }
        });
    }

    private void initView() {
        b1 = (Button) findViewById(R.id.b1);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        rb5 = (RadioButton) findViewById(R.id.rb5);
        et1 = (EditText) findViewById(R.id.et1);
        money = (TextView) findViewById(R.id.money);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);

        b1.setOnClickListener(this);
        cb1.setChecked(true);
        if (cb1.isChecked()) {
            type = "微信支付";
            cb1.setChecked(true);
            cb2.setChecked(false);
        }
        if (cb2.isChecked()) {
            type = "支付宝";
            cb1.setChecked(false);
            cb2.setChecked(true);
        }
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m = Integer.parseInt(rb1.getText().toString());

            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m = Integer.parseInt(rb2.getText().toString());

            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m = Integer.parseInt(rb3.getText().toString());

            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m = Integer.parseInt(rb4.getText().toString());

            }
        });
        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m = Integer.parseInt(rb5.getText().toString());

            }
        });
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String a = s.toString();
                m = Integer.valueOf(s.toString());
//                money.setText(m);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                startActivity(new Intent(getApplicationContext(), Pay2Activity.class));
                break;
            case R.id.b2:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String et1String = et1.getText().toString().trim();
//        if (TextUtils.isEmpty(et1String)) {
//            Toast.makeText(this, "请输入其他金额", Toast.LENGTH_SHORT).show();
//            return;
//        }

        // TODO validate success, do something
        Log.e("qwe", m + "");
//        Okhttp.post("/prod-api/api/park/recharge/pay", Tool.gettoken(getthis()), type, m, new MyCallback(getthis(), ResultBean.class) {
//            @Override
//            public void onFish(Object o) {
//                ResultBean resultBean = (ResultBean) o;
//                maketoast(resultBean.msg);
//                if (resultBean.code == 200) {
//                    getinfor();
//                }
//            }
//        });

    }
}