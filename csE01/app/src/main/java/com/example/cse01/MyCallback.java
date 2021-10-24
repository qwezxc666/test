package com.example.cse01;

import android.app.Activity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class MyCallback implements Callback {
    public Activity activity;
    public Class lass;

    public MyCallback(Activity activity, Class lass) {
        this.activity = activity;
        this.lass = lass;
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {

    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        String string = response.body().string();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onFish(Okhttp.gson.fromJson(string,lass));
            }
        });
    }
    public abstract void onFish(Object o);
}
