package com.example.porject09;

import android.app.Activity;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class MyCallback implements Callback {
    Activity activity;
    Class lass;

    public MyCallback(Activity activity, Class lass) {
        this.activity = activity;
        this.lass = lass;
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {

    }

    @Override
    public void onResponse(@NotNull final Call call, @NotNull Response response) throws IOException {
         final String string = response.body().string();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onFinsh(Okhttp.gson.fromJson(string,lass));
            }
        });

    }
    public abstract void onFinsh(Object o);
}
