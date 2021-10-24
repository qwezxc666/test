package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.LLBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q42Activity extends BaseActivity {

    private RecyclerView re;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q42);
        setTitle("违章记录");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/traffic/illegal/list", Tool.gettoken(getthis()), new MyCallback(getthis(), LLBean.class) {
            @Override
            public void onFish(Object o) {
                LLBean llBean= (LLBean) o;
                if (llBean.code==200){
                    re.setAdapter(new CommAdapter<LLBean.RowsBean>(getthis(),llBean.rows.subList(0,5),R.layout.ll_item) {
                        @Override
                        public void convert(Vh holder, LLBean.RowsBean rowsBean) {
                            holder.setText(R.id.tv1,rowsBean.trafficOffence);
                            holder.setText(R.id.tv2,rowsBean.illegalSites);
                            holder.setText(R.id.tv3,rowsBean.badTime+"\n\n违章记分:"+rowsBean.deductMarks+"分\t\t\t罚款金额:"+rowsBean.money+"\n\n处理状态:"+rowsBean.disposeState);
                            holder.seton(R.id.l1,v -> {
                                Tool.illbean=rowsBean;
                                startActivity(new Intent(getthis(),Q43Activity.class));
                            });
                        }
                    });
                }

            }
        });

        b1.setOnClickListener(v -> {
            Okhttp.get("/prod-api/api/traffic/illegal/list", Tool.gettoken(getthis()), new MyCallback(getthis(), LLBean.class) {
                @Override
                public void onFish(Object o) {
                    LLBean llBean= (LLBean) o;
                    re.setAdapter(new CommAdapter<LLBean.RowsBean>(getthis(),llBean.rows,R.layout.ll_item) {
                        @Override
                        public void convert(Vh holder, LLBean.RowsBean rowsBean) {
                            holder.setText(R.id.tv1,rowsBean.trafficOffence);
                            holder.setText(R.id.tv2,rowsBean.illegalSites);
                            holder.setText(R.id.tv3,rowsBean.badTime+"\n\n违章记分:"+rowsBean.deductMarks+"分\t\t\t罚款金额:"+rowsBean.money+"\n\n处理状态:"+rowsBean.disposeState);
                            holder.seton(R.id.l1,v -> {
                                Tool.illbean=rowsBean;
                                startActivity(new Intent(getthis(),Q43Activity.class));
                            });
                        }
                    });
                }
            });
        });
    }
}