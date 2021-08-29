package com.example.project07;

import com.google.gson.Gson;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Okhttp {
    public static final String web="http://124.93.196.45:10001";
    public static final Gson gson=new Gson();
    public static void get(String str,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(web+str).build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void getheand(String str,String token,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(web+str).addHeader("Authorization",token).build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void post(String str,Object o,MyCallback myCallback){

        OkHttpClient client=new OkHttpClient();
        // 换个位置一样的，原来的方法有横线表示弃用或过时
        RequestBody requestBody = RequestBody.create(gson.toJson(o),MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(web+str)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(myCallback);

        // 假装做下修改

        // 错误的报头：MediaType.parse("application/json;utf-8")


//        OkHttpClient client=new OkHttpClient();
//        Request request = new Request.Builder().url(web+str).
//                post(RequestBody.create(MediaType.parse("application/json;utf-8"),gson.toJson(o))).build();
//        client.newCall(request).enqueue(myCallback);
    }
    public static void post(String str,String s,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(web+str).
                post(RequestBody.create(MediaType.parse("application/json;utf-8"),s)).build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void postheand(String str,String token,Object o,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                post(RequestBody.create(MediaType.parse("application/json;utf-8"),gson.toJson(o))).build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void putheand(String str,String token,Object o,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                put(RequestBody.create(MediaType.parse("application/json;utf-8"),gson.toJson(o))).build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void delete(String str,String token,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                delete().build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void upload(String str, String token, File file, MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        MultipartBody.Builder builder= new MultipartBody.Builder();
        builder.addFormDataPart("file","user.jpg",RequestBody.create(MediaType.parse("application/octet-stream"),file));
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                delete().build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void upload(String str, String token, byte[]bytes, MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        MultipartBody.Builder builder= new MultipartBody.Builder();
        builder.addFormDataPart("file","user.jpg",RequestBody.create(MediaType.parse("application/octet-stream"),bytes));
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                delete().build();
        client.newCall(request).enqueue(myCallback);
    }
}
