package com.example.test10.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.BaseAcitivity;
import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.Tool;
import com.example.test10.ui.notifications.NotificationsFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F4Activity extends BaseAcitivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f4);
        setTitle("村情村貌");
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        List<NotificationsFragment.tb> tbList1=new ArrayList<>(Arrays.asList(
                new NotificationsFragment.tb("村子1",R.drawable.new1),
                new NotificationsFragment.tb("村子2",R.drawable.new2),
                new NotificationsFragment.tb("村子3",R.drawable.cun1),
                new NotificationsFragment.tb("村子4",R.drawable.cun2)
                ));
        re.setAdapter(new CommAdapter<NotificationsFragment.tb>(getthis(),tbList1,R.layout.cunzi_item) {
            @Override
            public void convert(Vh convert, NotificationsFragment.tb tb) {
                convert.setText(R.id.tv1,tb.s1);
                convert.setGlide(R.id.iv1,tb.i1);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.czbean=tb;
                        startActivity(new Intent(getthis(),F42Activity.class));
                    }
                });
            }

        });
    }
}