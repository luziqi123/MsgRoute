package com.simple.msg.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;

/**
 * Created by Administrator on 2017/1/16.
 */
public class SmsObserver extends android.database.ContentObserver {

    private Uri SMS_INBOX = Uri.parse("content://sms/");

    private Context context;

    private IMsgManager mManager;

    public SmsObserver(IMsgManager manager , Context context, Handler handler) {
        super(handler);
        this.context = context;
        mManager = manager;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        ContentResolver cr = context.getContentResolver();
        String[] projection = new String[] { "_id", "address", "body" , "person" };
        Cursor cur = cr.query(SMS_INBOX, projection, null, null, "date desc");
        if (null == cur)
            return;
        if (cur.moveToFirst()) {
            String number = cur.getString(cur.getColumnIndex("address"));//手机号
            String name = cur.getString(cur.getColumnIndex("person"));//联系人姓名列表
            String body = cur.getString(cur.getColumnIndex("body"));
            mManager.haveNewMsg(name , body);
        }
        cur.close();

    }

}

