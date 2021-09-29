package com.example.test10.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test10.Activity.F1Activity;
import com.example.test10.Activity.F2Activity;
import com.example.test10.Activity.F3Activity;
import com.example.test10.Activity.F4Activity;
import com.example.test10.Activity.F5Activity;
import com.example.test10.Activity.FnewsinforActivity;
import com.example.test10.CommAdapter;
import com.example.test10.R;
import com.example.test10.Tool;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private Banner banner;
    private RecyclerView re;
    private RecyclerView re2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        initView(root);

        return root;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        re = (RecyclerView) view.findViewById(R.id.re);
        re2 = (RecyclerView) view.findViewById(R.id.re2);
        re.setLayoutManager(new GridLayoutManager(getContext(),5));
        re2.setLayoutManager(new LinearLayoutManager(getContext()));
        List<tb> tbList=new ArrayList<>(Arrays.asList(
                new tb("入户走访",R.drawable.z1),
                new tb("扶贫案例",R.drawable.z2),
                new tb("收到求助",R.drawable.z3),
                new tb("村情村貌",R.drawable.z4),
                new tb("案例发布",R.drawable.z5)

        ));
        List<tb> tbList1=new ArrayList<>(Arrays.asList(
                new tb("新闻1",R.drawable.new1),
                new tb("新闻2",R.drawable.new2),
                new tb("新闻3",R.drawable.find_pk1)
        ));
        banner.setIndicator(new CircleIndicator(getContext()))
                .setAdapter(new BannerImageAdapter<tb>(tbList1) {
                    @Override
                    public void onBindView(BannerImageHolder bannerImageHolder, tb tb, int i, int i1) {
                        bannerImageHolder.imageView.setImageResource(tb.i1);
                    }

                }).setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(Object o, int i) {
                Tool.newbean=tbList1.get(i);
                startActivity(new Intent(getContext(), FnewsinforActivity.class));
            }
        });
        re.setAdapter(new CommAdapter<tb>(getContext(),tbList,R.layout.tb2_item) {
            @Override
            public void convert(Vh convert, tb tb) {
                convert.setGlide(R.id.iv1,tb.i1);
                convert.setText(R.id.tv1,tb.s1);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (convert.getAdapterPosition()==0){
                            startActivity(new Intent(getActivity(), F1Activity.class));
                        }
                        if (convert.getAdapterPosition()==1){
                            startActivity(new Intent(getActivity(), F2Activity.class));
                        }
                        if (convert.getAdapterPosition()==2){
                            startActivity(new Intent(getActivity(), F3Activity.class));
                        }
                        if (convert.getAdapterPosition()==3){
                            startActivity(new Intent(getActivity(), F4Activity.class));
                        }
                        if (convert.getAdapterPosition()==4){
                            startActivity(new Intent(getActivity(), F5Activity.class));
                        }
                    }
                });
            }

        });
        re2.setAdapter(new CommAdapter<tb>(getContext(),tbList1,R.layout.new_item) {
            @Override
            public void convert(Vh convert, tb tb) {
                convert.setText(R.id.tv1,tb.s1);
                convert.setGlide(R.id.iv1,tb.i1);
                convert.seton(R.id.l1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tool.newbean=tb;
                        startActivity(new Intent(getActivity(),FnewsinforActivity.class));
                    }
                });
            }
        });
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