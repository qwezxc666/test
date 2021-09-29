package com.example.test10.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.BaseAcitivity;
import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.ui.home.SmartFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S2Activity extends BaseAcitivity {

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
        List<SmartFragment.tb> tbList=new ArrayList<>(Arrays.asList(
                new SmartFragment.tb("京东快递点",12),
                new SmartFragment.tb("顺丰快递点",32)

                ));
        re.setAdapter(new CommAdapter<SmartFragment.tb>(getthis(),tbList,R.layout.s2_item) {
            @Override
            public void convert(Vh convert, SmartFragment.tb tb) {
                convert.setText(R.id.tv1,tb.s1);
                convert.setText(R.id.tv2,tb.i1+"m");
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getthis(),S22Activity.class));
                    }
                });
            }

        });
    }
}