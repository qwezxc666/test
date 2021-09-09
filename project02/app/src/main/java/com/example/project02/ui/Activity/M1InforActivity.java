package com.example.project02.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02.BaseActivity;
import com.example.project02.Bean.News2Bean;
import com.example.project02.Bean.RecommBody;
import com.example.project02.Bean.RecommedBean;
import com.example.project02.Bean.ResultBean;
import com.example.project02.CommAdapter;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;

public class M1InforActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv1;
    private WebView web;
    private RecyclerView hot;
    private RecyclerView re;
    private EditText et1;
    private Button b1;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_infor);
        initView();
        setTitle("活动详情");

    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        web = (WebView) findViewById(R.id.web);
        hot = (RecyclerView) findViewById(R.id.hot);
        re = (RecyclerView) findViewById(R.id.re);
        et1 = (EditText) findViewById(R.id.et1);
        b1 = (Button) findViewById(R.id.b1);
        re.setLayoutManager(new LinearLayoutManager(getthis()));
        hot.setLayoutManager(new LinearLayoutManager(getthis()));
        iv1 = (ImageView) findViewById(R.id.iv1);
        b1.setOnClickListener(this);
        if (Tool.act != null) {
            tv1.setText(Tool.act.name);
            Tool.setGlide(getApplicationContext(),Tool.act.imgUrl,iv1);
            web.loadData(Tool.act.content,"text/html","utf-8");
            get(Tool.act.id);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String et1String = et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1String)) {
            Toast.makeText(this, "et1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Okhttp.post("/prod-api/api/activity/comment", Tool.gettoken(getthis()), new RecommBody(Tool.act.id, et1String), new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFish(Object o) {
                ResultBean resultBean= (ResultBean) o;
                if (resultBean.code.equals(200)){
                    maketoast("评论成功");
                }else {
                    maketoast(resultBean.msg);
                }
            }
        });
    }
    private void get(int i){
        Okhttp.get("/prod-api/api/activity/activity/list?recommend=Y" , new MyCallback(getthis(), News2Bean.class) {
            @Override
            public void onFish(Object o) {
                News2Bean newsBean = (News2Bean) o;
                hot.setAdapter(new CommAdapter<News2Bean.RowsBean>(newsBean.rows,getthis(),R.layout.activity_item) {

                    @Override
                    public void convert(Vh holder, final News2Bean.RowsBean rowsBean) {
                        holder.setText(R.id.tv1,rowsBean.name);
                        holder.setText(R.id.tv2,"报名人数："+rowsBean.signupNum);
                        holder.setText(R.id.tv3,"点赞总数："+rowsBean.likeNum);
                        holder.setGlide(R.id.iv1,rowsBean.imgUrl,getthis());
                        holder.getbutton(R.id.b1).setVisibility(View.GONE);
                        holder.setOnListen(R.id.l1, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Tool.act=rowsBean;
//                                startActivity(new Intent(getthis(),M1InforActivity.class));
                            }
                        });
                    }

                });
            }
        });
        Okhttp.get("/prod-api/api/activity/comment/list?activityId=" + i, Tool.gettoken(getthis()), new MyCallback(getthis(), RecommedBean.class) {
            @Override
            public void onFish(Object o) {
                RecommedBean recommedBean= (RecommedBean) o;
                re.setAdapter(new CommAdapter<RecommedBean.RowsBean>(recommedBean.rows,getthis(),R.layout.rec_item) {
                    @Override
                    public void convert(Vh holder, RecommedBean.RowsBean rowsBean) {
                        holder.setText(R.id.tv2,rowsBean.content);
                        holder.setText(R.id.tv1,rowsBean.nickName);
                        holder.setGlide(R.id.iv1,rowsBean.avatar,getthis());

                    }

                });
            }
        });
    }
}