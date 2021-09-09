package com.example.porject09.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.porject09.BaseActivity;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;

public class illegalInforActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illegal_infor);
        setTitle("处理判决书详情页面");
    }
//    private void getilleagl(){
//        Okhttp.get("/prod-api/api/traffic/illegal/notice/"+ Tool.illeaglid,);
//    }
}