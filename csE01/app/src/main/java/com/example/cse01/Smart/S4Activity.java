package com.example.cse01.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.BaseActivity;
import com.example.cse01.CommAdapter;
import com.example.cse01.R;
import com.example.cse01.ui.home.SmartFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S4Activity extends BaseActivity {

    private RecyclerView re;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s4);
        setTitle("物业服务");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        List<SmartFragment.Tb> tbList=new ArrayList<>(Arrays.asList(
                new SmartFragment.Tb("物业服务中心","01-123111",0),
                new SmartFragment.Tb("停车位服务中心","11-123111",0),
                new SmartFragment.Tb("24小时值班热线","02-123111",0),
                new SmartFragment.Tb("报修电话","04-123111",0),
                new SmartFragment.Tb("便民服务","14-231312",0)

                ));
        re.setAdapter(new CommAdapter<SmartFragment.Tb>(getthis(),tbList,R.layout.s4_item) {
            @Override
            public void convert(Vh holder, SmartFragment.Tb tb) {
                holder.setText(R.id.tv1,tb.s1);
                holder.setText(R.id.tv2,tb.s2);
                holder.seton(R.id.t1,v -> {
                   startActivityForResult(new Intent(Intent.ACTION_DIAL).setType("tel:"+tb.s2),666);
                });
            }

        });
        b1.setOnClickListener(v -> startActivity(new Intent(getthis(),S42Activity.class)));
    }
}