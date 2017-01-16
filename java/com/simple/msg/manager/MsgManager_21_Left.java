package com.simple.msg.manager;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;

/**
 * 5.0以下的信息管理器
 * Created by Administrator on 2017/1/16.
 */
public class MsgManager_21_Left implements IMsgManager{

    private Activity mActivity;

    private SmsObserver smsObserver;

    private Uri SMS_INBOX = Uri.parse("content://sms/");

    public MsgManager_21_Left(Activity activity){
        mActivity = activity;
    }

    @Override
    public void init() {
        smsObserver = new SmsObserver(this, mActivity, new Handler());
        mActivity.getContentResolver().registerContentObserver(SMS_INBOX, true,
                smsObserver);
    }

    @Override
    public void haveNewMsg(String phoneNum, String msg) {
        Toast.makeText(mActivity , phoneNum + ":" + msg , Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean sentMsg(String msg) {
        return false;
    }

}
