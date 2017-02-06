package com.simple.msg.sys;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

import com.simple.msg.message.MsgManager;
import com.simple.msg.util.Constant;

import java.util.concurrent.RecursiveTask;

/**
 * 监听短信数据库发生变化的内容提供者
 * Created by Administrator on 2017/1/16.
 */
public class SmsObserver extends android.database.ContentObserver {

    private Context context;

    private MsgManager mManager;

    public SmsObserver(MsgManager manager , Context context, Handler handler) {
        super(handler);
        this.context = context;
        mManager = manager;
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        // 第一遍 先执行content://sms/raw 第二遍则 uri.toString :content://sms/inbox
        // 如果没有这个判断则会走两遍onChange方法
        if ("content://sms/raw".equals(uri.toString())) return;
        ContentResolver cr = context.getContentResolver();
        String[] projection = new String[] {
                Constant.ADDRESS,
                Constant.TYPE,
                Constant.BODY};
        Cursor cur = cr.query(Constant.CONTENT_URI , projection, null, null, Constant.DEFAULT_SORT_ORDER);
        if (null == cur)
            return;
        if (cur.moveToFirst()) {
            int type = cur.getInt(cur.getColumnIndex(Constant.TYPE));// 类型
            if (type == 2)return;// 1是收到的  2是发出的
            String number = cur.getString(cur.getColumnIndex(Constant.ADDRESS));// 手机号
            String body = cur.getString(cur.getColumnIndex(Constant.BODY)); // 短信内容
            mManager.haveNewMsg(number , body);
        }
        cur.close();
    }
}

