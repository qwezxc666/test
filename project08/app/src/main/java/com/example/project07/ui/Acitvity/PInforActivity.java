package com.example.project07.ui.Acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project07.BaseActivity;
import com.example.project07.R;
import com.example.project07.Tool;

public class PInforActivity extends BaseActivity {

    private TextView tv1;
    private ImageView iv1;
    private TextView tv2;
    private TextView tv3;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_infor);
        setTitle("停车场详情");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        b1 = (Button) findViewById(R.id.b1);
        tv1.setText(Tool.p.parkName);
        tv2.setText(Tool.p.address+"\t\t\t"+Tool.p.distance+"m");
        tv3.setText("总车位数："+Tool.p.allPark+"\t\t\t剩余车位数："+Tool.p.vacancy+"m\t\t\t"+((Tool.p.open.equals("Y"))?"对外开放":"不开放")
        +"\t收费标准："+Tool.p.rates+"元/小时");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),P2Activity.class));
            }
        });
    }
}