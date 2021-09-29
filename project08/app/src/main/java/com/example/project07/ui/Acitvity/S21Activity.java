package com.example.project07.ui.Acitvity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.ResultBean;
import com.example.project07.Bean.UserInforBean;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

public class S21Activity extends BaseActivity {

    private TextView tv1;
    private Button b1;
    private Button b2;
    private Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s21);
        setTitle("积分商城");
        initView();
        getinfor();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buy(4);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buy(5);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buy(6);
            }
        });
    }
    private void getinfor() {
        Okhttp.getheand("/prod-api/api/common/user/getInfo", Tool.gettoken(getthis()), new MyCallback(getthis(), UserInforBean.class) {
            @Override
            public void onFish(Object o) {
                UserInforBean userInforBean = (UserInforBean) o;
                if (userInforBean.code == 200) {
                    tv1.setText("可用积分："+userInforBean.user.score);

                }
            }
        });
    }
    private void buy(int i){
        Okhttp.postheand("/prod-api/api/park/score/consume/" + i, Tool.gettoken(getthis()), "", new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFish(Object o) {
                ResultBean resultBean= (ResultBean) o;
                maketoast(resultBean.msg);
            }
        });
    }
}