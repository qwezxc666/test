package com.example.project07.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project07.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private TextView textView;
    private TextView textView2;
    private TextView textView4;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private RecyclerView re;
    private Button b1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView(root);
        return root;
    }

    private void initView(View root) {
        textView = (TextView) root.findViewById(R.id.textView);
        textView2 = (TextView) root.findViewById(R.id.textView2);
        textView4 = (TextView) root.findViewById(R.id.textView4);
        et1 = (EditText) root.findViewById(R.id.et1);
        et2 = (EditText) root.findViewById(R.id.et2);
        et3 = (EditText) root.findViewById(R.id.et3);
        et4 = (EditText) root.findViewById(R.id.et4);
        re = (RecyclerView) root.findViewById(R.id.re);
        b1 = (Button) root.findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}