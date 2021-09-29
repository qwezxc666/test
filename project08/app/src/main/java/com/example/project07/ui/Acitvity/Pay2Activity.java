package com.example.project07.ui.Acitvity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.PayListBean;
import com.example.project07.Bean.ScoreListBean;
import com.example.project07.CommAdapter;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Pay2Activity extends BaseActivity {

    private RecyclerView re;
    private TabItem b1;
    private TabItem b2;
    private TabItem b3;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);
        initView();
        if (Tool.i != -1) {
            setTitle("积分记录");
            tab.addTab(tab.newTab().setText("获取/消费积分"));
            tab.addTab(tab.newTab().setText("获取/消费积分活动名称"));
            tab.addTab(tab.newTab().setText("获取/消费时间"));

            get2();
        } else {
            setTitle("收支明细");
            tab.addTab(tab.newTab().setText("充值金额"));
            tab.addTab(tab.newTab().setText("支付方式"));
            tab.addTab(tab.newTab().setText("充值时间"));
            get();
        }
    }

    private void get2() {
        Okhttp.getheand("/prod-api/api/park/score/list", Tool.gettoken(getthis()), new MyCallback(getthis(), ScoreListBean.class) {
            @Override
            public void onFish(Object o) {
                ScoreListBean payListBean = (ScoreListBean) o;
                re.setAdapter(new CommAdapter<ScoreListBean.RowsBean>(getthis(), payListBean.rows, R.layout.pay_item) {
                    @Override
                    public void convert(Vh holder, ScoreListBean.RowsBean rowsBean) {
                        if (payListBean != null) {
                            holder.setText(R.id.tv1, rowsBean.score);
                            holder.setText(R.id.tv2, rowsBean.event);
                            holder.setText(R.id.tv3, rowsBean.changeDate);
                            if (rowsBean.type.equals("扣除")){
//                                holder.setText(R.id.tv1).setTextColor(-4253158);

                            }
                        }

                    }

                });
            }
        });
    }

    private void get() {
        Okhttp.getheand("/prod-api/api/park/recharge/list", Tool.gettoken(getthis()), new MyCallback(getthis(), PayListBean.class) {
            @Override
            public void onFish(Object o) {
                PayListBean payListBean = (PayListBean) o;
                re.setAdapter(new CommAdapter<PayListBean.RowsBean>(getthis(), payListBean.rows, R.layout.pay_item) {
                    @Override
                    public void convert(Vh holder, PayListBean.RowsBean rowsBean) {
                        if (payListBean != null) {
                            holder.setText(R.id.tv1, rowsBean.money + "元");
                            holder.setText(R.id.tv2, rowsBean.payType);
                            holder.setText(R.id.tv3, rowsBean.rechargeDate);
                        }

                    }

                });
            }
        });
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));

        tab = (TabLayout) findViewById(R.id.tab);
    }
}