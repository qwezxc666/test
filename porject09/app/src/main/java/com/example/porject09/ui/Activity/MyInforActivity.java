package com.example.porject09.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.porject09.BaseActivity;
import com.example.porject09.Bean.ResultBean;
import com.example.porject09.Bean.ReviseBody;
import com.example.porject09.Bean.UplodBean;
import com.example.porject09.Bean.Userbean;
import com.example.porject09.MyCallback;
import com.example.porject09.Okhttp;
import com.example.porject09.R;
import com.example.porject09.Tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyInforActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView2;
    private EditText et1;
    private EditText et3;
    private EditText et4;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private Button button1;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private TextView textView14;
    private Button button4;
    public File file;
    private String avert;
    private String sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_infor);
        initView();
        setTitle("个人信息");
        if (radioButton2.isChecked()){
            radioButton .setChecked(false);
            sex="1";
        }
        if (radioButton.isChecked()){
            radioButton2.setChecked(false);
            sex="0";
        }
    }

    private void initView() {
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        et1 = (EditText) findViewById(R.id.et1);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        button1 = (Button) findViewById(R.id.button1);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        textView14 = (TextView) findViewById(R.id.textView14);
        button4 = (Button) findViewById(R.id.button4);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioButton2.isChecked()){
                    radioButton .setChecked(false);
                    sex="1";
                }
            }
        });
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton.isChecked()){
                    radioButton2.setChecked(false);
                    sex="0";
                }
            }
        });
        button1.setOnClickListener(this);
        button4.setOnClickListener(this);
        getinfor();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_GET_CONTENT).setType("image/*"),666);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("qwe",data.getData()+"");
        if (data.getData()!=null){
            imageView2.setImageURI(data.getData());
            file=new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(),"user.jpg");
            try {
                file.createNewFile();

                InputStream read = getApplicationContext().getContentResolver().openInputStream(data.getData());
                FileOutputStream write = new FileOutputStream(file.getPath());
                int i;
                byte[]bytes=new byte[8916];
                while ((i=read.read(bytes))!=-1){
                    write.write(bytes);
                }

                write.close();
                read.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Okhttp.upload("/prod-api/common/upload", Tool.getToken(getthis()),file, new MyCallback(getthis(), UplodBean.class) {
                @Override
                public void onFinsh(Object o) {
                    UplodBean uplodBean= (UplodBean) o;
                    if (uplodBean.code==200){
                        Log.e("qwe",uplodBean.url);
                        avert=uplodBean.fileName;
                    }

                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:

                break;
            case R.id.button4:
                submit();
                break;
        }
    }
    private void getinfor(){
        Okhttp.get("/prod-api/api/common/user/getInfo", Tool.getToken(getthis()), new MyCallback(getthis(), Userbean.class) {
            @Override
            public void onFinsh(Object o) {
                Userbean userBean= (Userbean) o;
                if (userBean.code==200){
                    Tool.setGlide(getApplicationContext(),"/prod-api"+userBean.user.avatar,imageView2);
                    et1.setText(userBean.user.nickName);
                    et3.setText(userBean.user.phonenumber);
                    et4.setText(userBean.user.email);
                    if (userBean.user.sex.equals("0")){
                        radioButton.setChecked(true);
                        radioButton2.setChecked(false);
                    }else {
                        radioButton.setChecked(false);
                        radioButton2.setChecked(true);
                    }
                    textView14.setText(userBean.user.idCard.replaceAll("(\\d{3})\\d{10}(\\d{3})","$1*****$2"));


                }
            }
        });
    }
    private void submit() {
        // validate
        String et1String = et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1String)) {
            Toast.makeText(this, "et1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et3String = et3.getText().toString().trim();
        if (TextUtils.isEmpty(et3String)) {
            Toast.makeText(this, "et3String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et4String = et4.getText().toString().trim();
        if (TextUtils.isEmpty(et4String)) {
            Toast.makeText(this, "et4String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        ReviseBody reviseBody = new ReviseBody(et4String,textView14.getText().toString(),et1String,et3String,sex,avert);
        Okhttp.put("/prod-api/api/common/user",Tool.getToken(getthis()), reviseBody, new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFinsh(Object o) {
                ResultBean resultBean= (ResultBean) o;
                if (resultBean.code==200){
                    maketoast("修改成功");
                }else maketoast(resultBean.msg);
            }
        });

    }
}