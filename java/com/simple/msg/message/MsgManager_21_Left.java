package com.simple.msg.message;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;

import com.simple.msg.sys.SmsObserver;

/**
 * 5.0以下的信息管理器
 * Created by Administrator on 2017/1/16.
 */
public class MsgManager_21_Left extends MsgManager {

    private Context mContext;

    private SmsObserver smsObserver;

    private Uri SMS_INBOX = Uri.parse("content://sms/");

    public MsgManager_21_Left(Context context){
        mContext = context;
    }

    @Override
    public void init() {
        smsObserver = new SmsObserver(this, mContext, new Handler());
        mContext.getContentResolver().registerContentObserver(SMS_INBOX, true,
                smsObserver);
    }

}
