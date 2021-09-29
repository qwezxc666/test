package com.example.test10;

import android.view.textclassifier.TextLinks;

import com.google.gson.Gson;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Okhttp {
    public static String web="http://124.93.196.45:10001";
    public static Gson gson=new Gson();
    public static void get(String str,MyCallbakc callbakc){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str).build();
        client.newCall(request).enqueue(callbakc);
    }
    public static void get(String str,String token,MyCallbakc callbakc){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .addHeader("Authorization",token)
                .url(web+str).build();
        client.newCall(request).enqueue(callbakc);
    }
    public static void post(String str,String token,Object o,MyCallbakc callbakc){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .post(RequestBody.create(MediaType.parse("application/json"),gson.toJson(o)))
                .addHeader("Authorization",token)
                .url(web+str).build();
        client.newCall(request).enqueue(callbakc);
    }
    public static void post(String str ,Object o,MyCallbakc callbakc){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .post(RequestBody.create(MediaType.parse("application/json"),gson.toJson(o)))
                .url(web+str).build();
        client.newCall(request).enqueue(callbakc);
    }
    public static void upload(String str, String token, File o, MyCallbakc callbakc){
        OkHttpClient client=new OkHttpClient();
        MultipartBody.Builder builder=new MultipartBody.Builder()
                .addFormDataPart("file","user.jpg",RequestBody.create(MediaType.parse("application/octet-strem"),o));
        Request request=new Request.Builder()
                .post(builder.build())
                .addHeader("Authorization",token)
                .url(web+str).build();
        client.newCall(request).enqueue(callbakc);
    }
    public static void delete(String str,String token,MyCallbakc callbakc){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .delete()
                .addHeader("Authorization",token)
                .url(web+str).build();
        client.newCall(request).enqueue(callbakc);
    }
}
