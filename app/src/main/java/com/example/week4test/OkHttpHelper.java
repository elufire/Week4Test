package com.example.week4test;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.week4test.flickr.Flickr;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {

    public OkHttpHelper() {
    }

    public static void ascyncOkHttpApi(String url){
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            String jsonResonse;
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                jsonResonse = response.body().string();
                Gson gson = new Gson();
                Flickr flickr = gson.fromJson(jsonResonse, Flickr.class);
                Log.e("TAG", "onResponse: " + flickr.getStat());
                EventBus.getDefault().post(new FlickrEvent(flickr));

                //Log.d("TAG", "onResponse: " + jsonResonse);
            }
        });
    }
}
