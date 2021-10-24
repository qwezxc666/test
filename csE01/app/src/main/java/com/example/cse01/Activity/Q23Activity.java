package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.AllCardBean;
import com.example.cse01.Bean.UserInforBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q23Activity extends BaseActivity {

    private CardView l1;
    private TextView t1;
    private RecyclerView re;
    private CardView l3;
    private CardView l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q23);
        setTitle("就诊人卡片");
        initView();
        getinfor();
    }

    private void initView() {
        l1 = (CardView) findViewById(R.id.l1);
        t1 = (TextView) findViewById(R.id.t1);
        re = (RecyclerView) findViewById(R.id.re);
        l3 = (CardView) findViewById(R.id.l3);
        l2 = (CardView) findViewById(R.id.l2);
        l1.setOnClickListener(v -> startActivity(new Intent(getthis(),Q24Activity.class)));
        l3.setOnClickListener(v -> {
            l2.setVisibility(View.VISIBLE);
        });
        l2.setOnClickListener(v -> {
            startActivity(new Intent(getthis(),Q24Activity.class));
        });
        Okhttp.get("/prod-api/api/hospital/patient/list", Tool.gettoken(getthis()),
                new MyCallback(getthis(), AllCardBean.class) {
                    @Override
                    public void onFish(Object o) {
                        AllCardBean allCardBean= (AllCardBean) o;
                        re.setLayoutManager(new LinearLayoutManager(getthis()));
                        re.setAdapter(new CommAdapter<AllCardBean.RowsBean>(getthis(),allCardBean.rows,R.layout.allcard_item) {
                            @Override
                            public void convert(Vh holder, AllCardBean.RowsBean rowsBean) {
                                holder.setText(R.id.tv1,"姓名:"+rowsBean.name+"\n\n身份证号:"+rowsBean.cardId+"\n\n电话号码:"+rowsBean.tel);
                                holder.seton(R.id.iv1,v -> startActivity(new Intent(getthis(),Q25Activity.class)));
                            }

                        });
                    }
                });
    }
    private void getinfor(){
        Okhttp.get("/prod-api/api/common/user/getInfo",Tool.gettoken(getthis()), new MyCallback(getthis(), UserInforBean.class) {
            @Override
            public void onFish(Object o) {
                UserInforBean userInforBean= (UserInforBean) o;
                if (userInforBean.code==200){
                    t1.setText("姓名:"+userInforBean.user.nickName+"\n\n身份证号:"+userInforBean.user.idCard+"\n\n电话号码:"+userInforBean.user.phonenumber);

                }else {
                    startActivity(new Intent(getthis(), LoginActivity.class));
                }

            }
        });
    }
}