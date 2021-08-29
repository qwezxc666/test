package com.example.project07;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project07.Bean.NewBean;
import com.example.project07.Bean.PBean;

public class Tool {
    public static PBean.RowsBean p;
    public static NewBean.RowsBean newsBean;
    public static String key;
    public static String gettoken(Context context){
        return context.getSharedPreferences("app",Context.MODE_PRIVATE).getString("token","");
    }
    public static void setGlide(Context context, String url, ImageView imageView){
        if (url!=null){
            Glide.with(context).load(Okhttp.web+url).into(imageView);
        }
    }

}
