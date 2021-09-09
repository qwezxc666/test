package com.example.porject09.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porject09.Bean.AdvBean;
import com.example.porject09.Bean.AllCarBean;
import com.example.porject09.CommAdapter;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;
import com.example.porject09.ui.Activity.M12Activity;
import com.example.porject09.ui.Activity.M1Activity;
import com.example.porject09.ui.Activity.M2Activity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Banner b1;
    private SearchView search;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initView(root);
        getbanner();
        return root;
    }
    private void getcar(){
        Okhttp.get("/prod-api/api/traffic/car/list", Tool.getToken(getContext()), new MyCallback(getActivity(), AllCarBean.class) {
            @Override
            public void onFinsh(Object o) {
                AllCarBean allCarBean= (AllCarBean) o;

                if (allCarBean.total!="0"){
                    startActivity(new Intent(getActivity(), M12Activity.class));

                }else {
                    startActivity(new Intent(getActivity(), M1Activity.class));
                }
            }
        });
    }
    private void initView(View view) {
        b1 = (Banner) view.findViewById(R.id.b1);
        search = (SearchView) view.findViewById(R.id.search);
        rb1 = (RadioButton) view.findViewById(R.id.rb1);
        rb2 = (RadioButton) view.findViewById(R.id.rb2);
        rb3 = (RadioButton) view.findViewById(R.id.rb3);
        rb4 = (RadioButton) view.findViewById(R.id.rb4);
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcar();
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), M2Activity.class));
            }
        });
    }
    public void getbanner(){

        Okhttp.get("/prod-api/api/traffic/rotation/list", new MyCallback(getActivity(), AdvBean.class) {
            @Override
            public void onFinsh(Object o) {
                final AdvBean advBean= (AdvBean) o;
                b1.setImages(advBean.rows).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object o, final ImageView imageView) {
                        final AdvBean.RowsBean rowsBean= (AdvBean.RowsBean) o;
                        Tool.setGlide(getContext(),rowsBean.advImg,imageView);
                        b1.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int i) {
                                AdvBean.RowsBean r=advBean.rows.get(i);
                                Tool.newsid= (int) r.id;

                            }
                        });
                    }
                });
                
                b1.start();
            }
        });
    }
}