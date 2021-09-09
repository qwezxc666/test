package com.example.project11.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.project11.Bean.Coll;
import com.example.project11.Bean.CollBean;
import com.example.project11.Bean.FoodBean;
import com.example.project11.Bean.PostResultBean;
import com.example.project11.Bean.ShopSingleBean;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ShopInforActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv1;
    private TextView tv0;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private RatingBar ra;
    private TabItem t1;
    private TabItem t2;
    private TabItem t3;
    private TabLayout tab;
    private ViewPager2 vp;
    private TextView num;
    private Button b1;
    public FoodFragment foodFragment;
    public Fragment fragment;
    public CommentFragment commentFragment;
    public InFragment inFragment;
    private int i=0;
    private boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_infor);
        initView();
        setTitle("店铺详情");

        set();

        judge();

        tv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge();
                qwe();
            }
        });
    }

    private void set() {
        i=Tool.shopid;
        Okhttp.get("/prod-api/api/takeout/seller/" + i, new MyCallBack(getthis(), ShopSingleBean.class) {
            @Override
            public void onFinish(Object object) {
                ShopSingleBean rowsBean= (ShopSingleBean) object;
                tv1.setText(rowsBean.data.name);
                Tool.getGlide(getthis(),rowsBean.data.imgUrl,iv1);
                tv2.setText("月销量："+rowsBean.data.saleQuantity+"    "+rowsBean.data.distance+"m     "+rowsBean.data.deliveryTime+"分钟");
                ra.setRating((int) rowsBean.data.score);
                tv3.setText("人均消费："+rowsBean.data.avgCost);
            }
        });
//        if (rowsBean!=null){
//
//        }else {
//
//            Tool.getGlide(getApplicationContext(),Tool.allcoll.imgUrl,iv1);
//            tv1.setText(Tool.allcoll.sellerName);
//            tv2.setText("月销量："+Tool.allcoll.saleQuantity);
//            ra.setRating((int) Tool.allcoll.score);
//            tv3.setText("人均消费：");
//        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Tool.FOOD_MAP.clear();
        Tool.getmoney();
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv0 = (TextView) findViewById(R.id.tv0);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        ra = (RatingBar) findViewById(R.id.ra);
        t1 = (TabItem) findViewById(R.id.t1);
        t2 = (TabItem) findViewById(R.id.t2);
        t3 = (TabItem) findViewById(R.id.t3);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager2) findViewById(R.id.vp);
        num = (TextView) findViewById(R.id.num);
        b1 = (Button) findViewById(R.id.b1);
        foodFragment = new FoodFragment();
        fragment = new Fragment();
        commentFragment=new CommentFragment();
        inFragment=new InFragment();
        b1.setOnClickListener(this);
        vp.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 3;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return position==0?foodFragment:(position==1?commentFragment:inFragment);
//                return position == 0 ? foodFragment : commentFragment;


            }


        });

        new TabLayoutMediator(tab, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("点菜");
                }
                if (position == 1) {
                    tab.setText("评价");
                }
                if (position == 2) {
                    tab.setText("商家介绍");
                }
            }
        }).attach();
    }
    private void judge(){
        Okhttp.getheand("/prod-api/api/takeout/collect/check?sellerId="+i, Tool.getToken(getthis()), new MyCallBack(getthis(), Coll.class) {
            @Override
            public void onFinish(Object object) {
                Coll coll= (Coll) object;
                Log.e("qz",coll.isCollect+coll.msg);
                if (coll.code==200){
                    i=coll.id;
                    flag=coll.isCollect;
                    if (flag){
                        tv0.setText("取消收藏");
                    }else {

                        tv0.setText("收藏店铺");
                    }
                }
            }
        });
    }
    private void noCollection(){
        Okhttp.delete("/prod-api/api/takeout/collect/" + i, Tool.getToken(getthis()), new MyCallBack(getthis(),PostResultBean.class) {
            @Override
            public void onFinish(Object object) {
                PostResultBean postResultBean= (PostResultBean) object;
                Log.e("qwe",postResultBean.msg+postResultBean.code);
                if (postResultBean.code==200){
                    maketoast("取消收藏");
                }else {
                    Log.e("q",postResultBean.msg);
                    maketoast("取消收藏失败");
                }
            }
        });
    }
    private void qwe(){
        if (flag){
            noCollection();

            flag=false;
        }else {
            Collection();
            flag=true;
        }
    }
    private void Collection(){
        Okhttp.postheand("/prod-api/api/takeout/collect", Tool.getToken(getthis()), new CollBean(i), new MyCallBack(getthis(), PostResultBean.class) {
            @Override
            public void onFinish(Object object) {
                PostResultBean resultBean= (PostResultBean) object;
                Log.e("qwww",resultBean.msg+resultBean.code);
                if (resultBean.code==200){
                    maketoast("收藏成功");
                }else {
                    maketoast("收藏失败");
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                if (!num.getText().toString().equals("￥0.00")){

                    startActivity(new Intent(getApplicationContext(),PostActivity.class));
                }
                break;
        }
    }
    public void refresh(){
        num.setText("￥"+Tool.getmoney().toString());
    }
    public void post(){

    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
//        judge();
    }
}