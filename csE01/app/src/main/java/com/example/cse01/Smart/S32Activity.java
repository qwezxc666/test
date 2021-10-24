package com.example.cse01.Smart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.cse01.BaseActivity;
import com.example.cse01.R;
import com.example.cse01.Tool;

public class S32Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private ImageView iv1;
    private Button b1;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s32);
        initView();
        setTitle("友邻社交");
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        iv1 = (ImageView) findViewById(R.id.iv1);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bitmap= (Bitmap) data.getExtras().get("data");
        iv1.setImageBitmap(bitmap);
    }

    private void submit() {
        // validate
        String et1String = et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1String)) {
            Toast.makeText(this, "发布内容", Toast.LENGTH_SHORT).show();
            return;
        }
        Tool.fbList.add(new S3Activity.Fb("你",et1String,0,bitmap));
        maketast("发布成功");
        finish();
    }
}