package com.example.project02;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.project02.Bean.CardBean;
import com.example.project02.Bean.HosBean;
import com.example.project02.Bean.News2Bean;
import com.example.project02.Bean.illagel;
import com.example.project02.ui.Smart.S3Activity;
import com.example.project02.ui.home.SmartFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tool {
    public static String Honame;
    public static int bannerid=-1;
    public static int hotid=-1;
    public static int carid;
    public static SmartFragment.car carBean;
    public static SmartFragment.adv adbBean;
    public static int notifid=-1;
    public static String name;
    public static CardBean cardView;
    public static HosBean.RowsBean hosBean;
    public static NewsBean.RowsBean news;
    public static illagel.RowsBean ill;
    public static News2Bean.RowsBean act;
    public static String gettoken(Context context){
        return context.getSharedPreferences("app",Context.MODE_PRIVATE).getString("token","");
    }
    public static void setGlide(Context context, String url, ImageView imageView){
        if (url!=null){
            Glide.with(context).load(Okhttp.web+url).into(imageView);
        }
    }
    public static final List<SmartFragment.adv> advlist=new ArrayList(Arrays.asList(new SmartFragment.adv("蓝月亮",R.drawable.adv1),
            new SmartFragment.adv("百世可乐",R.drawable.adv2),new SmartFragment.adv("好吃的",R.drawable.adv3)
            ));
//    public static final List<SmartFragment.>
    public static final List<SmartFragment.babean> bannerlist=new ArrayList(Arrays.asList(
            new SmartFragment.babean("物业通知    2021年8月25日16:17:57","以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展。",R.drawable.s1),
        new SmartFragment.babean("物业通知    2021年8月25日17:17:57","以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展。",R.drawable.s2),
        new SmartFragment.babean("社区居委会通知    2021年8月25日19:17:57","以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展。",R.drawable.s3),
        new SmartFragment.babean("社区居委会通知    2021年8月25日19:17:57","以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展。",R.drawable.s3)
    ));
    public static final List<SmartFragment.car> carlist=new ArrayList(Arrays.asList(
            new SmartFragment.car("浙A43H434", "0312", "33445656", "张三", "13455617689", "张家", "1栋401")
    ));
    public static final List<S3Activity.comm> comlist=new ArrayList(Arrays.asList(
       new S3Activity.comm("张三","hh",R.drawable.find_pk1,null),
            new S3Activity.comm("张四","hh",R.drawable.find_pk2,null)
            ));
}
