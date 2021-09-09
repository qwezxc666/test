package com.example.project11.ui.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Banner banner;
    private List<Integer> list = new ArrayList<>();
    private LinearLayout l1;
    private Button b1;
    private Button b2;
    private RelativeLayout l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        SharedPreferences sp=getSharedPreferences("first",MODE_PRIVATE);
        String first = sp.getString("first", "");
        if (first.equals("1")){
            finish();
            startActivity(new Intent(getApplicationContext(), com.example.project11.MainActivity.class));
        }
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        list.add(R.drawable.smartcity1);
        list.add(R.drawable.smartcity2);
        list.add(R.drawable.smartcity3);
        l1 = (LinearLayout) findViewById(R.id.l1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        l2 = (RelativeLayout) findViewById(R.id.l2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor sp=getSharedPreferences("first",MODE_PRIVATE).edit();
                sp.putString("first","1");
                sp.commit();
                startActivity(new Intent(getApplicationContext(), com.example.project11.MainActivity.class));
                finish();
            }
        });
        banner.setIndicator(new CircleIndicator(this));
        banner.setAdapter(new BannerImageAdapter<Integer>(list) {
            @Override
            public void onBindView(BannerImageHolder bannerImageHolder, Integer integer, int i, int i1) {
                bannerImageHolder.imageView.setImageResource(integer);


            }

        });
        banner.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i ==2) {
                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                }else {
                    b1.setVisibility(View.GONE);
                    b2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
    private void dia(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        AlertDialog alertDialog1 = alertDialog.create();
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog, null);
        alertDialog1.setView(view);
        alertDialog1.show();
        EditText editText=view.findViewById(R.id.et1);
        if (editText.toString().isEmpty()){
            Toast.makeText(this, "请输入IP端口", Toast.LENGTH_SHORT).show();
        }
        Button button=view.findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Okhttp.web=editText.toString();
                Log.e("qwe",Okhttp.web);
            }
        });
    }
}