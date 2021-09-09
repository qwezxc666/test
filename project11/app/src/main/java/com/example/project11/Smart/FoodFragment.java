package com.example.project11.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project11.Bean.FoodTpe;
import com.example.project11.Bean.Foods;
import com.example.project11.CommAdapter;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;


public class FoodFragment extends Fragment {


    private RecyclerView r1;
    private RecyclerView r2;
    private int i;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        r1=view.findViewById(R.id.r1);
        r2=view.findViewById(R.id.r2);
        r1.setLayoutManager(new LinearLayoutManager(getContext()));
        r2.setLayoutManager(new LinearLayoutManager(getContext()));
        i=Tool.shopid;
//        gettype();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((ShopInforActivity)getActivity()).refresh();
//        gettype();
    }

    @Override
    public void onResume() {
        super.onResume();
        gettype();
    }

    private void gettype() {

        Okhttp.get("/prod-api/api/takeout/category/list?sellerId=" +i , new MyCallBack(getActivity(), FoodTpe.class) {
            @Override
            public void onFinish(Object object) {
                FoodTpe tpe= (FoodTpe) object;
                r1.setAdapter(new CommAdapter<FoodTpe.DataBean>(getContext(),tpe.data,R.layout.type_item) {

                    @Override
                    public void convert(Vh holder, FoodTpe.DataBean dataBean) {
                        if (holder.getAdapterPosition()==0){
                            food(dataBean.id);
                        }
                        Log.e("qwe",dataBean.name);
                        holder.setText(R.id.t,dataBean.name);
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                food(dataBean.id);
                            }
                        });
                    }
                });
            }
        });


    }
    private void food(int num){

        Okhttp.get("/prod-api/api/takeout/product/list?sellerId=" + i + "&categoryId=" + num, new MyCallBack(getActivity(), Foods.class) {
            @Override
            public void onFinish(Object object) {
                Foods foods= (Foods) object;
                r2.setAdapter(new CommAdapter<Foods.DataBean>(getContext(),foods.data,R.layout.cd_item) {
                    @Override
                    public void convert(Vh holder, Foods.DataBean dataBean) {
                        holder.setText(R.id.tv1,dataBean.name);
                        holder.setText(R.id.tv2,"月销量："+dataBean.saleQuantity+"\n"+"好评率："+dataBean.favorRate+"%");
                        holder.setText(R.id.tv3,"￥"+dataBean.price);
                        holder.setGlide(R.id.iv1,dataBean.imgUrl,getContext());
                        TextView text = holder.getText(R.id.num);

                        Integer in=Tool.FOOD_MAP.get(dataBean);
                        if (in!=null&&in>=1){
                            holder.setbutton(R.id.b1).setVisibility(View.VISIBLE);
                        }else {
                            holder.setbutton(R.id.b1).setVisibility(View.GONE);
                        }
                        holder.setText(R.id.num,in==null?"0":in+"");
                        holder.setbutton(R.id.b1).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (in!=null&&in>1){
                                     Tool.FOOD_MAP.put(dataBean,in-1);

                                }else {

                                    Tool.FOOD_MAP.put(dataBean,0);
                                    Tool.FOOD_MAP.remove(dataBean);

                                }
//                                    if (in!=null&&in>1){
//                                        int value=in-1;
//                                        holder.setText(R.id.num,value+"");
//                                        Tool.FOOD_MAP.put(dataBean,value);
//                                    }else{
//
//                                            holder.setText(R.id.num,0+"");
//                                            Tool.FOOD_MAP.put(dataBean,0);
//                                            Tool.FOOD_MAP.remove(dataBean);
//
//                                    }

                                ((ShopInforActivity)getActivity()).refresh();
                                    notifyItemChanged(holder.getAdapterPosition());
                                    notifyDataSetChanged();

                                }

                        });
                        //加
                        holder.setbutton(R.id.b2).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (in!=null&&in!=0){
                                    Tool.FOOD_MAP.put(dataBean,in+1);
                                }else {

                                    Tool.FOOD_MAP.put(dataBean,1);
                                }

                                Log.e("qwe",in+"");

                                ((ShopInforActivity)getActivity()).refresh();
                                notifyItemChanged(holder.getAdapterPosition());
                                notifyDataSetChanged();
                            }
                        });

                    }

                });
            }
        });
    }
}