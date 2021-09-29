package com.example.test10.Smart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.BaseAcitivity;
import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.ui.home.SmartFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S1Activity extends BaseAcitivity {

    private RecyclerView re;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1);
        setTitle("物业服务");

        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        List<SmartFragment.tb> tbList=new ArrayList<>(Arrays.asList(
                new SmartFragment.tb("物业服务中心",1231),
                new SmartFragment.tb("停车位服务中心",1231123),
                new SmartFragment.tb("24小时值班热线",1231123),
                new SmartFragment.tb("报修电话",1231123),
                new SmartFragment.tb("报修电话",1231123)
        ));
        re.setAdapter(new CommAdapter<SmartFragment.tb>(getthis(),tbList,R.layout.s1_item) {
            @Override
            public void convert(Vh convert, SmartFragment.tb tb) {
                convert.setText(R.id.tv1,tb.s1);
                convert.setText(R.id.tv2,tb.i1+"");
                convert.seton(R.id.tv3, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:"+tb.i1)));
                    }
                });
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getthis(),S12Activity.class));
            }
        });
    }
}