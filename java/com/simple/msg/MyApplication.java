package com.simple.msg;

import android.app.Application;

import com.simple.msg.util.SharedUtil;

/**
 * Created by Administrator on 2017/1/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedUtil.init(this);
    }
}
