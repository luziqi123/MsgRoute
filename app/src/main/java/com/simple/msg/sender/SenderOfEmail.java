package com.simple.msg.sender;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 邮箱发送者
 * Created by Administrator on 2017/1/17.
 */
public class SenderOfEmail {

    OkHttpClient client = new OkHttpClient();

    public void sent(String email  , String phoneNum, String msg) {
        Request request = new Request.Builder()
                .url("http://114.215.81.196/service/mail/index.php?to="+ email +"&subject=信息提醒&content=from = " + phoneNum + " content = " + msg)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    interface OnFailCallback{
        void onFail();
    }

}
