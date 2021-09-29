package com.example.test10;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class CommAdapter<T> extends RecyclerView.Adapter<CommAdapter.Vh> {
    public Context context;
    public List<T> list;
    public int layoutid;
    public LayoutInflater layoutInflater;

    public CommAdapter(Context context, List<T> list, int layoutid) {
        this.context = context;
        this.list = list;
        this.layoutid = layoutid;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Vh(layoutInflater.inflate(layoutid,parent,false),context);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        convert(holder,list.get(position));
    }
    public abstract void convert(Vh convert,T t);
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public static  class Vh extends RecyclerView.ViewHolder {
        public SparseArray<View> mview;
        public View mconvert;
        public Context context;

        public Vh(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            mview=new SparseArray<>();
            mconvert=itemView;
        }
        public <T extends View> T getview(int id){
            View    view=mview.get(id);
            if (view==null){
                view=mconvert.findViewById(id);
                mview.put(id,view);
            }
            return (T) view;
        }
        public EditText getet(int id){
            EditText editText=getet(id);
            return editText;
        }
        public RatingBar getrat(int id){
            RatingBar ratingBar=getview(id);
            return ratingBar;
        }
        public Vh setText(int id,String str){
            TextView view=getview(id);
            view.setText(str);
            return this;
        }
        public Vh setGlide(int id,int drwa){
            ImageView view=getview(id);
            view.setImageResource(drwa);
            return this;
        }
        public Vh setGlide(int id,String  drwa){
            ImageView view=getview(id);
            Tool.setGilde(context,drwa,view);
            return this;
        }
        public Vh seton(int id, View.OnClickListener onClickListener){
            View    view=getview(id);
            view.setOnClickListener(onClickListener);
            return this;
        }
    }
}
