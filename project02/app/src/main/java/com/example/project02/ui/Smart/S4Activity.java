package com.example.project02.ui.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.CommAdapter;
import com.example.project02.R;
import com.example.project02.Tool;
import com.example.project02.ui.home.SmartFragment;

public class S4Activity extends BaseActivity {

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
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        re.setAdapter(new CommAdapter<SmartFragment.car>(Tool.carlist,getthis(),R.layout.car_item) {
            @Override
            public void convert(final Vh holder, final SmartFragment.car car) {
                holder.setText(R.id.tv1,car.s1);
                holder.setText(R.id.tv2,car.s4);
                holder.setOnListen(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.carid=holder.getAdapterPosition();
                        Tool.carBean=car;
                        startActivity(new Intent(getthis(),CarInforActivity.class));
                    }
                });
            }
        });
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),CarInforActivity.class));
            }
        });
    }
}