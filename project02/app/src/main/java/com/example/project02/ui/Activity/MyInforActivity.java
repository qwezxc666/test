package com.example.project02.ui.Activity;

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

import com.example.project02.BaseActivity;
import com.example.project02.Bean.ResultBean;
import com.example.project02.Bean.UplodBean;
import com.example.project02.Bean.UserInforBean;
import com.example.project02.Bean.UserInforBody;
import com.example.project02.MyCallback;
import com.example.project02.Okhttp;
import com.example.project02.R;
import com.example.project02.Tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyInforActivity extends BaseActivity implements View.OnClickListener {

    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private ImageView imageView2;
    private EditText et1;
    private EditText et;
    private TextView textView6;
    private Button button2;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private Button button3;
    private String sex;
    private String avert;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_infor);
        initView();
        setTitle("个人信息");
    }

    private void initView() {
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        et1 = (EditText) findViewById(R.id.et1);
        et = (EditText) findViewById(R.id.et);
        textView6 = (TextView) findViewById(R.id.textView6);
        button2 = (Button) findViewById(R.id.button2);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        button3 = (Button) findViewById(R.id.button3);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton.isChecked()){
                    sex="0";
                    radioButton.setChecked(true);
                    radioButton2.setChecked(false);
                }
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton2.isChecked()){
                    sex="1";
                    radioButton2.setChecked(true);
                    radioButton.setChecked(false);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                photo();
                break;
            case R.id.button3:
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

        String etString = et.getText().toString().trim();
        if (TextUtils.isEmpty(etString)) {
            Toast.makeText(this, "etString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        UserInforBody user=new UserInforBody(textView10.toString(),etString,et1String,sex,avert);
        Okhttp.put("/prod-api/api/common/user", Tool.gettoken(getthis()), user, new MyCallback(getthis(),ResultBean.class) {
            @Override
            public void onFish(Object o) {
                ResultBean resultBean= (ResultBean) o;
                if (resultBean.code=="200"){
                    maketoast("修改成功");
                }else {
                    maketoast(resultBean.code+resultBean.msg);
                }
            }
        });

    }
    private void photo(){
        startActivityForResult(new Intent(Intent.ACTION_GET_CONTENT).setType("image/*"),666);
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("qwe",data.getData()+"");
        if (data.getData()!=null){
            imageView2.setImageURI(data.getData());
            file=new File(getExternalFilesDir(  Environment.DIRECTORY_PICTURES).getAbsolutePath(),"user.jpg");
            try {
                file.createNewFile();
                InputStream read = getthis().getContentResolver().openInputStream(data.getData());
                FileOutputStream fileOutputStream = new FileOutputStream(file.getPath());
                int i;
                byte b[]=new byte[8912];
                while ((i=read.read(b))!=-1){
                    fileOutputStream.write(b);
                }
                read.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Okhttp.upload("/prod-api/common/upload", Tool.gettoken(getthis()), file, new MyCallback(getthis(), UplodBean.class) {
                @Override
                public void onFish(Object o) {
                    UplodBean resultBean= (UplodBean) o;
                    if (resultBean.code==200){
                        avert=resultBean.fileName;
                        Log.e("qwe",avert);
                    }
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Okhttp.get("/prod-api/api/common/user/getInfo", Tool.gettoken(getthis()), new MyCallback(getthis(), UserInforBean.class) {
            @Override
            public void onFish(Object o) {
                UserInforBean userInforBean= (UserInforBean) o;
                et1.setText(userInforBean.user.nickName);
                Tool.setGlide(getthis(),"/prod-api"+userInforBean.user.avatar,imageView2);
                et.setText(userInforBean.user.phonenumber);
                String sex = userInforBean.user.sex;
                if (sex.equals("0")){
                    sex="0";
                    radioButton.setChecked(true);
                }
                if (sex.equals("1")){
                    sex="1";
                    radioButton2.setChecked(true);
                }
                textView10.setText(userInforBean.user.idCard.replaceAll("(\\d{3})\\d{11}(\\d{3})","$1****$2"));
            }
        });
    }
}