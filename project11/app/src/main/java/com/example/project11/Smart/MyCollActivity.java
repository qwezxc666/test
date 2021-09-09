package com.example.project11.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.AllColl;
import com.example.project11.Bean.FoodBean;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

public class MyCollActivity extends BaseActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_coll);
        initView();
        setTitle("我的收藏");
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));

    }
    private void get(){
        Okhttp.getheand("/prod-api/api/takeout/collect/list",Tool.getToken(getthis()) ,new MyCallBack(getthis(), AllColl.class) {
            @Override
            public void onFinish(Object object) {
                AllColl foodBean = (AllColl) object;
                Log.e("qwe",foodBean.total+foodBean.msg);
                re.setAdapter(new CommAdapter<AllColl.RowsBean>(getthis(),foodBean.rows,R.layout.near_item) {
                    @Override
                    public void convert(Vh holder, AllColl.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.sellerName);
                        holder.setText(R.id.tv2,"月销量："+rowsBean.saleQuantity);
                        holder.setRat(R.id.ra, (int) rowsBean.score);
                        holder.setText(R.id.tv3,rowsBean.address);
                        holder.setGlide(R.id.iv1,rowsBean.imgUrl,getthis());
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.shopid=rowsBean.sellerId;

                                startActivity(new Intent(getthis(),ShopInforActivity.class));
                            }
                        });
                    }

                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        get();
    }
}