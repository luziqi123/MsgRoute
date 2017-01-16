package com.simple.msg;

import android.app.Application;
import android.content.Context;

import com.simple.msg.util.SharedUtil;

/**
 * Created by Administrator on 2017/1/16.
 */
public class MyApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedUtil.init(this);
        this.context = this;
    }
}
