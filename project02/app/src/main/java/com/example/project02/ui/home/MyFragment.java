package com.example.project02.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.project02.Bean.UserInforBean;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;
import com.example.project02.ui.Activity.AdviseActivity;
import com.example.project02.ui.Activity.LoginActivity;
import com.example.project02.ui.Activity.MyInforActivity;
import com.example.project02.ui.Activity.OrderActivity;
import com.example.project02.ui.Activity.PasswActivity;


public class MyFragment extends Fragment {

    private ImageView imageView;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        imageView = (ImageView) view.findViewById(R.id.imageView);
        textView = (TextView) view.findViewById(R.id.textView);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        textView4 = (TextView) view.findViewById(R.id.textView4);
        textView5 = (TextView) view.findViewById(R.id.textView5);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor sp=getActivity().getSharedPreferences("app", Context.MODE_PRIVATE).edit();
                sp.putString("token","");
                sp.apply();
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AdviseActivity.class));
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PasswActivity.class));
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OrderActivity.class));
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyInforActivity.class));
            }
        });
    }
    private void getinfor(){
        Okhttp.get("/prod-api/api/common/user/getInfo", Tool.gettoken(getContext()), new MyCallback(getActivity(), UserInforBean.class) {
            @Override
            public void onFish(Object o) {
                UserInforBean userInforBean= (UserInforBean) o;
//                userInforBean.user.
            }
        });

    }
    @Override
    public void onResume() {
        super.onResume();
        if ((Tool.gettoken(getContext())).equals("")){
            getActivity().finish();
            startActivity(new Intent(getContext(), LoginActivity.class));
        }else {
            Okhttp.get("/prod-api/api/common/user/getInfo", Tool.gettoken(getContext()), new MyCallback(getActivity(), UserInforBean.class) {
                @Override
                public void onFish(Object o) {
                    UserInforBean userInforBean= (UserInforBean) o;
                    textView.setText(userInforBean.user.nickName);
                    Tool.setGlide(getContext(),"/prod-api"+userInforBean.user.avatar,imageView);
                }
            });
        }
    }
}