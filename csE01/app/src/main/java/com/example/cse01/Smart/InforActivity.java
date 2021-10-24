package com.example.cse01.Smart;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class InforActivity extends BaseActivity {

    private TextView tv1;
    private ImageView iv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        setTitle("通知详情");
        initView();
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        iv1.setImageResource(Tool.tbbean.i1);
        tv1.setText(Tool.tbbean.s1+"\n"+Tool.tbbean.s2);
        tv2.setText("\t\t《智慧社区》是指通过利用智能技术和方式，整合社区各类服务资源，为居民提供物业、娱乐、商务、便民服务、友邻社交等功能的生活应用系统。\n" +
                "智慧社区是社区管理的一个新的管理形态，它利用物联网、云计算、移动互联网等新一代信息技术的集成应用,为社区居民提供一个安全舒适的智慧化生活环境,从而形成基于信息化、智能化社区管理与服务。\n" +
                "“以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展。通过智慧社区系统的建设，解决了社区物业管理机制的即时响应，周边商业服务的推广，社区物业通知，友邻社交的平台等居民生活需求，系统主要包括以下功能模块\n");
    }
}