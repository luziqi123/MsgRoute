package com.simple.msg;

import android.app.Application;
import android.content.Context;

import com.simple.msg.config.Note;

/**
 * Created by Administrator on 2017/1/16.
 */
public class MyApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Note.init(this);
        this.context = this;
    }
}
