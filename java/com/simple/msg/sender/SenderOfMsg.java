package com.simple.msg.sender;

import android.telephony.SmsManager;

/**
 * 短信发送者
 * Created by Administrator on 2017/1/17.
 */
public class SenderOfMsg {

    public void sent(String phoneNum, String msg) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNum, null, msg, null, null);
    }
}
