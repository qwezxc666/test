package com.example.cse01.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.CommAdapter;
import com.example.cse01.R;
import com.example.cse01.Tool;
import com.example.cse01.ui.home.SmartFragment;

public class S1Activity extends BaseActivity {

    private RecyclerView re;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1);
        setTitle("车辆管理");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        b1.setOnClickListener(v -> {
            Tool.id=-1;
            startActivity(new Intent(getthis(),S12Activity.class));
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        re.setAdapter(new CommAdapter<card>(getthis(), Tool.cardList,R.layout.car_item) {
            @Override
            public void convert(Vh holder, card tb) {
                holder.setText(R.id.tv1,"车牌号码:"+tb.s1);
                holder.setText(R.id.tv2,"车主姓名:"+tb.s4);
                holder.setText(R.id.tv3,"手机号码:"+tb.s5);
                holder.seton(R.id.l1,v -> {
                    Tool.cardbaen=tb;
                    Tool.cardi=holder.getAdapterPosition();
                    startActivity(new Intent(getthis(),S12Activity.class));
                });
            }
        });
    }

    public static class  card{
        public String s1,s2,s3,s4,s5,s6,s7;

        public card(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
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