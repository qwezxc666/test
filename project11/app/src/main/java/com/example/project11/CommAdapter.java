package com.example.project11;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import java.util.List;

public abstract class CommAdapter<T> extends RecyclerView.Adapter<CommAdapter.Vh> {
    Context context;
    private List<T> list;
    int layoutid;
    private LayoutInflater layoutInflater;

    public CommAdapter(Context context, List<T> list, int layoutid) {
        this.context = context;
        this.list = list;
        this.layoutid = layoutid;
        layoutInflater=LayoutInflater.from(context);
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

    public abstract void convert(Vh holder,T t);
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    public static class Vh extends RecyclerView.ViewHolder {
        private SparseArray<View> mview;
        private View convertview;
        private int postition;
        private Context context;

        public Vh(@NonNull View itemView, Context context, ViewGroup parent) {
            super(itemView);
            mview=new SparseArray();
            this.convertview = itemView;
            this.context = context;
        }
        public <T extends View> T getview(int id){
            View view=mview.get(id);
            if (view==null){
                view=convertview.findViewById(id);
                mview.put(id,view);
            }
            return (T) view;
        }
        public Vh setText(int id,String str){
            TextView view=getview(id);
            view.setText(str);
            return this;
        }
        public TextView getText(int id){
            TextView view=getview(id);
            return view;
        }
        public Vh setimg(int id,int draw){
            ImageView view=getview(id);
            view.setImageResource(draw);
            return this;
        }
        public Vh setimg(int id, Bitmap b){
            ImageView view=getview(id);
            view.setImageBitmap(b);
            return this;
        }
        public ImageView getimg(int id){
            ImageView view=getview(id);
            return view;
        }
        public Vh setGlide(int id,String str,Context context){
            ImageView view=getview(id);
            Glide.with(context).load(Okhttp.web+str).into(view);
            return this;
        }
        public Vh setOnListen(int id, View.OnClickListener listener){
            View view=getview(id);
            view.setOnClickListener(listener);
            return this;
        }
        public Vh setRat(int id,int draw){
            RatingBar view=getview(id);
            view.setRating(draw);
            return this;
        }
        public EditText getEdit(int id){
            EditText view=getview(id);
            return view;
        }
        public ImageView setbutton(int id){
            ImageView view=getview(id);

            return view;
        }
        public Button getbu(int id){
            Button view=getview(id);

            return view;
        }
        public CheckBox getbox(int id){
            CheckBox view=getview(id);

            return view;
        }
    }
}
