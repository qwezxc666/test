package com.example.test10.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.BaseAcitivity;
import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.Tool;

public class S4Activity extends BaseAcitivity {

    private RecyclerView re;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s4);
        setTitle("车辆管理");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tool.carbean=null;
                startActivity(new Intent(getthis(),CarInforActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        re.setAdapter(new CommAdapter<car>(getthis(), Tool.carList,R.layout.car_item) {
            @Override
            public void convert(Vh convert, car car) {
                convert.setText(R.id.tv1,"车牌号码：\t\t"+car.s1);
                convert.setText(R.id.tv2,"车主姓名：\t\t"+car.s2);
                convert.setText(R.id.tv3,"车主手机号：\t\t"+car.s3);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.carbean=car;
                        Tool.carid=convert.getAdapterPosition();
                        startActivity(new Intent(getthis(),CarInforActivity.class));
                    }
                });
            }
        });
    }

    public static class car{
        public String s1,s2,s3,s4,s5,s6,s7;

        public car(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.s4 = s4;
            this.s5 = s5;
            this.s6 = s6;
            this.s7 = s7;
        }
    }
}