package com.simple.msg.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

/**
 * 信息管理者工厂
 * Created by Administrator on 2017/1/16.
 */
public class MsgFactory {

    private static IMsgManager mMsg;

    /**
     * 获取信息管理者
     * @return
     */
    public static IMsgManager getMsgManager(Activity activity){
        if (mMsg != null)return mMsg;
        int sdkInt = Build.VERSION.SDK_INT;
        if (sdkInt < 21){
            // 5.0以下的Android设备
            mMsg = new MsgManager_21_Left(activity);
        }else{
            // 5.0以上的Android设备
            mMsg = new MsgManager_21_Right(activity);
        }
        return mMsg;
    }
}
