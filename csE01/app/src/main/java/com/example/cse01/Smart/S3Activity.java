package com.example.cse01.Smart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.CommAdapter;
import com.example.cse01.R;
import com.example.cse01.Tool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class S3Activity extends BaseActivity {

    private FloatingActionButton b1;
    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3);
        setTitle("友邻社交");
        initView();
    }

    private void initView() {
        b1 = (FloatingActionButton) findViewById(R.id.b1);
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        b1.setOnClickListener(v -> startActivity(new Intent(getthis(),S32Activity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        re.setAdapter(new CommAdapter<Fb>(getthis(), Tool.fbList,R.layout.fb_item) {
            @Override
            public void convert(Vh holder, Fb fb) {
                holder.setText(R.id.tv1,fb.s1);
                holder.setText(R.id.tv2,fb.s2);
                ImageView view = holder.getview(R.id.iv1);
                if (fb.bitmap==null){
                    view.setImageResource(fb.i1);
                }else {
                    view.setImageBitmap(fb.bitmap);
                }
                EditText view1 = holder.getview(R.id.et1);
                holder.seton(R.id.b1,v -> {
                    fb.s2=fb.s2+"\n你："+view1.getText().toString();
                    holder.setText(R.id.tv2,fb.s2);
                    view1.setText("");
                });
            }
        });
    }

    public static class Fb{
        public String s1,s2;
        public  int i1;
        public Bitmap bitmap;

        public Fb(String s1, String s2, int i1, Bitmap bitmap) {
            this.s1 = s1;
            this.s2 = s2;
            this.i1 = i1;
            this.bitmap = bitmap;
        }
    }
}