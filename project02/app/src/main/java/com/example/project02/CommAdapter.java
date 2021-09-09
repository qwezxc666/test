package com.example.project02;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

import java.util.List;

public abstract class CommAdapter<T> extends RecyclerView.Adapter<CommAdapter.Vh> {
    private List<T> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private int layoutid;
    public CommAdapter(List<T> list, Context contex ,int layoutid) {
        this.list = list;
        this.context = contex;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutid=layoutid;
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
    public abstract  void convert(Vh holder,T t);
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public static class Vh extends RecyclerView.ViewHolder {
        private SparseArray<View> mview;
        private View mconvert;
        private Context context;
        public Vh(@NonNull View itemView,Context context) {
            super(itemView);
            this.mview = new SparseArray<>();
            this.mconvert = itemView;
            this.context=context;
        }
        public <T extends View > T getview(int id){
            View view = mview.get(id);
            if (view==null){
                view=mconvert.findViewById(id);
                mview.put(id,view);
            }
            return (T) view;
        }
        public  Vh setText(int id,String str){
            TextView view =getview(id);
            view.setText(str);
            return this;
        }
        public  Vh setGlide(int id, String str, Context context){
            ImageView view =getview(id);
            Glide.with(context).load(Okhttp.web+str).into(view);
            return this;
        }
        public Vh setOnListen(int id, View.OnClickListener onClickListener){
            View view =getview(id);
            view.setOnClickListener(onClickListener);
            return this;
        }
        public  Vh setimg(int id, int draw){
            ImageView view =getview(id);
            view.setImageResource(draw);
            return this;
        }
        public  Vh setRat(int id, float draw){
            RatingBar view =getview(id);
            view.setRating(draw);
            return this;
        }
        public Button getbutton(int id){
            Button button=getview(id);
            return button;
        }
        public WebView getWeb(int id){
            WebView webView=getview(id);
            return webView;
        }
        public EditText getEdit(int id){
            EditText editText=getview(id);
            return  editText;
        }
        public ImageView getiv(int id){
            ImageView imageView=getview(id);
            return imageView;
        }
    }
}
