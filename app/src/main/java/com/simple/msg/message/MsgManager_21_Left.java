package com.simple.msg.message;

import android.content.Context;
import android.os.Handler;

import com.simple.msg.sys.SmsObserver;
import com.simple.msg.util.Constant;

/**
 * 5.0以下的信息管理器
 * Created by Administrator on 2017/1/16.
 */
public class MsgManager_21_Left extends MsgManager {

    private Context mContext;

    private SmsObserver smsObserver;

    public MsgManager_21_Left(Context context){
        mContext = context;
    }

    @Override
    public void init() {
        smsObserver = new SmsObserver(this, mContext, new Handler());
        mContext.getContentResolver().registerContentObserver(Constant.CONTENT_URI, true,
                smsObserver);
    }

}
