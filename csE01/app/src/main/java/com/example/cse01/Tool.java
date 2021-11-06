package com.example.cse01;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cse01.Activity.Q14Activity;
import com.example.cse01.Bean.BusBean;
import com.example.cse01.Bean.HoBean;
import com.example.cse01.Bean.HosBean;
import com.example.cse01.Bean.LLBean;
import com.example.cse01.Smart.S1Activity;
import com.example.cse01.Smart.S3Activity;
import com.example.cse01.ui.home.SmartFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tool {
    public static LLBean.RowsBean illbean;
    public static HoBean.RowsBean hobean;
    public static HosBean.RowsBean hosbean;
    public static Q14Activity.person person;
    public static String time;
    public static BusBean.RowsBean busbean;
    public static S1Activity.card cardbaen;
    public static int cardi=-1;
    public static SmartFragment.Tb tbbean;
    public static String name;
    public static int id=-1;
    public static void setGlide(Context context, String str, ImageView view){
        Glide.with(context).load(Okhttp.web+str).into(view);
    }
    public static void setGlide2(Context context, String str, ImageView view){
        Glide.with(context).load(Okhttp.web+str).circleCrop().into(view);
    }
    public static String gettoken(Context context){
        return context.getSharedPreferences("app",Context.MODE_PRIVATE).getString("token","");
    }
    public static List<S1Activity.card> cardList=new ArrayList<>(Arrays.asList(
            new S1Activity.card("浙A1234","01-123","01-1234","张三","13131313131","李四","这里"),
            new S1Activity.card("浙A1234","01-123","01-1234","张三","13131313131","李四","这里")
            ));
    public static List<S3Activity.Fb> fbList=new ArrayList<>(Arrays.asList(
            new S3Activity.Fb("用户01","good",R.drawable.h1,null),
            new S3Activity.Fb("用户02","good",R.drawable.h2,null)
    ));
}
