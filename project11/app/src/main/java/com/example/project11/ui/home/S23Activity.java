package com.example.project11.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project11.R;
import com.example.project11.ui.Activity.BaseActivity;

public class S23Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s23);
        setTitle("扫码取件");
    }
}