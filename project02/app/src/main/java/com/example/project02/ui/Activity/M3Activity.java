package com.example.project02.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.HosBean;
import com.example.project02.CommAdapter;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;

public class M3Activity extends BaseActivity {

    private SearchView search;
    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3);
        setTitle("门诊预约");

        initView();
    }

    private void initView() {
        search = (SearchView) findViewById(R.id.search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Tool.Honame=query;
                if (query!=null){
                    startActivity(new Intent(getthis(),HoSearchActivity.class));
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/hospital/hospital/list", new MyCallback(getthis(), HosBean.class) {
            @Override
            public void onFish(Object o) {
                HosBean hosBean= (HosBean) o;
                re.setAdapter(new CommAdapter<HosBean.RowsBean>(hosBean.rows,getthis(),R.layout.hos_item) {

                    @Override
                    public void convert(Vh holder, final HosBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.hospitalName);
                        holder.setGlide(R.id.iv1,rowsBean.imgUrl,getthis());
                        holder.setRat(R.id.star,rowsBean.level);
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.hosBean=rowsBean;
                                startActivity(new Intent(getthis(),M32Activity.class));
                            }
                        });
                    }
                });
            }
        });

    }
}