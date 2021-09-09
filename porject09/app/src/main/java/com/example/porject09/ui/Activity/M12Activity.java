package com.example.porject09.ui.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porject09.BaseActivity;
import com.example.porject09.Bean.AllCarBean;
import com.example.porject09.Bean.idCarBean;
import com.example.porject09.CommAdapter;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;

public class M12Activity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m12);
        setTitle("绑定车辆列表");
        initView();
        get();
    }

    private void get() {
        Okhttp.get("/prod-api/api/traffic/car/list", Tool.getToken(getthis()), new MyCallback(getthis(), AllCarBean.class) {
            @Override
            public void onFinsh(Object o) {
                AllCarBean allCarBean = (AllCarBean) o;

                re.setAdapter(new CommAdapter<AllCarBean.RowsBean>(getthis(),allCarBean.rows,R.layout.carlist_item) {
                    @Override
                    public void convert(Vh holder, AllCarBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.type);
                        holder.setText(R.id.tv2,rowsBean.plateNo);

                    }

                });

            }
        });

    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
    }
}