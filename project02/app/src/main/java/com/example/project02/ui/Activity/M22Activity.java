package com.example.project02.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.illagel;
import com.example.project02.CommAdapter;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;

public class M22Activity extends BaseActivity  {

    private RecyclerView re;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m22);
        initView();
        setTitle("违规记录");
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Okhttp.get("/prod-api/api/traffic/illegal/list", Tool.gettoken(getthis()), new MyCallback(getthis(), illagel.class) {
                    @Override
                    public void onFish(Object o) {
                        illagel illagel= (com.example.project02.Bean.illagel) o;
                        if (illagel.rows!=null){
                            re.setAdapter(new CommAdapter<illagel.RowsBean>(illagel.rows,getthis(),R.layout.ill_item) {

                                @Override
                                public void convert(Vh holder, final com.example.project02.Bean.illagel.RowsBean rowsBean) {
                                    holder.setText(R.id.tv2,rowsBean.illegalSites);
                                    holder.setText(R.id.tv1,rowsBean.disposeState);
                                    holder.setText(R.id.tv3,"-"+rowsBean.deductMarks+"分\t\t\t\t罚款金额："+rowsBean.money+"\n"+rowsBean.badTime);
                                    holder.setOnListen(R.id.l1, new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Tool.ill=rowsBean;
                                            startActivity(new Intent(getthis(),M23Activity.class));
                                        }
                                    });
                                }
                            });
                        }
                    }
                });
            }
        });
        get();
    }


    private void get(){
        Okhttp.get("/prod-api/api/traffic/illegal/list", Tool.gettoken(getthis()), new MyCallback(getthis(), illagel.class) {
            @Override
            public void onFish(Object o) {
                illagel illagel= (com.example.project02.Bean.illagel) o;
                if (illagel.rows!=null){
                    re.setAdapter(new CommAdapter<illagel.RowsBean>(illagel.rows.subList(0,3),getthis(),R.layout.ill_item) {

                        @Override
                        public void convert(Vh holder, final com.example.project02.Bean.illagel.RowsBean rowsBean) {
                            holder.setText(R.id.tv2,rowsBean.illegalSites);
                            holder.setText(R.id.tv1,rowsBean.disposeState);
                            holder.setText(R.id.tv3,"-"+rowsBean.deductMarks+"分\t\t\t\t罚款金额："+rowsBean.money+"\n"+rowsBean.badTime);
                            holder.setOnListen(R.id.l1, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Tool.ill=rowsBean;
                                    startActivity(new Intent(getthis(),M23Activity.class));
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}