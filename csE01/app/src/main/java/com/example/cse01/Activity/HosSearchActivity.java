package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.HosBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

import java.util.ArrayList;
import java.util.List;

public class HosSearchActivity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hos_search);
        setTitle("搜索页面");
        if (Tool.name!=null){
        initView();

        }else {
            maketast("请输入搜索内容");
        }
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/hospital/hospital/list", new MyCallback(getthis(), HosBean.class) {
            @Override
            public void onFish(Object o) {
                HosBean hosBean= (HosBean) o;
                List<HosBean.RowsBean> list=new ArrayList<>();
                for (HosBean.RowsBean rowsBean:hosBean.rows){
                    if (rowsBean.hospitalName.contains(Tool.name)){
                        list.add(rowsBean);
                    }
                }
                if (list.size()==0){
                    maketast("未找到相关结果");
                }
                re.setAdapter(new CommAdapter<HosBean.RowsBean>(getthis(),list,R.layout.hos_item) {
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