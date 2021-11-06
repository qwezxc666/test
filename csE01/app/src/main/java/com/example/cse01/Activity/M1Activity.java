package com.example.cse01.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

import com.example.cse01.BaseActivity;
import com.example.cse01.Bean.ReBody;
import com.example.cse01.Bean.ResultBean;
import com.example.cse01.Bean.UploadBean;
import com.example.cse01.Bean.UserInforBean;
import com.example.cse01.MyCallback;
import com.example.cse01.Okhttp;
import com.example.cse01.R;
import com.example.cse01.Tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Result;

public class M1Activity extends BaseActivity {

    private ImageView iv1;
    private Button b1;
    private EditText et1;
    private EditText et2;
    private RadioButton rb1;
    private RadioButton rb2;
    private EditText et3;
    private Button b2;
    public File file;
    public String sex;
    public String avart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
        setTitle("个人信息");
        initView();
        getinfor();
    }
    private void getinfor(){
        try {
            Okhttp.get("/prod-api/api/common/user/getInfo", Tool.gettoken(getthis()),new MyCallback(getthis(), UserInforBean.class) {
                @Override
                public void onFish(Object o) {
                    UserInforBean userInforBean= (UserInforBean) o;
                    if (userInforBean.code==200){
                        Tool.setGlide(getthis(),"/prod-api"+userInforBean.user.avatar,iv1);
                        et1.setText(userInforBean.user.nickName);
                        et2.setText(userInforBean.user.phonenumber);
                        if (userInforBean.user.idCard!=null){
                            et3.setText(userInforBean.user.idCard.replaceAll("(\\d{2})\\d{12}(\\d{4})","$1*****$2"));
                        }
                        if (userInforBean.user.sex.equals("0")){
                            rb1.setChecked(true);
                        }
                        if (userInforBean.user.sex.equals("1")){
                                rb2.setChecked(false);

                        }
                    }else {
                        startActivity(new Intent(getthis(), LoginActivity.class));
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            file=new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(),"user.jpg");
            file.createNewFile();
            InputStream read=getContentResolver().openInputStream(data.getData());
            FileOutputStream write = new FileOutputStream(file.getPath());
            int i;
            byte b[]=new byte[8916];
            while ((i=read.read(b))!=-1){
                write.write(b);
            }
            Okhttp.upload("/prod-api/common/upload", Tool.gettoken(getthis())
                    , file, new MyCallback(getthis(), UploadBean.class) {
                        @Override
                        public void onFish(Object o) {
                            UploadBean uploadBean= (UploadBean) o;
                            if (uploadBean.code==200){
                                avart=uploadBean.fileName;
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        b1 = (Button) findViewById(R.id.b1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        et3 = (EditText) findViewById(R.id.et3);
        b2 = (Button) findViewById(R.id.b2);
        rb1.setOnClickListener(v -> {
            rb1.setChecked(true);
            rb2.setChecked(false);
            sex="0";
        });
        rb2.setOnClickListener(v -> {
            rb2.setChecked(true);
            rb1.setChecked(false);
            sex="1";
        });
        b1.setOnClickListener(v -> startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),666));
        b2.setOnClickListener(v -> {
            Okhttp.put("/prod-api/api/common/user", Tool.gettoken(getthis()),
                    new ReBody(et1.getText().toString(), et2.getText().toString(), sex, avart),
                    new MyCallback(getthis(), ResultBean.class) {
                        @Override
                        public void onFish(Object o) {
                            ResultBean resultBean= (ResultBean) o;
                            maketast(resultBean.msg);
                        }
                    });
        });
    }
}