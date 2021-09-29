package com.example.test10.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.Activity.Y1Activity;
import com.example.test10.Activity.Y2Activity;
import com.example.test10.Activity.Y3Activity;
import com.example.test10.Activity.Y4Activity;
import com.example.test10.Activity.YlyInforActivity;
import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.Tool;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private Banner banner;
    private SearchView search;
    private RecyclerView re;
    private RecyclerView re2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView(root);

        return root;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        search = (SearchView) view.findViewById(R.id.search);
        re = (RecyclerView) view.findViewById(R.id.re);
        List<Integer> list = new ArrayList();
        list.add(R.drawable.ss1);
        list.add(R.drawable.ss2);
        list.add(R.drawable.ss3);
        list.add(R.drawable.ss4);
        banner.setIndicator(new CircleIndicator(getContext()));
        banner.setAdapter(new BannerImageAdapter<Integer>(list) {
            @Override
            public void onBindView(BannerImageHolder bannerImageHolder, Integer integer, int i, int i1) {
                bannerImageHolder.imageView.setImageResource(integer);
            }

        });
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                for (int i = 0; i < Tool.ylyList.size(); i++) {
                    if (query.equals(Tool.ylyList.get(i).s1)) {
                        Tool.ylybean = Tool.ylyList.get(i);
                        startActivity(new Intent(getActivity(), YlyInforActivity.class));
                    } else {
                        Toast.makeText(getContext(), "找不到结果", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        re.setAdapter(new CommAdapter<yly>(getContext(), Tool.ylyList, R.layout.yly_item) {
            @Override
            public void convert(Vh convert, yly yly) {
                convert.setText(R.id.tv1, yly.s1);
                convert.setText(R.id.tv2, yly.s2);
                convert.getrat(R.id.rat).setRating(5);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.ylybean = yly;
                        startActivity(new Intent(getActivity(), YlyInforActivity.class));
                    }
                });
            }
        });
        re2 = (RecyclerView) view.findViewById(R.id.re2);
        re2.setLayoutManager(new GridLayoutManager(getContext(),4));
        List<tb> list1=new ArrayList<>(Arrays.asList(
            new tb("健康评估",R.drawable.d1),
                new tb("监测环境",R.drawable.d2),
                new tb("巡检记录",R.drawable.d3),
                new tb("集中监测",R.drawable.d4)
        ));
        re2.setAdapter(new CommAdapter<tb>(getContext(),list1,R.layout.tb_item) {
            @Override
            public void convert(Vh convert, tb tb) {
                convert.setText(R.id.tv1,tb.s1);
                convert.setGlide(R.id.iv1,tb.i1);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (convert.getAdapterPosition()==0){
                            startActivity(new Intent(getActivity(), Y1Activity.class));
                        }
                        if (convert.getAdapterPosition()==2){
                            startActivity(new Intent(getActivity(), Y3Activity.class));
                        }
                        if (convert.getAdapterPosition()==1){
                            startActivity(new Intent(getActivity(), Y2Activity.class));
                        }
                        if (convert.getAdapterPosition()==3){
                            startActivity(new Intent(getActivity(), Y4Activity.class));
                        }
                    }
                });
            }
        });
    }

    public static class yly {
        public String s1, s2;
        public int i1;

        public yly(String s1, String s2, int i1) {
            this.s1 = s1;
            this.s2 = s2;
            this.i1 = i1;
        }
    }
    public static class tb{
        public String s1;
        public int i1;

        public tb(String s1, int i1) {
            this.s1 = s1;
            this.i1 = i1;
        }
    }
}