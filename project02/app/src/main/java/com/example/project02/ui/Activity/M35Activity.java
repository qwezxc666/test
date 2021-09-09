package com.example.project02.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.TypeBean;
import com.example.project02.CommAdapter;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;

public class M35Activity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m35);
        setTitle("门诊科室分诊");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/hospital/category/list", new MyCallback(getthis(), TypeBean.class) {
            @Override
            public void onFish(Object o) {
                TypeBean typeBean= (TypeBean) o;
                re.setAdapter(new CommAdapter<TypeBean.RowsBean>(typeBean.rows,getthis(),R.layout.type_item) {

                    @Override
                    public void convert(Vh holder, TypeBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.categoryName);
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getthis(),M36Activity.class));
                            }
                        });

                    }

                });
            }
        });

    }
}