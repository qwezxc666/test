package com.example.project07.ui.Acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.PBean;
import com.example.project07.CommAdapter;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

public class FindPActivity extends BaseActivity {

    private TextView tv1;
    private RecyclerView re;
    private ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_p);
        setTitle("找车位");

        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(this));
        Okhttp.get("/prod-api/api/park/lot/list", new MyCallback(getthis(), PBean.class) {
            @Override
            public void onFish(Object o) {
                PBean pBean = (PBean) o;
                re.setAdapter(new CommAdapter<PBean.RowsBean>(getthis(), pBean.rows, R.layout.hot_item) {
                    @Override
                    public void convert(Vh holder, PBean.RowsBean rowsBean) {
                        holder.setGlide(R.id.iv1, getthis(), "/prod-api" + rowsBean.imgUrl);
                        holder.setText(R.id.tv1, rowsBean.parkName);
                        holder.setText(R.id.tv2, rowsBean.address + "\n总车位数:" + rowsBean.allPark + "\t\t\t剩余车位数:" + rowsBean.vacancy);
                        holder.setText(R.id.tv3, "距离：" + rowsBean.distance + "\t\t\t\t" + ((rowsBean.open.equals("Y")) ? "对外开放" : "不开放"));
                        holder.setonListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.p = rowsBean;
                                startActivity(new Intent(getthis(), PInforActivity.class));
                            }
                        });
                    }


                });
            }
        });
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PRecordActivity.class));
            }
        });
    }
}