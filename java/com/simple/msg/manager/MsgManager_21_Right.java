package com.simple.msg.manager;

import android.app.Activity;
import android.content.Context;

/**
 * 5.0以上信息管理器
 * Created by Administrator on 2017/1/16.
 */
public class MsgManager_21_Right implements IMsgManager{

    private Activity mActivity;

    public MsgManager_21_Right(Activity activity){
        mActivity = activity;
    }
    
    @Override
    public void init() {

    }

    @Override
    public void haveNewMsg(String phoneNum, String msg) {

    }

    @Override
    public boolean sentMsg(String msg) {
        return false;
    }
}
