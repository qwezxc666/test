package com.example.cse01.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse01.Bean.NewsBean;
import com.example.cse01.CommAdapter;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private RecyclerView re;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (Tool.name!=null){
        initView(view);

        }else {

        }
    }

    private void initView(View view) {
        re = (RecyclerView) view.findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        Okhttp.get("/prod-api/press/press/list" , new MyCallback(getActivity(), NewsBean.class) {
            @Override
            public void onFish(Object o) {
                NewsBean newsBean= (NewsBean) o;
                List<NewsBean.RowsBean> list=new ArrayList<>();
                for (NewsBean.RowsBean rowsBean:newsBean.rows){
                    if (rowsBean.title.contains(Tool.name)){
                        list.add(rowsBean);
                    }
                }
                if (list.size()==0){
                    Toast.makeText(activity, "未找到相关结果", Toast.LENGTH_SHORT).show();
                }
                re.setLayoutManager(new LinearLayoutManager(getContext()));
                re.setAdapter(new CommAdapter<NewsBean.RowsBean>(getContext(),list,R.layout.news_item) {
                    @Override
                    public void convert(Vh holder, NewsBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.title);
                        holder.setText(R.id.tv2,rowsBean.content.replaceAll("(\\d{2})\\d{14}(\\d{4})","$1*****$2"));
                        holder.setText(R.id.tv3,"评论总数："+rowsBean.commentNum+"\n"+rowsBean.createTime);
                        holder.setGlide(R.id.iv1,rowsBean.cover);
                    }
                });
            }
        });
    }
}