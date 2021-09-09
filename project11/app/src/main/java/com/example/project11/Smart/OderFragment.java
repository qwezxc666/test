package com.example.project11.Smart;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.AllColl;
import com.example.project11.Bean.CommentBody;
import com.example.project11.Bean.OderData;
import com.example.project11.Bean.PostResultBean;
import com.example.project11.Bean.RefundBody;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class OderFragment extends Fragment {

    private TabLayout tab;
    private TabItem t1;
    private TabItem t2;
    private TabItem t3;
    private TabItem t4;
    private TabItem t5;
    private RecyclerView re;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_oder, container, false);
        tab = view.findViewById(R.id.tab);
        t1 = view.findViewById(R.id.t1);
        t2 = view.findViewById(R.id.t2);
        t3 = view.findViewById(R.id.t3);
        t4 = view.findViewById(R.id.t4);
        t5 = view.findViewById(R.id.t5);
        re=view.findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        getorder("");

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition()==0){
                    getorder("");
                }else {
                    getorder(tab.getText().toString());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

}

    private void getorder(String s) {
        Okhttp.getheand("/prod-api/api/takeout/order/list?status=" + s, Tool.getToken(getContext()), new MyCallBack(getActivity(), OderData.class) {
            @Override
            public void onFinish(Object object) {
                OderData rowsBean = (OderData) object;
                if (rowsBean!=null){
                    re.setAdapter(new CommAdapter<OderData.RowsBean>(getContext(),rowsBean.rows,R.layout.oder_item) {
                        @SuppressLint("SimpleDateFormat")
                        @Override
                        public void convert(Vh holder, OderData.RowsBean rowsBean) {
                            holder.setText(R.id.tv1,rowsBean.sellerInfo.name);
                            holder.setText(R.id.tv2,"订单状态:  "+rowsBean.orderInfo.status);
                            if (rowsBean.orderInfo.status.equals("待评价")){
                                holder.getbu(R.id.b2).setText("评价");
                                holder.getbu(R.id.b1).setText("退款");
                                holder.getbu(R.id.b1).setVisibility(View.VISIBLE);
                            }else if (rowsBean.orderInfo.status.equals("待支付")){
                                holder.getbu(R.id.b2).setText("支付");
                                holder.getbu(R.id.b1).setVisibility(View.GONE);
                            }else if (rowsBean.orderInfo.status.equals("完成")){
                                holder.getbu(R.id.b2).setText("再来一单");
                                holder.getbu(R.id.b1).setVisibility(View.GONE);
                            }else {
                                holder.getbu(R.id.b2).setVisibility(View.GONE);
                                holder.getbu(R.id.b1).setText("退款中");
                            }
                            StringBuilder stringBuilder=new StringBuilder();
                            for (OderData.RowsBean.OrderInfoBean.OrderItemListBean o:rowsBean.orderInfo.orderItemList){
                                stringBuilder.append(o.productName+"\t\t\t*"+o.quantity+"\n");
                            }
                            holder.setText(R.id.tv3,stringBuilder.toString());
                            holder.setText(R.id.tv4,"下单时间："+rowsBean.orderInfo.createTime);
                            holder.setText(R.id.tv5,"￥"+rowsBean.orderInfo.amount);
                            holder.setGlide(R.id.iv1,rowsBean.sellerInfo.imgUrl,getContext());
                            //自动评价
//                            if (getnowtime();)
                            if (rowsBean.orderInfo.status.equals("待评价")){
                                String getnowtime = getnowtime();
                                int i = getnowtime.compareTo(prase3String(rowsBean.orderInfo.createTime, 3));
                                if (i<0){
                                    //自动
                                    Okhttp.postheand("/prod-api/api/takeout/comment", Tool.getToken(getActivity()), new CommentBody("", rowsBean.orderInfo.orderNo, 5), new MyCallBack(getActivity(), PostResultBean.class) {
                                        @Override
                                        public void onFinish(Object object) {
                                            PostResultBean resultBean= (PostResultBean) object;
                                            if (resultBean.code==200){
                                                Toast.makeText(getContext(),"评论成功",Toast.LENGTH_LONG).show();
                                                Log.e("qwe",tab.getTabAt(tab.getSelectedTabPosition()).getText().toString());
                                                getorder(tab.getTabAt(tab.getSelectedTabPosition()).getText().toString());
                                            }else {
                                                Toast.makeText(getContext(),"评论失败",Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                                }else {
                                    //不评价

                                }
                            }


                            holder.getbu(R.id.b2).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //支付页面
                                    if (rowsBean.orderInfo.status.equals("待支付")){
                                        Tool.ordernum=rowsBean.orderInfo.orderNo;
                                        startActivity(new Intent(getActivity(),Post2Activity.class));

                                    }
                                    //评价对话框
                                    if (rowsBean.orderInfo.status.equals("待评价")){
                                        Tool.orderNo=rowsBean.orderInfo.orderNo;
                                        comment();

                                    }

//                                    notifyDataSetChanged();
                                    //跳转到详情页面
                                    if (rowsBean.orderInfo.status.equals("完成")){
                                        Tool.shopid=rowsBean.sellerInfo.id;
                                        startActivity(new Intent(getActivity(),ShopInforActivity.class));

                                    }
                                }
                            });
                            holder.getbu(R.id.b1).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //退款对话框
                                    Tool.orderNo=rowsBean.orderInfo.orderNo;
                                    refund();

//                                    notifyDataSetChanged();
                                }
                            });
//                            notifyDataSetChanged();
                        }
                    });
                }

            }
        });
    }
    private String prase3String(String s,int i){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t=s;
        String o = "";
        try {
            Date date=format.parse(t);
             o = getaddtime(date, i);
            Log.e("t",o);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return o;
    }
    private String getaddtime(Date t,int i){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar dd=Calendar.getInstance();
        dd.setTime(t);
        dd.add(Calendar.DATE,3);
        String format1 = format.format(dd.getTime());
        return format1;
    }
    private String  getnowtime(){
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },259200000);
        return time;
    }
    private void comment(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog dialog=builder.create();
        View view=View.inflate(getActivity(),R.layout.comment_item,null);
        dialog.setView(view);
        dialog.show();
        EditText editText=view.findViewById(R.id.et1);

        RatingBar bar=view.findViewById(R.id.star);


        Button button=view.findViewById(R.id.b1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();
                int numStars = bar.getNumStars();
                if (s.isEmpty()){
                    Toast.makeText(getActivity(),"评论内容不能为空",Toast.LENGTH_LONG).show();

                }
                Okhttp.postheand("/prod-api/api/takeout/comment", Tool.getToken(getActivity()), new CommentBody(s, Tool.orderNo, numStars), new MyCallBack(getActivity(), PostResultBean.class) {
                    @Override
                    public void onFinish(Object object) {
                        PostResultBean resultBean= (PostResultBean) object;
                        if (resultBean.code==200){
                            Toast.makeText(getContext(),"评论成功",Toast.LENGTH_LONG).show();
                            Log.e("qwe",tab.getTabAt(tab.getSelectedTabPosition()).getText().toString());
                            getorder(tab.getTabAt(tab.getSelectedTabPosition()).getText().toString());
                        }else {
                            Toast.makeText(getContext(),"评论失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


    }
    private void refund(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog dialog=builder.create();
        View view=View.inflate(getActivity(),R.layout.comment_item,null);
        dialog.setView(view);
        dialog.show();
        EditText editText=view.findViewById(R.id.et1);

        RatingBar bar=view.findViewById(R.id.star);
        bar.setVisibility(View.GONE);
        Button button=view.findViewById(R.id.b1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();

                if (s.isEmpty()){
                    Toast.makeText(getActivity(),"评论内容不能为空",Toast.LENGTH_LONG).show();

                }
                Okhttp.postheand("/prod-api/api/takeout/order/refound", Tool.getToken(getActivity()), new RefundBody( Tool.orderNo,s), new MyCallBack(getActivity(),PostResultBean.class) {
                    @Override
                    public void onFinish(Object object) {
                        PostResultBean resultBean= (PostResultBean) object;
                        if (resultBean.code==200){
                            Toast.makeText(getContext(),"退款成功",Toast.LENGTH_LONG).show();
                            getorder(tab.getTabAt(tab.getSelectedTabPosition()).getText().toString());
                        }else {
                            Toast.makeText(getContext(),"退款失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}