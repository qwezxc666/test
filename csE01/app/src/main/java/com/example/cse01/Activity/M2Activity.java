package com.example.cse01.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.OrBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;
import com.google.android.material.tabs.TabLayout;

public class M2Activity extends BaseActivity {

    private TabLayout tab;
    private RecyclerView re;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2);
        setTitle("订单列表");

        initView();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        re = (RecyclerView) findViewById(R.id.re);
        tv1 = (TextView) findViewById(R.id.tv1);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    Okhttp.get("/prod-api/api/bus/order/list?status=0", Tool.gettoken(getthis()), new MyCallback(getthis(), OrBean.class) {
                        @Override
                        public void onFish(Object o) {

                            OrBean data = (OrBean) o;
                            if (data.total == 0) {
                                tv1.setVisibility(View.VISIBLE);
                            }else {
                                tv1.setVisibility(View.GONE);

                            }
                            re.setLayoutManager(new LinearLayoutManager(getthis()));
                            re.setAdapter(new CommAdapter<OrBean.RowsBean>(getthis(), data.rows, R.layout.order_item) {
                                @Override
                                public void convert(Vh holder, OrBean.RowsBean q) {
                                    holder.setText(R.id.tv1, "路线名称：" + q.path + "\n\n" + q.start + "-" + q.end + "\n\n票价:" + q.price + "￥\n\n" + q.orderNum);

                                }
                            });
                        }
                    });
                }
                if (tab.getPosition()==1){
                    Okhttp.get("/prod-api/api/bus/order/list?status=1", Tool.gettoken(getthis()), new MyCallback(getthis(), OrBean.class) {
                        @Override
                        public void onFish(Object o) {

                            OrBean data = (OrBean) o;
                            if (data.total == 0) {
                                tv1.setVisibility(View.VISIBLE);
                            }else {
                                tv1.setVisibility(View.GONE);

                            }
                            re.setLayoutManager(new LinearLayoutManager(getthis()));
                            re.setAdapter(new CommAdapter<OrBean.RowsBean>(getthis(), data.rows, R.layout.order_item) {
                                @Override
                                public void convert(Vh holder, OrBean.RowsBean q) {
                                    holder.setText(R.id.tv1, "路线名称：" + q.path + "\n\n" + q.start + "-" + q.end + "\n\n票价:" + q.price + "￥\n\n" + q.orderNum);

                                }
                            });
                        }
                    });
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Okhttp.get("/prod-api/api/bus/order/list?status=0", Tool.gettoken(getthis()), new MyCallback(getthis(), OrBean.class) {
            @Override
            public void onFish(Object o) {

                OrBean data = (OrBean) o;
                if (data.total == 0) {
                    tv1.setVisibility(View.VISIBLE);
                }else {
                    tv1.setVisibility(View.GONE);

                }
                re.setLayoutManager(new LinearLayoutManager(getthis()));
                re.setAdapter(new CommAdapter<OrBean.RowsBean>(getthis(), data.rows, R.layout.order_item) {
                    @Override
                    public void convert(Vh holder, OrBean.RowsBean q) {
                        holder.setText(R.id.tv1, "路线名称：" + q.path + "\n\n" + q.start + "-" + q.end + "\n\n票价:" + q.price + "￥\n\n" + q.orderNum);

                    }
                });
            }
        });

    }
}