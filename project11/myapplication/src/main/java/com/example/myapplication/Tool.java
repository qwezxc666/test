package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiang.ordertakeout.model.AddressData;
import com.jiang.ordertakeout.model.FoodData;
import com.jiang.ordertakeout.model.SellerData;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;


public class Tool {
    public static void loadImg(String url, ImageView imageView) {
        try{
            Glide.with(imageView.getContext())
                    .load(HttpUtil.BASE_URL + url)
                    .into(imageView);
        }catch (Exception e){
            Log.e("Error",e.toString());
        }
    }

    public static SharedPreferences getSP(Context context) {
        return context.getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    public static String getToken(Context context) {
        return getSP(context).getString("token", "");
    }

    public static String getUserId(Context context) {
        return getSP(context).getString("userId", "");
    }


    public static SellerData.RowsModel seller;

    public static int themeID = -1;
    public static String foodKey;

    public static AddressData.DataModel address;
    public static final HashMap<FoodData.DataModel, Integer> FOOD_MAP = new HashMap<>();

    public static BigDecimal getMoney() {
        final BigDecimal[] bigDecimal = {new BigDecimal(0)};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            FOOD_MAP.forEach((dataModel, integer) -> {
                if (integer > 0) {
                    bigDecimal[0] = bigDecimal[0].add(new BigDecimal(dataModel.price).multiply(new BigDecimal(integer)));
                }
            });
        } else {
            for (FoodData.DataModel dataModel : FOOD_MAP.keySet()) {
                Integer integer = FOOD_MAP.get(dataModel);
                if (integer > 0) {
                    bigDecimal[0] = bigDecimal[0].add(new BigDecimal(dataModel.price).multiply(new BigDecimal(integer)));
                }
            }
        }
        return bigDecimal[0].setScale(2, RoundingMode.HALF_EVEN);
    }

    public static final LinkedList<Activity> ACTIVITIES = new LinkedList<>();

    public static String orderNo;
}
