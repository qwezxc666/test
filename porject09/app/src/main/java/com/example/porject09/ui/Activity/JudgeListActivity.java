package com.example.porject09.ui.Activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porject09.BaseActivity;
import com.example.porject09.Bean.AllillegalBean;
import com.example.porject09.CommAdapter;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;

public class JudgeListActivity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judge_list);
        setTitle("处罚决定书列表");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/traffic/illegal/list", Tool.getToken(getthis()), new MyCallback(getthis(), AllillegalBean.class) {
            @Override
            public void onFinsh(Object o) {
                AllillegalBean allillegalBean= (AllillegalBean) o;
                if (allillegalBean.rows!=null){
                    //当前车辆相关的处罚决定书列表
//                    re.setAdapter(new CommAdapter<AllillegalBean.RowsBean>(getthis(),allillegalBean.rows,) {
//                        @Override
//                        public void convert(Vh holder, AllillegalBean.RowsBean rowsBean) {
//
//                        }
//
//                    });
                }
            }
        });
    }
}