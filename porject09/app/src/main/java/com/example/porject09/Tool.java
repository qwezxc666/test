package com.example.porject09;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.porject09.ui.home.SmartFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public  class Tool {
    public static List<SmartFragment.re> mlist=new ArrayList<>();
    public static SmartFragment.infor infor;
    public static String illeaglid;
    public static int newsid;
    public static String  getToken(Context context){
        return context.getSharedPreferences("app",Context.MODE_PRIVATE).getString("token","");
    }
    public static void setGlide(Context context,String str,ImageView iv){
        Glide.with(context).load(Okhttp.web+str).into(iv);
    }

}
