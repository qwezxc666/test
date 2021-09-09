package com.example.porject09;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import com.google.gson.Gson;

import java.io.File;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class Okhttp {
    public static final String web="http://124.93.196.45:10001";
    public static Gson gson=new Gson();
    public static void get(String str,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str).build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void get(String str,String token,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str).addHeader("Authorization",token).build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void post(String str,Object o,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),gson.toJson(o));
        Request request=new Request.Builder().url(web+str).post(requestBody).build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void post(String str,String token,Object o,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),gson.toJson(o));
        Request request=new Request.Builder().url(web+str).post(requestBody)
                .addHeader("Authorization",token)
                .build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void put(String str,String token,Object o,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),gson.toJson(o));
        Request request=new Request.Builder().url(web+str).put(requestBody)
                .addHeader("Authorization",token)
                .build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void delete(String str,String token,Object o,MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(web+str).delete()
                .addHeader("Authorization",token)
                .build();
        client.newCall(request).enqueue(myCallback);
    }
    public static void upload(String str, String token, File file, MyCallback myCallback){
        OkHttpClient client=new OkHttpClient();
        MultipartBody.Builder body=new MultipartBody.Builder();
        body.addFormDataPart("file","user.jpg",RequestBody.create(MediaType.parse("application/octet-stream"),file));
        Request request=new Request.Builder().url(web+str).delete()
                .addHeader("Authorization",token)
                .post(body.build())
                .build();
        client.newCall(request).enqueue(myCallback);
    }
}
