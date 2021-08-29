package com.example.project07.ui.Acitvity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project07.BaseActivity;
import com.example.project07.Bean.ReResultBean;
import com.example.project07.Bean.RemoveBody;
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

public class Remove2Activity extends BaseActivity {

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView5;
    private TextView textView4;

    private Button b1;
    private ImageView iv1;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
     File file;
     String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove2);
        setTitle("挪车");
        initView();
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView4 = (TextView) findViewById(R.id.textView4);

        b1 = (Button) findViewById(R.id.b1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),666);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
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

        String et4String = et4.getText().toString().trim();
        if (TextUtils.isEmpty(et4String)) {
            Toast.makeText(this, "et4String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String et5String = et5.getText().toString().trim();
        if (TextUtils.isEmpty(et5String)) {
            Toast.makeText(this, "et5String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        RemoveBody removeBody = new RemoveBody(et5String,"区","市",et4String,s,et1String,"省",et3String);
        Okhttp.post("/prod-api/api/park/car/move", removeBody, new MyCallback(getthis(),Remove2Activity.class) {
            @Override
            public void onFish(Object o) {
                ReResultBean resultBean= (ReResultBean) o;
                Log.e("qwe",resultBean.msg+resultBean.data.tel);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("qwe","1");
//        Log.e("qwe",data.getData()+"");
//        if (data.getData()!=null){
//            Uri data1 = data.getData();
            Log.e("qwe","2");
//            iv1.setImageURI(data1);
            try {
                file=new File(getthis().getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(),"user.jpg");
                file.createNewFile();
                InputStream read = getContentResolver().openInputStream(Uri.fromFile(file));
                FileOutputStream write=new FileOutputStream(file.getPath());
                int i;
                byte c[]=new byte[8912];

                while ((i=read.read(c))!=-1){
                    write.write(c);
                }
                write.close();
                read.close();
                Okhttp.upload("/common/upload", Tool.gettoken(getthis()), file, new MyCallback(getthis(), UploadBean.class) {
                    @Override
                    public void onFish(Object o) {
                        UploadBean resultBean= (UploadBean) o;
                        Log.e("qwe",resultBean.msg+resultBean.code);
                        if (resultBean.code==200){
                            s=resultBean.url;
                            Log.e("Qwe",s);
                        }else {
                            s="";
                        }
                    }
                });
            } catch (IOException  e) {
                e.printStackTrace();
            }

//        }

    }
}