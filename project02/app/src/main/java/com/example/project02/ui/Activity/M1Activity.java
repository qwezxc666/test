package com.example.project02.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.Adv2Bean;
import com.example.project02.Bean.AdvBean;
import com.example.project02.Bean.NewTypeBean;
import com.example.project02.Bean.News2Bean;
import com.example.project02.Bean.ResultBean;
import com.example.project02.Bean.SignupBean;
import com.example.project02.CommAdapter;
import com.example.project02.MyCallback;
import com.example.project02.NewsBean;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

public class M1Activity extends BaseActivity {

    private Banner banner;
    private TabLayout tab;
    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
        setTitle("活动");
        initView();

        setBanner();
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        tab = (TabLayout) findViewById(R.id.tab);
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));

    }
    private void setBanner(){
        Okhttp.get("/prod-api/api/activity/rotation/list", new MyCallback(getthis(), Adv2Bean.class) {
            @Override
            public void onFish(Object o) {
                final Adv2Bean advBean = (Adv2Bean) o;
                banner.setImages(advBean.rows).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object o, ImageView imageView) {
                        Adv2Bean.RowsBean adv = (Adv2Bean.RowsBean) o;
                        Tool.setGlide(getthis(), adv.advImg, imageView);
                        banner.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int i) {

                            }
                        });
                    }
                }).start();
            }
        });
        Okhttp.get("/prod-api/api/activity/category/list", new MyCallback(getthis(), NewTypeBean.class) {
            @Override
            public void onFish(Object o) {
                NewTypeBean newTypeBean = (NewTypeBean) o;
                for (NewTypeBean.DataBean newTypeBean1 : newTypeBean.data) {
                    tab.addTab(tab.newTab().setText(newTypeBean1.name));
                }
                tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        if (tab.getPosition()==0){
                            getnew(1);
                        }
                        if (tab.getPosition()==1){
                            getnew(2);
                        }
                        if (tab.getPosition()==2){
                            getnew(3);
                        }
                        if (tab.getPosition()==3){
                            getnew(4);
                        }
                        if (tab.getPosition()==4){
                            getnew(5);
                        }
                        if (tab.getPosition()==5){
                            getnew(6);
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        });
    }
    private void getnew(int i){
        Okhttp.get("/prod-api/api/activity/activity/list?categoryId=" + i, new MyCallback(getthis(), News2Bean.class) {
            @Override
            public void onFish(Object o) {
                News2Bean newsBean = (News2Bean) o;
                re.setAdapter(new CommAdapter<News2Bean.RowsBean>(newsBean.rows,getthis(),R.layout.activity_item) {

                    @Override
                    public void convert(Vh holder, final News2Bean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.name);
                        holder.setText(R.id.tv2,"报名人数："+rowsBean.signupNum);
                        holder.setText(R.id.tv3,"点赞总数："+rowsBean.likeNum);
                        holder.setGlide(R.id.iv1,rowsBean.imgUrl,getthis());
                        holder.getbutton(R.id.b1).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                signup(rowsBean.id);
                            }
                        });
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.act=rowsBean;
                                startActivity(new Intent(getthis(),M1InforActivity.class));
                            }
                        });
                    }

                });
            }
        });
    }
    private void signup(int id){
        Okhttp.post("/prod-api/api/activity/signup", new SignupBean(id), new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFish(Object o) {
                ResultBean bean= (ResultBean) o;
                if (bean.code.equals(200)){
                    maketoast("报名成功");
                }else {
                    maketoast(bean.msg);
                }

            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        getnew(1);
    }
}