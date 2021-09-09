package com.example.project02.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.HosBean;
import com.example.project02.CommAdapter;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;

import java.util.ArrayList;
import java.util.List;

public class HoSearchActivity extends BaseActivity {

    private RecyclerView re;
    private List<HosBean.RowsBean> list=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_search);
        setTitle("搜索页面");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/hospital/hospital/list", new MyCallback(getthis(), HosBean.class) {
            @Override
            public void onFish(Object o) {
                HosBean hosBean= (HosBean) o;
                if (hosBean!=null){
                    for (HosBean.RowsBean ho:hosBean.rows){
                        if (ho.hospitalName.contains(Tool.Honame)){
                            list.add(ho);
                        }
                    }
                }
                re.setAdapter(new CommAdapter<HosBean.RowsBean>(list,getthis(),R.layout.hos_item) {

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