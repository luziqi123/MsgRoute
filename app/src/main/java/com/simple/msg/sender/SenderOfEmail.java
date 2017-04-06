package com.simple.msg.sender;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 邮箱发送者
 * Created by Administrator on 2017/1/17.
 */
public class SenderOfEmail {

    public void sent(String phoneNum, String msg) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://114.215.81.196/service/")
                .build();
        try {
            Response execute = client.newCall(request).execute();
            Log.i("aaaaaaa" , execute.body().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
