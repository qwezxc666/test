package com.example.test10.Smart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.BaseAcitivity;
import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.Tool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class S3Activity extends BaseAcitivity {

    private RecyclerView re;
    private FloatingActionButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3);
        setTitle("友邻社交");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (FloatingActionButton) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));

    }

    @Override
    protected void onResume() {
        super.onResume();
        re.setAdapter(new CommAdapter<fb>(getthis(), Tool.fbList,R.layout.fb_item) {
            @Override
            public void convert(Vh convert, fb fb) {
                convert.setText(R.id.tv1,fb.s1);
                convert.setText(R.id.tv2,fb.s2);
                convert.seton(R.id.b1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fb.s2=fb.s2+"\n你："+convert.getet(R.id.et1).getText().toString();
                        convert.setText(R.id.tv2,fb.s2);
                        convert.getet(R.id.et1).setText("");
                    }
                });
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S32Activity.class));
            }
        });
    }

    public static class fb{
        public String s1,s2;
        public int i1;
        public Bitmap bitmap;

        public fb(String s1, String s2, int i1, Bitmap bitmap) {
            this.s1 = s1;
            this.s2 = s2;
            this.i1 = i1;
            this.bitmap = bitmap;
        }
    }
}