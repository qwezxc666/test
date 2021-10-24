package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.HosBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q2Activity extends BaseActivity {

    private SearchView search;
    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);
        setTitle("门诊预约");
        initView();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Tool.name=query;
                startActivity(new Intent(getthis(),HosSearchActivity.class));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void initView() {
        search = (SearchView) findViewById(R.id.search);
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));

        Okhttp.get("/prod-api/api/hospital/hospital/list", new MyCallback(getthis(), HosBean.class) {
            @Override
            public void onFish(Object o) {
                HosBean hosBean= (HosBean) o;
                re.setAdapter(new CommAdapter<HosBean.RowsBean>(getthis(),hosBean.rows,R.layout.hos_item) {
                    @Override
                    public void convert(Vh holder, HosBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.hospitalName);
                        holder.setGlide(R.id.iv1,rowsBean.imgUrl);
                        RatingBar view = holder.getview(R.id.rat);
                        view.setRating(rowsBean.level);
                        holder.seton(R.id.l1,v -> {
                            Tool.hosbean=rowsBean;
                            startActivity(new Intent(getthis(),Q22Activity.class));
                        });
                    }


                });
            }
        });
    }
}