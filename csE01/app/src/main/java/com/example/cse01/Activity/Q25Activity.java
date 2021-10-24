package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.HosTypebEAN;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q25Activity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q25);
        setTitle("门诊科室分诊");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/hospital/category/list", Tool.gettoken(getthis()),
                new MyCallback(getthis(), HosTypebEAN.class) {
                    @Override
                    public void onFish(Object o) {
                        HosTypebEAN typebEAN= (HosTypebEAN) o;
                        re.setAdapter(new CommAdapter<HosTypebEAN.RowsBean>(getthis(),typebEAN.rows,R.layout.typeb_item) {
                            @Override
                            public void convert(Vh holder, HosTypebEAN.RowsBean rowsBean) {
                                holder.setText(R.id.tv1,rowsBean.categoryName);
                                holder.seton(R.id.l1,v -> {
                                    Tool.name=rowsBean.categoryName;
                                    startActivity(new Intent(getthis(),Q26Activity.class));
                                });
                            }

                        });
                    }
                });
    }
}