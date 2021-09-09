package com.example.project02.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.CommAdapter;
import com.example.project02.MyCallback;
import com.example.project02.NewsBean;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private RecyclerView news;
    private List<NewsBean.RowsBean> rows=new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        initView(root);
        Okhttp.get("/prod-api/press/press/list", new MyCallback(getActivity(), NewsBean.class) {
            @Override
            public void onFish(Object o) {
                NewsBean newsBean = (NewsBean) o;
                if (Tool.name!=null){
                    for (NewsBean.RowsBean newsBean1:newsBean.rows){
                        if (newsBean1.title.contains(Tool.name)){
                            rows.add(newsBean1);
                        }
                    }
                    news.setAdapter(new CommAdapter<NewsBean.RowsBean>(rows,getActivity(),R.layout.new_item) {

                        @Override
                        public void convert(Vh holder, NewsBean.RowsBean rowsBean) {
                            if (rows.size()!=0){
                                holder.setText(R.id.tv1,rowsBean.title);
                                ///\<[^>]+>/g
                                String s="<.+?>";
                                Pattern pa=Pattern.compile(s,Pattern.DOTALL);
                                Matcher matcher=pa.matcher(rowsBean.content);
//                        pa.matcher()
                                holder.setText(R.id.tv2,matcher.replaceAll(""));
                                holder.setText(R.id.tv3,"评论总数："+rowsBean.commentNum+"\n"+rowsBean.publishDate);
                                holder.setGlide(R.id.iv1,rowsBean.cover,getContext());
                            }

                        }
                    });
                }

            }
        });
        return root;
    }


    private void initView(View view) {
        news = (RecyclerView) view.findViewById(R.id.news);
        news.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}