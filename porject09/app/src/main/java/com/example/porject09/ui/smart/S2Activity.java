package com.example.porject09.ui.smart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porject09.BaseActivity;
import com.example.porject09.CommAdapter;
import com.example.porject09.R;
import com.example.porject09.Tool;
import com.example.porject09.ui.home.SmartFragment;

public class S2Activity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2);
        setTitle("预约历史");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        re.setAdapter(new CommAdapter<SmartFragment.re>(getthis(), Tool.mlist,R.layout.r_item) {

            @Override
            public void convert(Vh holder, SmartFragment.re re) {
                holder.setText(R.id.tv1,re.s1);
            }
        });
    }
}