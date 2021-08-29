package com.example.project07;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public abstract class CommAdapter<T> extends RecyclerView.Adapter<CommAdapter.Vh> {
    private Context context;
    private List<T> list;
    private int layoutid;
    private LayoutInflater layoutInflater;

    public CommAdapter(Context context, List<T> list, int layoutid) {
        this.context = context;
        this.list = list;
        this.layoutid = layoutid;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Vh(layoutInflater.inflate(layoutid,parent,false),context,parent);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        convert(holder,list.get(position));
    }
   public  abstract void convert(Vh holder,T t);
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    public static class Vh extends RecyclerView.ViewHolder {
        private SparseArray<View> mview;
        private View converview;
        private Context context;
        public Vh(@NonNull View itemView, Context context,ViewGroup parent) {
            super(itemView);
            this.mview=new SparseArray<>();
            this.converview = itemView;
            this.context=context;
        }
        public <T extends View> T getview(int id){
            View view=mview.get(id);
            if (view==null){
                view=converview.findViewById(id);
                mview.put(id,view);
            }
            return (T) view;
        }
        public Vh setText(int id,String text){
            TextView view=getview(id);
            view.setText(text);
            return this;
        }
        public Vh setGlide(int id,Context context,String str){
            ImageView imageView=getview(id);
            Glide.with(context).load(Okhttp.web+str).into(imageView);
            return this;
        }
        public Vh setonListen(int id, View.OnClickListener onClickListener){
            View view=getview(id);
            view.setOnClickListener(onClickListener);
            return this;
        }
        public Button getBu(int id){
            Button imageView=getview(id);
            return imageView;
        }
    }
}
