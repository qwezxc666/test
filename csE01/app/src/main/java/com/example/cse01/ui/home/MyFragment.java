package com.example.cse01.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cse01.Activity.LoginActivity;
import com.example.cse01.Activity.M1Activity;
import com.example.cse01.Activity.M2Activity;
import com.example.cse01.Activity.M3Activity;
import com.example.cse01.Activity.M4Activity;
import com.example.cse01.Bean.UserInforBean;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;


public class MyFragment extends Fragment {

    private ImageView iv1;
    private TextView tv1;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private Button b1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        iv1 = (ImageView) view.findViewById(R.id.iv1);
        tv1 = (TextView) view.findViewById(R.id.tv1);
        t1 = (TextView) view.findViewById(R.id.t1);
        t2 = (TextView) view.findViewById(R.id.t2);
        t3 = (TextView) view.findViewById(R.id.t3);
        t4 = (TextView) view.findViewById(R.id.t4);
        b1 = (Button) view.findViewById(R.id.b1);
        b1.setOnClickListener(v -> {
            SharedPreferences.Editor sp=getContext().getSharedPreferences("app",getContext().MODE_PRIVATE).edit();
            sp.putString("token","");
            sp.commit();
            getActivity().finish();
        });
        t1.setOnClickListener(v -> startActivity(new Intent(getContext(), M1Activity.class)));
        t2.setOnClickListener(v -> startActivity(new Intent(getContext(), M2Activity.class)));
        t3.setOnClickListener(v -> startActivity(new Intent(getContext(), M3Activity.class)));
        t4.setOnClickListener(v -> startActivity(new Intent(getContext(), M4Activity.class)));
    }
    private void getinfor(){
        Okhttp.get("/prod-api/api/common/user/getInfo", Tool.gettoken(getContext()),new MyCallback(getActivity(), UserInforBean.class) {
            @Override
            public void onFish(Object o) {
                UserInforBean userInforBean= (UserInforBean) o;
                if (userInforBean.code==200){
                    Tool.setGlide(getContext(),"/prod-api"+userInforBean.user.avatar,iv1);
                    tv1.setText(userInforBean.user.nickName);
                }else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }

            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        getinfor();
    }
}