package com.simple.msg.util;

import android.widget.Toast;

import com.simple.msg.MyApplication;


/**
 * Created by renlei on 2015/9/24.
 */
public class ToastMaker {


    /**
     * LENGTH_LONG Toast
     * @param msg
     */
    public static void showLongToast(final String msg){
        Toast.makeText(MyApplication.context,msg,Toast.LENGTH_LONG).show();
    }

    /**
     * LENGTH_SHORT Toast
     * @param msg
     */
    public static void showShortToast(final String msg){
        Toast.makeText(MyApplication.context,msg,Toast.LENGTH_SHORT).show();
    }
}
