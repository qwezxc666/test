package com.example.project11;

import com.google.gson.Gson;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Okhttp {
    public static  String web = "http://124.93.196.45:10001";
    public static final Gson gson = new Gson();

    public static void get(String str, MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(web+str).build();
        client.newCall(request).enqueue(callBack);

    }

    public static void getheand(String str, String token, MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(web+str).addHeader("Authorization", token).build();
        client.newCall(request).enqueue(callBack);

    }
//    public static void getheand(String str, String token,Object o, MyCallBack callBack) {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url(web+str).addHeader("Authorization", token)
//                .get(RequestBody.create(MediaType.parse("application/json;charset=utf-8"),gson.toJson(o))).build();
//        client.newCall(request).enqueue(callBack);
//
//    }

    public static void post(String str, Object o, MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(web+str).
                post(RequestBody.create(MediaType.parse("application/json"), gson.toJson(o))).build();
        client.newCall(request).enqueue(callBack);

    }
    public static void postheand(String str,String token ,Object o, MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                post(RequestBody.create(MediaType.parse("application/json"), gson.toJson(o))).build();
        client.newCall(request).enqueue(callBack);

    }
    public static void put(String str,String token ,Object o, MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                put(RequestBody.create(MediaType.parse("application/json"), gson.toJson(o))).build();
        client.newCall(request).enqueue(callBack);

    }
    public static void delete(String str,String token , MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                delete().build();
        client.newCall(request).enqueue(callBack);

    }
    public static void upload(String str, String token , File file, MyCallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        MultipartBody.Builder multipartBody = new MultipartBody.Builder();
        multipartBody.addFormDataPart("file","user.jpg",RequestBody.create(MediaType.parse("application/octet-stream"),file));
        Request request = new Request.Builder().url(web+str).
                addHeader("Authorization",token).
                post(multipartBody.build()).build();
        client.newCall(request).enqueue(callBack);

    }
}
