package com.example.project11.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project11.R;
import com.example.project11.Tool;
import com.example.project11.ui.Activity.BaseActivity;

public class S32Activity extends BaseActivity implements View.OnClickListener {

    private EditText et1;
    private ImageView iv1;
    private Button b1;
     Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s32);
        initView();
        setTitle("发表");
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(this);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),666);

            }
        });
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
        }else {
            Tool.comList.add(new S3Activity.com(0,"你",et1String,bitmap));
            finish();
        }

        // TODO validate success, do something


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        try {
            bitmap= (Bitmap) data.getExtras().get("data");
            iv1.setImageBitmap(bitmap);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}