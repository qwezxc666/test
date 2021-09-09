package com.example.project11.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.AddressBean;
import com.example.project11.Bean.FoodBean;
import com.example.project11.Bean.OrderNum;
import com.example.project11.Bean.PostBean;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv1;
    private RecyclerView address;
    private TextView tv2;
    private TextView re;
    private Button b1;
    private List<CheckBox> list = new ArrayList<>();
    private List<AddressBean.DataBean> addresslist;
    private int postition;
    List<PostBean.OrderItemListBean> listBeans = new ArrayList<>();
    List<FoodBean.RowsBean> listBeans2 = new ArrayList<>();
    AddressBean.DataBean addressBean;
    //地址空
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initView();
        setTitle("确认订单");
        getaddress();


        StringBuilder stringBuilder = new StringBuilder();
        Tool.FOOD_MAP.forEach((dataBean, integer) -> {
            PostBean.OrderItemListBean o = new PostBean.OrderItemListBean(dataBean.id, integer);
            listBeans.add(o);
            stringBuilder.append(dataBean.name + "\t\t\t*" + integer + "\n");
        });
        re.setText(stringBuilder.toString());

    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        address = (RecyclerView) findViewById(R.id.address);
        tv2 = (TextView) findViewById(R.id.tv2);
        re = (TextView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        address.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                postinfor();
                finish();
                startActivity(new Intent(getApplicationContext(), Post2Activity.class));
                break;
        }
    }

    private void getaddress() {
        Okhttp.getheand("/prod-api/api/takeout/address/list", Tool.getToken(getApplicationContext()), new MyCallBack(getthis(), AddressBean.class) {
            @Override
            public void onFinish(Object object) {
                AddressBean addressBean = (AddressBean) object;
                 addresslist= new ArrayList<>();
                addresslist.clear();
                addresslist.addAll(addressBean.data);
                list.clear();

                address.setAdapter(new CommAdapter<AddressBean.DataBean>(getApplicationContext(), addressBean.data, R.layout.address_item) {
                    @Override
                    public void convert(Vh holder, AddressBean.DataBean dataBean) {

                        holder.setText(R.id.tv1, "标签:" + dataBean.label);
                        holder.setText(R.id.tv2, "收货地址:" + dataBean.addressDetail);
                        holder.setText(R.id.tv3, "联系人:" + dataBean.name);
                        holder.setText(R.id.tv4, "联系电话:" + dataBean.phone);
                        list.add(holder.getbox(R.id.b1));
                        if (holder.getAdapterPosition() == 0 ) {
                            holder.getbox(R.id.b1).setChecked(true);
                            list.add(holder.getbox(R.id.b1));
//                            addresslist.add(addressBean.data.get(0));
                            postition =0;
                        }
                        holder.getbox(R.id.b1).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                for (CheckBox checkBox : list) {
                                    checkBox.setChecked(false);
                                }
                                holder.getbox(R.id.b1).setChecked(true);
                                postition = holder.getAdapterPosition();

                            }
                        });
                    }


                });
            }
        });

    }

    public void postinfor() {
        addressBean=addresslist.get(postition);

        PostBean postBean = new PostBean(addressBean.addressDetail, addressBean.label, addressBean.name, addressBean.phone, Tool.getmoney(), Tool.shopid, listBeans);
        Okhttp.postheand("/prod-api/api/takeout/order/create", Tool.getToken(getApplicationContext()), postBean, new MyCallBack(getthis(), OrderNum.class) {
            @Override
            public void onFinish(Object object) {
                OrderNum orderNum = (OrderNum) object;
                Log.e("qwe", orderNum.msg + orderNum.code);
//                Tool.FOOD_MAP.clear();
                Tool.ordernum = orderNum.orderNo;
            }
        });
    }


}
