package com.example.porject09.ui.smart;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.porject09.BaseActivity;
import com.example.porject09.MainActivity;
import com.example.porject09.R;
import com.example.porject09.Tool;
import com.example.porject09.ui.home.SmartFragment;

public class S1Activity extends BaseActivity implements View.OnClickListener {

    private Spinner sp;
    private Button b1;
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1);
        initView();
        setTitle("预约上门");
    }

    private void initView() {
        sp = (Spinner) findViewById(R.id.sp);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                post();
                break;
        }
    }
    private void post(){
        if (Tool.mlist!=null){
            SmartFragment.re re=new SmartFragment.re(sp.getSelectedItem().toString());
            Tool.mlist.add(re);
            maketoast("保存成功");
        }else {
            maketoast("请先去信息预留");
        }

    }
}