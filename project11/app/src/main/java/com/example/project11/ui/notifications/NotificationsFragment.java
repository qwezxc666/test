package com.example.project11.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.NewBean;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.NewInforActivity;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private RecyclerView news;
    private List<NewBean.RowsBean> list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        news=root.findViewById(R.id.news);
        news.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String key = getArguments() != null ? getArguments().getString("key") : "";
        Okhttp.get("/prod-api/press/press/list",new MyCallBack(getActivity(), NewBean.class) {
            @Override
            public void onFinish(Object object) {

                list=new ArrayList<>();
                if (!key.isEmpty()){
                    NewBean newBean= (NewBean) object;
                    for (NewBean.RowsBean rowsBean:newBean.rows){
                        if (rowsBean.title.contains(key)){
                            list.add(rowsBean);
                        }
                    }
                    news.setAdapter(new CommAdapter<NewBean.RowsBean>(getContext(),list,R.layout.news_item) {
                        @Override
                        public void convert(Vh holder, NewBean.RowsBean rowsBean) {
                            holder.setText(R.id.tv1,rowsBean.title);
                            holder.setText(R.id.tv2,rowsBean.content.replace("<p>",""));
                            holder.setText(R.id.tv3,rowsBean.publishDate);
                            holder.setText(R.id.tv4,"评论数："+rowsBean.commentNum);
                            holder.setGlide(R.id.iv1,rowsBean.cover,getContext());
                            holder.setOnListen(R.id.l1, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Tool.rowsBean=rowsBean;
                                    startActivity(new Intent(getActivity(), NewInforActivity.class));
                                }
                            });
                        }

                    });
                }
                }

        });
    }
}