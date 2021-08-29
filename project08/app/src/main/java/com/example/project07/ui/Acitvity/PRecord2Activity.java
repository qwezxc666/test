package com.example.project07.ui.Acitvity;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.RecomdBean;
import com.example.project07.CommAdapter;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

import java.util.ArrayList;
import java.util.List;

public class PRecord2Activity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_record2);
        setTitle("搜索页面");

        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        Okhttp.get("/prod-api/api/park/lot/record/list", new MyCallback(getthis(), RecomdBean.class) {
            @Override
            public void onFish(Object o) {
                RecomdBean recomdBean = (RecomdBean) o;
                List<RecomdBean.RowsBean> mlist = new ArrayList<>();
                for (RecomdBean.RowsBean rowsBean: recomdBean.rows){
                    Log.e("qwe",rowsBean.outTime.substring(0,7));
                    if ((rowsBean.outTime.substring(0,10)).contains(Tool.key.substring(0,10))){
                        mlist.add(rowsBean);
                    }
                }
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
}