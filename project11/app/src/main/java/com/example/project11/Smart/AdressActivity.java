package com.example.project11.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.AddressBean;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

public class AdressActivity extends BaseActivity {

    private RecyclerView re;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);
        initView();
        setTitle("地址管理");
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),EditAddresActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Okhttp.getheand("/prod-api/api/takeout/address/list", Tool.getToken(getthis()), new MyCallBack(getthis(),AddressBean.class) {
            @Override
            public void onFinish(Object object) {
                AddressBean addressBean = (AddressBean) object;
                re.setAdapter(new CommAdapter<AddressBean.DataBean>(getthis(),addressBean.data, R.layout.myaddress_item) {
                    @Override
                    public void convert(Vh holder, AddressBean.DataBean dataBean) {
                        holder.setText(R.id.tv1,"收货地址："+dataBean.addressDetail);
                        holder.setText(R.id.tv2,"联系人："+dataBean.name);
                        holder.setText(R.id.tv3,"手机号："+dataBean.phone);
                        holder.getimg(R.id.iv1).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.address=dataBean;
                                startActivity(new Intent(getApplicationContext(),EditAddresActivity.class));
                            }
                        });
                    }


                });
            }
        });
    }
}