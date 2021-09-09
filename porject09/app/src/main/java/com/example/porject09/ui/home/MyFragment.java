package com.example.porject09.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.porject09.Bean.Userbean;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;
import com.example.porject09.ui.Activity.AdviseActivity;
import com.example.porject09.ui.Activity.LoginActivity;
import com.example.porject09.ui.Activity.MyInforActivity;
import com.example.porject09.ui.Activity.OrderActivity;
import com.example.porject09.ui.Activity.RevisePsActivity;


public class MyFragment extends Fragment {

    private TextView textView3;
    private ImageView imageView;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private Button button2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        return view;
    }
    private void getinfor(){
        Okhttp.get("/prod-api/api/common/user/getInfo", Tool.getToken(getContext()), new MyCallback(getActivity(), Userbean.class) {
            @Override
            public void onFinsh(Object o) {
                Userbean userBean= (Userbean) o;
                if (userBean.code==200){
                    Log.e("qwe",userBean.user.avatar);
                    Tool.setGlide(getContext(),"/prod-api"+userBean.user.avatar,imageView);
                    textView3.setText(userBean.user.nickName);
                }
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        if (Tool.getToken(getContext()).isEmpty() || Tool.getToken(getContext()).equals("")) {
            getActivity().finish();
            startActivity(new Intent(getActivity(), LoginActivity.class));
        } else {

        }
        getinfor();
    }

    private void initView(View view) {
        textView3 = (TextView) view.findViewById(R.id.textView3);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        textView4 = (TextView) view.findViewById(R.id.textView4);
        textView5 = (TextView) view.findViewById(R.id.textView5);
        textView6 = (TextView) view.findViewById(R.id.textView6);
        textView7 = (TextView) view.findViewById(R.id.textView7);
        button2 = (Button) view.findViewById(R.id.button2);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyInforActivity.class));
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OrderActivity.class));
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RevisePsActivity.class));
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AdviseActivity.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor sp=getActivity().getSharedPreferences("app", Context.MODE_PRIVATE).edit();
                sp.putString("token","");
                sp.apply();
                getActivity().finish();
            }
        });
    }
}