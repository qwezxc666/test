package com.example.project11.Smart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project11.R;
import com.example.project11.ui.Activity.BaseActivity;

public class ConllectionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conllection);
        setTitle("我的收藏");
    }
}