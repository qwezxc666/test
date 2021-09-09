package com.example.project02.ui.Smart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.CommAdapter;
import com.example.project02.R;
import com.example.project02.Tool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class S3Activity extends BaseActivity {

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
        re.setLayoutManager(new LinearLayoutManager(getthis()));

        b1 = (FloatingActionButton) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S32Activity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        re.setAdapter(new CommAdapter<comm>(Tool.comlist, getthis(), R.layout.s3_item) {
            @Override
            public void convert(final Vh holder, comm comm) {
                holder.setText(R.id.tv1, comm.s1);
                holder.setText(R.id.tv2, comm.s2);
                if (comm.b1!=null){
                    holder.getiv(R.id.iv1).setImageBitmap(comm.b1);
                }else {
                    holder.setimg(R.id.iv1, comm.i1);
                }
                holder.getbutton(R.id.b1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (holder.getEdit(R.id.et1).toString().isEmpty()){
                            maketoast("评论内容为空");
                        }else {
                            String s = holder.getEdit(R.id.et1).getText().toString();
                            S3Activity.comm comm1 = Tool.comlist.get(holder.getAdapterPosition());
                            comm1.s2=comm1.s2+"\n你："+s;
                            holder.setText(R.id.tv2, comm1.s2);
                            maketoast("评论成功");
                        }

                    }
                });
            }

        });
    }

    public static class comm {
        public String s1, s2;
        public int i1;
        public Bitmap b1;

        public comm(String s1, String s2, int i1, Bitmap b1) {
            this.s1 = s1;
            this.s2 = s2;
            this.i1 = i1;
            this.b1 = b1;
        }
    }
}