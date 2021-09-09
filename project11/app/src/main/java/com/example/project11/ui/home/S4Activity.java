package com.example.project11.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.CommAdapter;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

public class S4Activity extends BaseActivity implements View.OnClickListener {

    private RecyclerView b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s4);
        setTitle("车辆管理");
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        b1.setAdapter(new CommAdapter<car>(getApplicationContext(), Tool.carList, R.layout.s4_item) {
            @Override
            public void convert(Vh holder, car car) {
                holder.setText(R.id.tv1, "车牌号：" + car.s1);
                holder.setText(R.id.tv2, "车位号：" + car.s2);
                holder.setText(R.id.tv3, "停车卡号：" + car.s3);
                holder.setOnListen(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.car = car;
                        Tool.carid = holder.getAdapterPosition();
                        startActivity(new Intent(getthis(), S42Activity.class));
                    }
                });
            }
        });
    }

    private void initView() {
        b1 = (RecyclerView) findViewById(R.id.b1);
        b1.setLayoutManager(new LinearLayoutManager(getthis()));

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b2:
                startActivity(new Intent(getApplicationContext(),S42Activity.class));
                break;
        }
    }

    public static class car {
        String s1, s2, s3, s4, s5, s6, s7;

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