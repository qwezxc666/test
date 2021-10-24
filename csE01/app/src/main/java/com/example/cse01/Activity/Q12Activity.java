package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.LineBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q12Activity extends BaseActivity {

    private CardView l1;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private RecyclerView re;
    private Button b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q12);
        setTitle("智慧巴士");
        initView();
    }

    private void initView() {
        l1 = (CardView) findViewById(R.id.l1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        tv1.setText(Tool.busbean.name);
        tv2.setText(Tool.busbean.first);
        tv3.setText(Tool.busbean.end);
        tv4.setText(Tool.busbean.price+"￥");
        tv5.setText(Tool.busbean.mileage);

            Okhttp.get("/prod-api/api/bus/stop/list?linesId=" + Tool.busbean.id , new MyCallback(getthis(), LineBean.class) {
                @Override
                public void onFish(Object o) {
                    LineBean lineBean= (LineBean) o;
                    re.setLayoutManager(new GridLayoutManager(getthis(),lineBean.total));
                    re.setAdapter(new CommAdapter<LineBean.RowsBean>(getthis(),lineBean.rows,R.layout.line_item) {
                        @Override
                        public void convert(Vh holder, LineBean.RowsBean rowsBean) {
                            holder.setText(R.id.tv1,rowsBean.name);
                        }

                    });
                }
            });

            b1.setOnClickListener(v -> finish());
            b2.setOnClickListener(v -> startActivity(new Intent(getthis(),Q13Activity.class)));
    }
}