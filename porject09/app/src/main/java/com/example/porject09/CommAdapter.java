package com.example.porject09;

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
    private Context mcontext;
    private int layoutid;
    private LayoutInflater layoutInflater;
    private List<T> list;

    public CommAdapter(Context mcontext, List<T> list, int layoutid) {
        this.mcontext = mcontext;
        this.layoutid = layoutid;
        this.layoutInflater = LayoutInflater.from(mcontext);
        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Vh(layoutInflater.inflate(layoutid,parent,false),mcontext,parent);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        convert(holder,list.get(position));
    }
    public abstract void convert(Vh holder,T t);
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public static class Vh extends RecyclerView.ViewHolder{
        private SparseArray<View> mview;
        private Context mcontext;
        private View mconvert;

        public Vh(@NonNull View itemView, Context mcontext, ViewGroup parent) {
            super(itemView);
            this.mcontext = mcontext;
            this.mconvert = itemView;
            mview=new SparseArray<>();
        }
        public <T extends View> T getview(int id){
            View view=mview.get(id);
            if (view==null){
                view=mconvert.findViewById(id);
                mview.put(id,view);
            }
            return (T) view;
        }
        public Vh setText(int id,String str){
            TextView view =getview(id);
            view.setText(str);
            return this;
        }
        public Vh setGlide(int id,String str,Context context){
            ImageView view =getview(id);
            Glide.with(context).load(Okhttp.web+str).into(view);
            return this;
        }
        public Vh setOnListen(int id, View.OnClickListener onClickListener){
            View view =getview(id);
            view.setOnClickListener(onClickListener);
            return this;
        }
    }
}
