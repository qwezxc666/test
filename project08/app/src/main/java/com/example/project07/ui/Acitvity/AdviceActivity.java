package com.example.project07.ui.Acitvity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.ResultBean;
import com.example.project07.Bean.centent;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

public class AdviceActivity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        initView();
        setTitle("意见反馈");

    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);
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
            Toast.makeText(this, "意见", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        Okhttp.postheand("/prod-api/api/common/feedback", Tool.gettoken(getthis()),new centent(et1String), new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFish(Object o) {
                ResultBean resultBean= (ResultBean) o;
                maketoast(resultBean.msg);
                if (resultBean.code==200){
                    finish();
                }
            }
        });

    }
}