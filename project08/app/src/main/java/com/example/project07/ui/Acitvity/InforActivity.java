package com.example.project07.ui.Acitvity;

import android.content.ContentResolver;
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

import com.example.project07.BaseActivity;
import com.example.project07.Bean.ResultBean;
import com.example.project07.Bean.ReviseBody;
import com.example.project07.Bean.UploadBean;
import com.example.project07.Bean.UserInforBean;
import com.example.project07.MyCallback;
import com.example.project07.Okhttp;
import com.example.project07.R;
import com.example.project07.Tool;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InforActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView;
    private Button b1;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private EditText editText;
    private EditText et2;
    private EditText et3;
    private TextView editText5;
    private RadioButton rb1;
    private RadioButton rb2;
    private String i;
    private Button b2;
    private File file;
    private String avr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        initView();
        setTitle("个人信息");
        getinfor();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        b1 = (Button) findViewById(R.id.b1);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        editText = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        editText5 = (TextView) findViewById(R.id.editText5);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);

        b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                startActivityForResult(new Intent(Intent.ACTION_GET_CONTENT).setType("image/*"),666);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("qwe",data.getData()+"");
        if (data.getData()!=null){
            data.getData();
            imageView.setImageURI(data.getData());
            try {
                file=new File(getFileStreamPath(Environment.DIRECTORY_PICTURES).getAbsoluteFile(),"user.jpg");
                file.createNewFile();
                InputStream inputStream = getApplicationContext().getContentResolver().openInputStream(data.getData());
                FileOutputStream fileInputStream = new FileOutputStream(file.getPath());
                byte[] c=new byte[8916];
                int i;
                while ((i=inputStream.read(c))!=-1){
                    fileInputStream.write(c);
                }
                inputStream.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Okhttp.post("/prod-api/common/upload", file, new MyCallback(getthis(), UploadBean.class) {
                @Override
                public void onFish(Object o) {
                    UploadBean uploadBean= (UploadBean) o;
                    if (uploadBean.code==200){
                        avr=uploadBean.url;
                        Log.e("qwe",avr);
                    }
                }
            });
        }

    }

    private void getinfor() {
        Okhttp.getheand("/prod-api/api/common/user/getInfo", Tool.gettoken(getthis()), new MyCallback(getthis(), UserInforBean.class) {
            @Override
            public void onFish(Object o) {
                UserInforBean userInforBean = (UserInforBean) o;
                if (userInforBean.code == 200) {
                    Tool.setGlide(getthis(), userInforBean.user.avatar, imageView);
                    editText.setText(userInforBean.user.nickName);
                    et2.setText(userInforBean.user.phonenumber);
                    et3.setText(userInforBean.user.email);
                    editText5.setText(userInforBean.user.idCard.replaceAll("(\\d{3})\\d{10}(\\d{3})", "$1****$2"));
                    if (userInforBean.user.sex.equals("0")) {
                        rb1.setChecked(true);
                        rb2.setChecked(false);
                    } else {
                        rb1.setChecked(false);
                        rb2.setChecked(true);
                    }
                }
            }
        });
    }

    private void submit() {
        // validate
        String editTextString = editText.getText().toString().trim();
        if (TextUtils.isEmpty(editTextString)) {
            Toast.makeText(this, "editTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2String = et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2String)) {
            Toast.makeText(this, "et2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et3String = et3.getText().toString().trim();
        if (TextUtils.isEmpty(et3String)) {
            Toast.makeText(this, "et3String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (rb1.isChecked()) {
            i = "0";
        }
        if (rb2.isChecked()) {
            i = "1";
        }
        ReviseBody reviseBody = new ReviseBody(et3String, editText5.getText().toString(), editTextString, et2String, i,avr);
        Okhttp.postheand("/prod-api/api/common/user", Tool.gettoken(getthis()), reviseBody, new MyCallback(getthis(), ResultBean.class) {
            @Override
            public void onFish(Object o) {
                ResultBean resultBean = (ResultBean) o;
                if (resultBean.code == 200) {
                    maketoast("修改成功");
                    finish();
                } else {
                }
            }
        });

    }
}