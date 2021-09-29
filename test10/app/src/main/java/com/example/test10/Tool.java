package com.example.test10;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.test10.Activity.F3Activity;
import com.example.test10.Smart.S3Activity;
import com.example.test10.Smart.S4Activity;
import com.example.test10.ui.dashboard.DashboardFragment;
import com.example.test10.ui.home.SmartFragment;
import com.example.test10.ui.notifications.NotificationsFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tool {
    public static NotificationsFragment.tb czbean;
    public static F3Activity.infor jzbean;
    public static NotificationsFragment.tb fpbean;
    public static NotificationsFragment.tb newbean;
    public static DashboardFragment.yly ylybean;
    public  static S4Activity.car carbean;
    public static int carid=-1;
    public static SmartFragment.tb tbbean;
    public static String gettoken(Context context){
        return context.getSharedPreferences("app",Context.MODE_PRIVATE).getString("token","");
    }
    public static void setGilde(Context context, String str, ImageView imageView){
        Glide.with(context).load(Okhttp.web+str).into(imageView);
    }
    public static List<S3Activity.fb> fbList=new ArrayList<>(Arrays.asList(
            new S3Activity.fb("Tom","帮帮帮",R.drawable.find_pk1,null),
            new S3Activity.fb("Tom","帮帮帮",R.drawable.find_pk1,null)
            ));
    public static List<S4Activity.car> carList=new ArrayList<>(Arrays.asList(
            new S4Activity.car("浙A231","01-213","123","张三","123132131","李四","这里"),
            new S4Activity.car("浙A231","01-213","123","张三","123132131","李四","这里")
            ));
    public static List<DashboardFragment.yly> ylyList=new ArrayList<>(Arrays.asList(
            new DashboardFragment.yly("qw养老院","基础配套的设施设备以及服务体系",R.drawable.ss1),
            new DashboardFragment.yly("qe养老院","基础配套的设施设备以及服务体系",R.drawable.ss2),
            new DashboardFragment.yly("qr养老院","基础配套的设施设备以及服务体系",R.drawable.ss3),
            new DashboardFragment.yly("qt养老院","基础配套的设施设备以及服务体系",R.drawable.ss4)
    ));
}
