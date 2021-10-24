package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class Q13Activity extends BaseActivity {

    private DatePicker data;
    private TextView tv1;
    private Button b1;
    private Button b2;
    public String time;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q13);
        setTitle("智慧巴士");

        initView();
        data.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                time=year+"-"+monthOfYear+"-"+dayOfMonth;
                tv1.setText(time);
                Tool.time=time;
            }
        });
    }

    private void initView() {
        data = (DatePicker) findViewById(R.id.data);
        tv1 = (TextView) findViewById(R.id.tv1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b1.setOnClickListener(v -> finish());
        b2.setOnClickListener(v -> startActivity(new Intent(getthis(),Q14Activity.class)));
    }
}