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
import com.example.test10.Smart.S3Activity;
import com.example.test10.Tool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class F5Activity extends BaseAcitivity {

    private RecyclerView re;
    private FloatingActionButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f5);
        setTitle("案例发布");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (FloatingActionButton) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),F52Activity.class));
            }
        });
        re.setLayoutManager(new LinearLayoutManager(getthis()));

    }

    @Override
    protected void onResume() {
        super.onResume();
        re.setAdapter(new CommAdapter<S3Activity.fb>(getthis(), Tool.fbList,R.layout.fb_item) {
            @Override
            public void convert(Vh convert, S3Activity.fb fb) {
                convert.setText(R.id.tv1,fb.s1);
                convert.setText(R.id.tv2,fb.s2);
                convert.setGlide(R.id.iv1,fb.i1);

            }

        });
    }
}