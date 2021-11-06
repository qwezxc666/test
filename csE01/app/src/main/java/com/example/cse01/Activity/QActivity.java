package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.BusBean;
import com.example.cse01.Bean.LineBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class QActivity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);
        setTitle("智慧巴士");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/bus/line/list", new MyCallback(getthis(), BusBean.class) {
            @Override
            public void onFish(Object o) {
                BusBean busBean= (BusBean) o;
                re.setAdapter(new CommAdapter<BusBean.RowsBean>(getthis(),busBean.rows,R.layout.bus_item) {
                    @Override
                    public void convert(Vh holder, BusBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.name+"\n"+rowsBean.startTime+"\n-\n"+rowsBean.endTime);
                        holder.setText(R.id.tv2,rowsBean.first);
                        holder.setText(R.id.tv3,rowsBean.end);
                        holder.setText(R.id.tv4,rowsBean.price+"￥");
                        holder.setText(R.id.tv5,rowsBean.mileage);
                        ImageView view = holder.getview(R.id.t1);
                        ImageView view2 = holder.getview(R.id.t3);

                        holder.seton(R.id.t1,v -> {

                            Okhttp.get("/prod-api/api/bus/stop/list?linesId=" + rowsBean.id, new MyCallback(getthis(), LineBean.class) {
                                @Override
                                public void onFish(Object o) {
                                    LineBean lineBean= (LineBean) o;
                                    StringBuffer buffer=new StringBuffer();
                                    for (LineBean.RowsBean rowsBean1:lineBean.rows){
                                        buffer.append(rowsBean1.name+"\n\n");
                                    }
                                    holder.setText(R.id.t2,buffer.toString());
                                }
                            });
                            view.setVisibility(View.GONE);
                            view2.setVisibility(View.VISIBLE);
                        });
                        holder.seton(R.id.t3,v -> {
                            view2.setVisibility(View.GONE);
                            view.setVisibility(View.VISIBLE);
                            holder.setText(R.id.t2,"");
                        });
                        holder.seton(R.id.l1,v -> {
                            Tool.busbean=rowsBean;
                            startActivity(new Intent(getthis(),Q12Activity.class));
                        });
                    }

                });
            }
        });
    }
}