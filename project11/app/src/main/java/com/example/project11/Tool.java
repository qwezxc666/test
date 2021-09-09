package com.example.project11;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project11.Bean.AddAddress;
import com.example.project11.Bean.AddressBean;
import com.example.project11.Bean.AllColl;
import com.example.project11.Bean.FoodBean;
import com.example.project11.Bean.Foods;
import com.example.project11.Bean.NewBean;
import com.example.project11.Bean.OderData;
import com.example.project11.ui.home.S3Activity;
import com.example.project11.ui.home.S4Activity;
import com.example.project11.ui.home.SmartFragment;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Tool {
    public static int i;
    public static String foodname;
    public static FoodBean.RowsBean shop;
    public static String ordernum;
    public static NewBean.RowsBean rowsBean;
    public static AddressBean.DataBean address;
    public static AllColl.RowsBean allcoll;
    public static int shopid;
    public static String orderNo;
    public static  SmartFragment.advBean adv;
    public static S4Activity.car car;
    public static int carid=-1;
    public static String getToken(Context context){
        return context.getSharedPreferences("app",Context.MODE_PRIVATE).getString("token","");
    }
    public static void getGlide(Context context, String url, ImageView imageView){
        if (url!=null){
             Glide.with(context).load(Okhttp.web+url).into(imageView);

        }
    }
    public static final HashMap<Foods.DataBean,Integer> FOOD_MAP=new HashMap<>();
    public static BigDecimal getmoney(){
        final BigDecimal[]bigDecimals={new BigDecimal(0)};
        Tool.FOOD_MAP.forEach((dataBean, integer) -> {
            if (integer>0){
                bigDecimals[0]=bigDecimals[0].add(new BigDecimal(dataBean.price).multiply(new BigDecimal(integer)));
            }
        });
        return bigDecimals[0].setScale(2,BigDecimal.ROUND_DOWN);
    }
    public static final List<SmartFragment.notifyBean> notfiylist=new ArrayList(
            Arrays.asList(new SmartFragment.notifyBean(R.drawable.s1,"物业通知    2021年8月25日16:17:57","“以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展。"),
            new SmartFragment.notifyBean(R.drawable.s2,"物业通知    2021年8月25日17:17:57","“以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展"),
                    new SmartFragment.notifyBean(R.drawable.s3,"社区居委会通知    2021年8月25日19:17:57","“以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展"),
                    new SmartFragment.notifyBean(R.drawable.s4,"社区居委会通知    2021年8月25日22:17:57","“以智慧小区提升社区品质”是社区管理的目标，社区引入智慧平台的能够有效推动经济流动，促进现代服务业发展")));

    public static final List<SmartFragment.advBean> advList=new ArrayList<>(
            Arrays.asList(new SmartFragment.advBean(R.drawable.adv1,"蓝月亮"),
                    new SmartFragment.advBean(R.drawable.adv2,"百世可乐"),
                    new SmartFragment.advBean(R.drawable.adv3,"好吃的")
                    ));
    public static final List<S4Activity.car> carList=new ArrayList<>(Arrays.asList(
            new S4Activity.car("浙A43H434","666","13331","张三","1113124121","张某人","这里")));
    public static final List<S3Activity.com> comList=new ArrayList<>(Arrays.asList(
       new S3Activity.com(R.drawable.find_pk1,"社友001","哈哈哈"),new S3Activity.com(R.drawable.find_pk2,"社友111","ohhhh")
    ));
}
