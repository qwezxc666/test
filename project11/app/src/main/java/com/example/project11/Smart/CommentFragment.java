package com.example.project11.Smart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.CommBean;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;


public class CommentFragment extends Fragment {


    private RecyclerView re;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        re=view.findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        Okhttp.get("/prod-api/api/takeout/comment/list?sellerId=" + Tool.shopid, new MyCallBack(getActivity(),CommBean.class) {
            @Override
            public void onFinish(Object object) {
                CommBean commBean= (CommBean) object;
                re.setAdapter(new CommAdapter<CommBean.RowsBean>(getContext(),commBean.rows,R.layout.comm_item) {

                    @Override
                    public void convert(Vh holder, CommBean.RowsBean rowsBean) {
                        if (commBean!=null){
                            holder.setText(R.id.tv1,rowsBean.nickName);
                            holder.setText(R.id.tv2,rowsBean.content+"\n"+rowsBean.replyTime);
                            holder.setGlide(R.id.iv1,"/prod-api"+rowsBean.avatar,getContext());
                            holder.setRat(R.id.star,rowsBean.score);
                        }

                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}