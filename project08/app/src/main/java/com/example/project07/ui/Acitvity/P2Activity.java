package com.example.project07.ui.Acitvity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.PostWrongBody;
import com.example.project07.Bean.ResultBean;
import com.example.project07.Bean.UploadBean;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class P2Activity extends BaseActivity {

    private EditText et1;
    private ImageView iv1;
    private Button b1;
    private EditText et2;
    Bitmap bitmap;
    File file;
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);
        setTitle("信息纠错");

        initView();
    }

    private void initView() {
        et1 = (EditText) findViewById(R.id.et1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        b1 = (Button) findViewById(R.id.b1);
        et2 = (EditText) findViewById(R.id.et2);
        et2.setText(Tool.p.allPark);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_GET_CONTENT).setType("image/*"),666);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(et2.getText().toString());

                PostWrongBody postWrongBody = new PostWrongBody(et1.getText().toString(),Tool.p.parkName,s,"",i);
                Okhttp.post("/prod-api/api/park/correct", postWrongBody, new MyCallback(getthis(), ResultBean.class) {
                    @Override
                    public void onFish(Object o) {
                        ResultBean resultBean = (ResultBean) o;
                        if (resultBean.code == 200) {
                            maketoast("提交成功");
                            finish();
                        } else {
                            maketoast("提交失败");
                        }

                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data.getExtras().get("data")!=null){
            bitmap= (Bitmap) data.getExtras().get("data");
            iv1.setImageBitmap(bitmap);
            Uri uri =data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                int i;
                byte[]cr=new byte[8916];
                while ((i=inputStream.read(cr))!=-1){
                    fileOutputStream.write(cr);
                }
                inputStream.close();
                fileOutputStream.close();
                Okhttp.upload("/common/upload", Tool.gettoken(getthis()), file, new MyCallback(getthis(), UploadBean.class) {
                    @Override
                    public void onFish(Object o) {
                        UploadBean resultBean= (UploadBean) o;
                        if (resultBean.code==200){
                            s=resultBean.url;
                        }else {
                            s="";
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);

    }
}