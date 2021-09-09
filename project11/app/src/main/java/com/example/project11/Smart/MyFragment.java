package com.example.project11.Smart;

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

import com.example.project11.Bean.PersonBean;
import com.example.project11.MyCallBack;
import com.example.project11.Okhttp;
import com.example.project11.R;
import com.example.project11.Tool;

public class MyFragment extends Fragment {

    private ImageView iv1;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private Button b1;
    private TextView tv0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my2, container, false);
        iv1 = view.findViewById(R.id.iv1);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);
        tv3 = view.findViewById(R.id.tv3);
        tv4 = view.findViewById(R.id.tv4);
        tv0=view.findViewById(R.id.tv0);
        b1 = view.findViewById(R.id.b1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor sp = getActivity().getSharedPreferences("app", Context.MODE_PRIVATE).edit();
                sp.putString("token", "");
                sp.apply();
                getActivity().finish();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), OderActivity.class));
                ((FoodActivity) getActivity()).navController.navigate(R.id.navigation_dashboard);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AdressActivity.class));
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyCollActivity.class));
            }
        });
        if (Tool.getToken(getContext()).equals("") || Tool.getToken(getContext()).isEmpty()) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
//                        getActivity().finish();

        }
        if (Tool.getToken(getContext()) != "" || !Tool.getToken(getContext()).isEmpty()) {
            getinfor();
        } else {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }
        return view;
    }


    private void getinfor() {
        Okhttp.getheand("/prod-api/api/common/user/getInfo", Tool.getToken(getContext()), new MyCallBack(getActivity(), PersonBean.class) {
            @Override
            public void onFinish(Object object) {

                PersonBean personBean = (PersonBean) object;
                if (personBean.code != 200) {
//                    getActivity().finish();
                    Log.e("qwe", personBean.code + personBean.msg);
//                    Log.e("qwe",personBean.user.userName);

                } else {

                    Tool.getGlide(getContext(), personBean.user.avatar, iv1);
                    tv1.setText(personBean.user.userName);
                    tv0.setText("账户余额：￥  "+personBean.user.balance);
                }

            }
        });
    }
}