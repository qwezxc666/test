package com.example.project07.ui.Acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.UserInforBean;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

public class ScoreActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv1;
    public TextView tv2;
    private ProgressBar bar;
    private TextView tv3;
    private TextView b4;
    private Button b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        initView();
        setTitle("我的积分");
        bar.setMax(100);
        bar.setProgress(10);
        getinfor();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        bar = (ProgressBar) findViewById(R.id.bar);
        tv3 = (TextView) findViewById(R.id.tv3);
        b4 = (TextView) findViewById(R.id.b4);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),RankActivity.class));
            }
        });
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }
    private void getinfor() {
        Okhttp.getheand("/prod-api/api/common/user/getInfo", Tool.gettoken(getthis()), new MyCallback(getthis(), UserInforBean.class) {
            @Override
            public void onFish(Object o) {
                UserInforBean userInforBean = (UserInforBean) o;
                if (userInforBean.code == 200) {
                    tv1.setText("可用积分："+userInforBean.user.score);
                    tv2.setText("累计积分："+userInforBean.user.score);
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                Tool.i=0;
                startActivity(new Intent(getApplicationContext(),Pay2Activity.class));
                break;
            case R.id.b2:
                startActivity(new Intent(getApplicationContext(),S21Activity.class));
                break;
        }
    }
}