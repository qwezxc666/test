package com.example.test10.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.BaseAcitivity;
import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.Tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F3Activity extends BaseAcitivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3);
        setTitle("搜到求助");

        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        List<infor> inforList=new ArrayList<>(Arrays.asList(
                new infor("张三","求助","2021年9月29日11:08:57","123213"),
                new infor("张2","求助","2021年9月24日11:08:57","2321312"),
                new infor("张1","求助","2021年9月23日11:08:57","2132141")
        ));
        re.setAdapter(new CommAdapter<infor>(getthis(),inforList,R.layout.jz_item) {
            @Override
            public void convert(Vh convert, infor infor) {
                convert.setText(R.id.tv1,infor.s1);
                convert.setText(R.id.tv2,infor.s2);
                convert.setText(R.id.tv3,infor.s3);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.jzbean=infor;
                        startActivity(new Intent(getthis(),F32Activity.class));
                    }
                });

            }

        });
    }
    public static class infor{
        public String s1,s2,s3,s4;

        public infor(String s1, String s2, String s3, String s4) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.s4 = s4;
        }
    }
}