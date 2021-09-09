package com.example.project11;


import android.app.Activity;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class MyCallBack implements Callback {
    Activity activity;
    Class lass;

    public MyCallBack(Activity activity, Class lass) {
        this.activity = activity;
        this.lass = lass;
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {

    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        String string = response.body().string();
        Gson gson=new Gson();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onFinish(gson.fromJson(string,lass));
            }
        });


    }
    public abstract void onFinish(Object object);
}
