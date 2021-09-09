package com.example.porject09.ui.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porject09.BaseActivity;
import com.example.porject09.Bean.AllCarBean;
import com.example.porject09.Bean.idCarBean;
import com.example.porject09.CommAdapter;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;

public class M2Activity extends BaseActivity {

    private SearchView search;
    private RecyclerView re;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2);
        setTitle("缴纳罚款");
//        judge();


        initView();
        judge();
        setdata();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Tool.illeaglid=query;
                startActivity(new Intent(getthis(),illegalInforActivity.class));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void judge() {
        Okhttp.get("/prod-api/api/traffic/license/user", Tool.getToken(getthis()), new MyCallback(getthis(), idCarBean.class) {
            @Override
            public void onFinsh(Object o) {
                idCarBean idCarBean = (com.example.porject09.Bean.idCarBean) o;
                if (idCarBean.data == null) {
                    //传出对话框
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getthis());
                    dialog.setTitle("您未绑定驾驶证");
                    dialog.setMessage("是否现在去绑定驾驶证");
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getthis(), M22Activity.class));
                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    dialog.show();
                } else {

                }

            }
        });
    }

    private void setdata() {
        Okhttp.get("/prod-api/api/traffic/car/list", Tool.getToken(getthis()), new MyCallback(getthis(), AllCarBean.class) {
            @Override
            public void onFinsh(Object o) {
                final AllCarBean allCarBean = (AllCarBean) o;

                re.setAdapter(new CommAdapter<AllCarBean.RowsBean>(getthis(), allCarBean.rows, R.layout.idcar_item) {
                    @Override
                    public void convert(Vh holder, AllCarBean.RowsBean rowsBean) {
                        if (allCarBean.rows != null) {
                            holder.setText(R.id.tv1, "\t\t\t" + rowsBean.type + "\t\t\t" + rowsBean.plateNo);
                            holder.setOnListen(R.id.l1, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(getthis(),JudgeListActivity.class));
                                }
                            });
                        }
                    }

                });

            }
        });
        Okhttp.get("/prod-api/api/traffic/license/user", Tool.getToken(getthis()), new MyCallback(getthis(), idCarBean.class) {
            @Override
            public void onFinsh(Object o) {
                idCarBean idCarBean = (com.example.porject09.Bean.idCarBean) o;
                if (idCarBean.data == null) {

                } else {
                    tv1.setText("\t\t\t驾驶证号："+idCarBean.data.get(0).licenseNo+"\t\t\t驾驶证有效期："+idCarBean.data.get(0).verifyDate);

                }

            }
        });
    }

    private void initView() {
        search = (SearchView) findViewById(R.id.search);
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        tv1 = (TextView) findViewById(R.id.tv1);
    }
}