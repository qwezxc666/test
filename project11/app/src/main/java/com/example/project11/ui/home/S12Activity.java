package com.example.project11.ui.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.project11.R;
import com.example.project11.ui.Activity.BaseActivity;

public class S12Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private RatingBar star;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s12);
        initView();
        setTitle("意见反馈");
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        star = (RatingBar) findViewById(R.id.star);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                submit();
                finish();
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

        // TODO validate success, do something
        maketoast("反馈成功");

    }
}