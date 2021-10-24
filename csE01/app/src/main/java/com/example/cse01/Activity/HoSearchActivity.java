package com.example.cse01.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;

public class HoSearchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_search);
        setTitle("搜索页面");
    }
}