package com.example.project11.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.CommAdapter;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class S3Activity extends BaseActivity implements View.OnClickListener {

    private RecyclerView re;
    private FloatingActionButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3);
        initView();
        setTitle("友邻社交");
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (FloatingActionButton) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        b1.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        re.setAdapter(new CommAdapter<S3Activity.com>(getthis(), Tool.comList,R.layout.s3_item) {
            @Override
            public void convert(Vh holder, com com) {
                holder.setText(R.id.tv1,com.s1);
                holder.setText(R.id.tv2,com.s2);
                holder.setText(R.id.tv3,"");
                if (com.b!=null){
                    holder.setimg(R.id.iv1,com.b);
                }else {
                    holder.setimg(R.id.iv1,com.src);
                }
                EditText editText = holder.getEdit(R.id.et1);
                holder.getbu(R.id.b1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (holder.getEdit(R.id.et1).toString().isEmpty()){
                            maketoast("请输入内容");
                        }else {
                            String a=Tool.comList.get(holder.getAdapterPosition()).s2;
                            com.s2=com.s2+"\n你:"+editText.getText().toString();
                            holder.setText(R.id.tv2,com.s2);
                            //留言是对象tostring；
                        }
                    }
                });
            }

        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                startActivity(new Intent(getApplicationContext(),S32Activity.class));
                break;
        }
    }
    public static class com{
        int src;
        String s1,s2;
        Bitmap b;

        public com(int src, String s1, String s2, Bitmap b) {
            this.src = src;
            this.s1 = s1;
            this.s2 = s2;
            this.b = b;
        }

        public com(int src, String s1, String s2) {
            this.src = src;
            this.s1 = s1;
            this.s2 = s2;
        }
    }
}