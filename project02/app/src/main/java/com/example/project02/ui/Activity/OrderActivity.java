package com.example.project02.ui.Activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.OrderBean;
import com.example.project02.CommAdapter;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class OrderActivity extends BaseActivity {

    private TabLayout tab;
    private TabItem tabt1;
    private TabItem tabt2;
    private RecyclerView order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("我的订单");

        initView();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        tabt1 = (TabItem) findViewById(R.id.tabt1);
        tabt2 = (TabItem) findViewById(R.id.tabt2);
        order = (RecyclerView) findViewById(R.id.order);
        order.setLayoutManager(new LinearLayoutManager(getthis()));

    }
    private void post(String s){
        Okhttp.get("/prod-api/api/allorder/list?orderStatus="+s, Tool.gettoken(getthis()), new MyCallback(getthis(), OrderBean.class) {
            @Override
            public void onFish(Object o) {
                OrderBean orderBean= (OrderBean) o;
                if (orderBean.rows!=null){
//                    order.setAdapter(new CommAdapter() {
//                        @Override
//                        public void convert(Vh holder, Object o) {
//
//                        }
//
//                        @Override
//                        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//                        }
//                    });
                }
            }
        });
    }
}