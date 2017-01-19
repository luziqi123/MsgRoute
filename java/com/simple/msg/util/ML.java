package com.simple.msg.util;

import android.util.Log;

/**
 * log
 * Created by Administrator on 2017/1/19.
 */
public class ML{

    public static final String TAG = "MyLog123456:";

    public static void i(String tag , String content){
        if(Constant.isDebug){
            Log.i(TAG + tag, content);
        }else {

        }
    }

    public static void d(String tag , String content) {
        if (Constant.isDebug){
            Log.d(TAG + tag, content);
        }else {

        }
    }

    public static void e(String tag , String content){
        if(Constant.isDebug) {
            Log.e(TAG + tag, content);
        }else {

        }
    }

    public static void i(Object obj , String content){
        if(Constant.isDebug) {
            Log.i(TAG + obj.getClass().getName(), content);
        }else {

        }
    }

    public static void i(String content){
        if (Constant.isDebug){

            Log.i(TAG , content);
        } else {

        }
    }

    private static void writeToFile(){
        //TODO 将log记录到文件中
    }

}
