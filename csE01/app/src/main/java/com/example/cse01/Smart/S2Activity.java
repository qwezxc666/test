package com.example.cse01.Smart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.CommAdapter;
import com.example.cse01.R;
import com.example.cse01.ui.home.SmartFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S2Activity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2);
        setTitle("快件管理");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        List<SmartFragment.Tb> tbList=new ArrayList<>(Arrays.asList(
            new SmartFragment.Tb("京东快递点","12m",R.drawable.s1),
                new SmartFragment.Tb("顺丰快递点","24m",R.drawable.s1),
                new SmartFragment.Tb("韵达快递点","40m",R.drawable.s2)
        ));
        re.setAdapter(new CommAdapter<SmartFragment.Tb>(getthis(),tbList,R.layout.s2_item) {
            @Override
            public void convert(Vh holder, SmartFragment.Tb tb) {
                holder.setText(R.id.tv1,tb.s1);
                holder.setText(R.id.tv2,tb.s2);
                holder.setGlide(R.id.iv1,tb.i1);
                holder.seton(R.id.l1,v -> {
                    startActivity(new Intent(getthis(),S22ctivity.class));
                });
            }

        });
    }
}