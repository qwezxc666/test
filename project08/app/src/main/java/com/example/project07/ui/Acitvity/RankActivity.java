package com.example.project07.ui.Acitvity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.RankBean;
import com.example.project07.CommAdapter;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

public class RankActivity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        setTitle("排行榜");

        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.getheand("/prod-api/api/park/score/top/list", Tool.gettoken(getthis()),new MyCallback(getthis(), RankBean.class) {
            @Override
            public void onFish(Object o) {
                RankBean rankBean= (RankBean) o;
                re.setAdapter(new CommAdapter<RankBean.RowsBean>(getthis(),rankBean.rows,R.layout.pay_item) {
                    @Override
                    public void convert(Vh holder, RankBean.RowsBean rowsBean) {
                        holder.setGlide(R.id.iv1,getthis(),rowsBean.avatar);
                        holder.setText(R.id.tv1,rowsBean.nickName);
                        holder.setText(R.id.tv2,"积分："+rowsBean.score);
                        if (holder.getPosition()==0){
//                            holder.setText(R.id.tv1).setTextColor(-4253158);
                        }
                    }


                });
            }
        });

    }
}