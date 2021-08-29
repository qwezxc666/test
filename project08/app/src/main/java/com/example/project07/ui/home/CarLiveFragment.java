package com.example.project07.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project07.Bean.NewBean;
import com.example.project07.Bean.ResultBean;
import com.example.project07.Bean.TypeBean;
import com.example.project07.Bean.newb;
import com.example.project07.CommAdapter;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;
import com.example.project07.ui.Acitvity.NewsInforActivity;
import com.google.android.material.tabs.TabLayout;


public class CarLiveFragment extends Fragment {

    private RecyclerView re;
    private TabLayout tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_live, container, false);
        initView(view);
        getnew(13);
        return view;
    }

    private void getnew(int i) {
        Okhttp.get("/prod-api/api/park/press/press/list?type=" + i, new MyCallback(getActivity(), NewBean.class) {
            @Override
            public void onFish(Object o) {
                NewBean newBean = (NewBean) o;
                re.setAdapter(new CommAdapter<NewBean.RowsBean>(getContext(), newBean.rows, R.layout.new_item) {
                    @Override
                    public void convert(Vh holder, NewBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1, rowsBean.title);
                        holder.setText(R.id.tv2, "阅读数：" + rowsBean.readNum);
                        holder.setGlide(R.id.iv1, getContext(), rowsBean.cover);
                        holder.setText(R.id.tv3, rowsBean.createTime);
                        holder.getBu(R.id.b1).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                like(rowsBean.id);
                            }
                        });
                        holder.setonListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Tool.newsBean=rowsBean;
                                startActivity(new Intent(getActivity(), NewsInforActivity.class));
                            }
                        });

                    }


                });
            }
        });
    }
    private void like(int i){
//        newb newb=new newb(i);
        Okhttp.putheand("/prod-api/api/park/press/press/like/" + i, Tool.gettoken(getContext()), "", new MyCallback(getActivity(), ResultBean.class) {
            @Override
            public void onFish(Object o) {
                ResultBean resultBean= (ResultBean) o;
                if (resultBean.code==200){
                    Toast.makeText(getContext(), "点赞成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "点赞失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void initView(View view) {
        re = (RecyclerView) view.findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        tab = (TabLayout) view.findViewById(R.id.tab);
        Okhttp.get("/prod-api/api/park/press/category/list", new MyCallback(getActivity(), TypeBean.class) {
            @Override
            public void onFish(Object o) {
                TypeBean typeBean= (TypeBean) o;
                for (TypeBean.DataBean rowsBean:typeBean.data){
                   tab.addTab(tab.newTab().setText(rowsBean.name));

                }
            }
        });
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               if (tab.getPosition()==0){
                    getnew(13);

               }
                if (tab.getPosition()==1){
                    getnew(14);

                }
                if (tab.getPosition()==2){
                    getnew(15);

                }
                if (tab.getPosition()==3){
                    getnew(24);

                }
                if (tab.getPosition()==4){
                    getnew(25);

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
}