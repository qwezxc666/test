package com.example.cse01;

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
    public static void get(String str,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str).build();
        client.newCall(request).enqueue(callback);
    }
    public static void get(String str,String token,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .addHeader("Authorization",token)
                .url(web+str).build();
        client.newCall(request).enqueue(callback);
    }
    public static void post(String str,Object o,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .post(RequestBody.create(MediaType.parse("application/json"),gson.toJson(o)))
                .url(web+str).build();
        client.newCall(request).enqueue(callback);
    }
    public static void post(String str,String token,Object o,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .addHeader("Authorization",token)
                .post(RequestBody.create(MediaType.parse("application/json"),gson.toJson(o)))
                .url(web+str).build();
        client.newCall(request).enqueue(callback);
    }
    public static void delete(String str,String token,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .addHeader("Authorization",token)
                .delete()
                .url(web+str).build();
        client.newCall(request).enqueue(callback);
    }
    public static void put(String str,String token,Object o,MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .addHeader("Authorization",token)
                .put(RequestBody.create(MediaType.parse("application/json"),gson.toJson(o)))
                .url(web+str).build();
        client.newCall(request).enqueue(callback);
    }
    public static void upload(String str, String token, File o, MyCallback callback){
        OkHttpClient client=new OkHttpClient();
        MultipartBody.Builder builder=new MultipartBody.Builder()
                .addFormDataPart("file","user.jpg",RequestBody.create(MediaType.parse("application/octet-stream"),o));
        Request request=new Request.Builder()
                .addHeader("Authorization",token)
                .post(builder.build())
                .url(web+str).build();
        client.newCall(request).enqueue(callback);
    }
}
