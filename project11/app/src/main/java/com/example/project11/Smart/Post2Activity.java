package com.example.project11.Smart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project11.Bean.Order;
import com.example.project11.Bean.Post2Bean;
import com.example.project11.Bean.PostResultBean;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

import java.math.BigDecimal;

public class Post2Activity extends BaseActivity implements View.OnClickListener {

    private TextView tv1;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv2;
    private Button b1;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private String text;
    private BigDecimal i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post2);
        initView();
        setTitle("支付页面");
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv2 = (TextView) findViewById(R.id.tv2);
        b1 = (Button) findViewById(R.id.b1);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);

        b1.setOnClickListener(this);
        tv1.setText(Tool.ordernum);
        getinfro();
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setChecked(true);
                cb2.setChecked(false);
                cb3.setChecked(false);
                text="电子支付";
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setChecked(false);
                cb2.setChecked(true);
                cb3.setChecked(false);
                text="微信";
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setChecked(false);
                cb2.setChecked(false);
                cb3.setChecked(true);
                text="支付宝";
            }
        });
    }
    private void getinfro(){
        Okhttp.getheand("/prod-api/api/takeout/order/" + Tool.ordernum, Tool.getToken(getthis()), new MyCallBack(getthis(), Order.class) {
            @Override
            public void onFinish(Object object) {
                Order order= (Order) object;
                if (order.code==200){
                    i=((Order) object).data.orderInfo.amount;
                    tv2.setText("￥"+i.toString());
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                post();
                finish();
                break;
        }
    }
    private void post(){
        Okhttp.postheand("/prod-api/api/takeout/pay", Tool.getToken(getApplicationContext()), new Post2Bean(Tool.ordernum, i.toString()), new MyCallBack(getthis(), PostResultBean.class) {
            @Override
            public void onFinish(Object object) {
                PostResultBean postResultBean= (PostResultBean) object;
                if (postResultBean.code==200){
                    Toast.makeText(getthis(),"支付成功",Toast.LENGTH_LONG).show();
                    Tool.FOOD_MAP.clear();

                    finish();
                }else {
                    Toast.makeText(getthis(),"支付失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}