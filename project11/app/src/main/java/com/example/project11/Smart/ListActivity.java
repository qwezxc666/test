package com.example.project11.Smart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.project11.Bean.FoodBean;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

public class ListActivity extends BaseActivity {
    private RecyclerView re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("搜索店家列表");
        re=findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Okhttp.get("/prod-api/api/takeout/seller/list?name="+Tool.foodname, new MyCallBack(getthis(), FoodBean.class) {
            @Override
            public void onFinish(Object object) {
                FoodBean foodBean = (FoodBean) object;
                if (foodBean.rows==null&&foodBean.rows.isEmpty()){
                    maketoast("没有找到商家");
                }
                re.setAdapter(new CommAdapter<FoodBean.RowsBean>(getthis(),foodBean.rows,R.layout.near_item) {
                    @Override
                    public void convert(Vh holder, FoodBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.name);
                        holder.setText(R.id.tv2,"月销量："+rowsBean.saleQuantity+"    "+rowsBean.distance+"m     "+rowsBean.deliveryTime+"分钟");
                        holder.setRat(R.id.ra, (int) rowsBean.score);
                        holder.setText(R.id.tv3,"人均消费："+rowsBean.avgCost);
                        holder.setGlide(R.id.iv1,rowsBean.imgUrl,getApplicationContext());
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Tool.shop=rowsBean;
                                Tool.shopid=rowsBean.id;
                                Log.e("qwe",Tool.shopid+"?");
                                startActivity(new Intent(getthis(),ShopInforActivity.class));
                            }
                        });
                    }

                });
            }
        });
    }
}