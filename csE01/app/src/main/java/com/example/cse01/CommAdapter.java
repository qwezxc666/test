package com.example.cse01;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public abstract class CommAdapter<T> extends RecyclerView.Adapter<CommAdapter.Vh> {
    public Context context;
    public List<T> list;
    public int layouit;

    public CommAdapter(Context context, List<T> list, int layouit) {
        this.context = context;
        this.list = list;
        this.layouit = layouit;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Vh(LayoutInflater.from(context).inflate(layouit,parent,false),context);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        convert(holder,list.get(position));
    }
    public abstract void convert(Vh holder,T t);
    public static class Vh extends RecyclerView.ViewHolder {
        public SparseArray<View> mview;
        public View mconvert;
        public Context context;
        public Vh(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            mconvert=itemView;
            mview=new SparseArray<>();
        }
        public <T extends  View> T getview(int id){
            View view=mview.get(id);
            if (view==null){
                view=mconvert.findViewById(id);
                mview.put(id,view);
            }
            return (T) view;
        }
        public Vh setGlide(int id,String str){
            ImageView view=getview(id);
            Tool.setGlide(context,str,view);
            return this;
        }
        public Vh setGlide(int id,int str){
            ImageView view=getview(id);
            view.setImageResource(str);
            return this;
        }
        public Vh setText(int id,String str){
            TextView view=getview(id);
            view.setText(str);
            return this;
        }
        public Vh seton(int id, View.OnClickListener onClickListener){
            View    view=getview(id);
            view.setOnClickListener(onClickListener);
            return this;
        }

    }
}
