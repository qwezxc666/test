package com.example.project07.ui.Acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.RecomdBean;
import com.example.project07.CommAdapter;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

import java.util.List;

public class PRecordActivity extends BaseActivity {

    private RecyclerView re;
    private Button b1;
    private SearchView search;
    private List<RecomdBean.RowsBean> mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_record);
        setTitle("停车记录");

        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Okhttp.get("/prod-api/api/park/lot/record/list", new MyCallback(getthis(), RecomdBean.class) {
            @Override
            public void onFish(Object o) {
                RecomdBean recomdBean = (RecomdBean) o;
                mlist=recomdBean.rows.subList(0,5);
                re.setAdapter(new CommAdapter<RecomdBean.RowsBean>(getthis(),mlist, R.layout.recomd_item) {
                    @Override
                    public void convert(Vh holder, RecomdBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.parkName);
                        holder.setText(R.id.tv2,rowsBean.outTime+"-"+rowsBean.entryTime+"\n车牌号："+rowsBean.plateNumber+"\n收费金额："+rowsBean.monetary);

                    }

                });
            }
        });
        search = (SearchView) findViewById(R.id.search);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Okhttp.get("/prod-api/api/park/lot/record/list", new MyCallback(getthis(), RecomdBean.class) {
                    @Override
                    public void onFish(Object o) {
                        RecomdBean recomdBean = (RecomdBean) o;
                        mlist=recomdBean.rows;
                        re.setAdapter(new CommAdapter<RecomdBean.RowsBean>(getthis(),mlist, R.layout.recomd_item) {
                            @Override
                            public void convert(Vh holder, RecomdBean.RowsBean rowsBean) {
                                holder.setText(R.id.tv1,rowsBean.parkName);
                                holder.setText(R.id.tv2,rowsBean.outTime+"-"+rowsBean.entryTime+"\n车牌号："+rowsBean.plateNumber+"\n收费金额："+rowsBean.monetary);

                            }

                        });
                    }
                });
            }
        });
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Tool.key=query;
               startActivity(new Intent(getthis(),PRecord2Activity.class));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}