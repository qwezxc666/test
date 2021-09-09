package com.example.project02;

import com.google.gson.Gson;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Okhttp {
    public static final String web="http://124.93.196.45:10001";
    public static Gson gson=new Gson();
    public static void get(String str,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str).build();
        client.newCall(request).enqueue(callback);
    }
    public static void get(String str,String token,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str).addHeader("Authorization",token).build();
        client.newCall(request).enqueue(callback);
    }
    public static void post(String str,Object o,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str)
                .post(RequestBody.create(MediaType.parse("application/json"),gson.toJson(o))).build();
        client.newCall(request).enqueue(callback);
    }
    public static void post(String str,String token,Object o,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str)
                .post(RequestBody.create(MediaType.parse("application/json"),gson.toJson(o)))
                .addHeader("Authorization",token).build();
        client.newCall(request).enqueue(callback);
    }
    public static void put(String str,String token,Object o,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str)
                .put(RequestBody.create(MediaType.parse("application/json;charset=utf-8"),gson.toJson(o)))
                .addHeader("Authorization",token).build();
        client.newCall(request).enqueue(callback);
    }
    public static void delete(String str,String token,Object o,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().delete().url(web+str).addHeader("Authorization",token).build();
        client.newCall(request).enqueue(callback);
    }
    public static void upload(String str, String token, File file, MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        MultipartBody.Builder multipartBody=new MultipartBody.Builder();
        multipartBody.addFormDataPart("file","user.jpg",RequestBody.create(MediaType.parse("application/octet-stream"),file));
        Request request=new Request.Builder().url(web+str)
                .post(multipartBody.build())
                .addHeader("Authorization",token).build();
        client.newCall(request).enqueue(callback);
    }
}
