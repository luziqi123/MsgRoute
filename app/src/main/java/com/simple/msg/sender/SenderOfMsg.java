package com.simple.msg.sender;

import android.telephony.SmsManager;

import java.util.ArrayList;

/**
 * 短信发送者
 * Created by Administrator on 2017/1/17.
 */
public class SenderOfMsg {

    public void sent(String phoneNum, String fromNum , String msg) {
        SmsManager sms = SmsManager.getDefault();
        msg = fromNum + ":\n" + msg;
        ArrayList<String> messageArray = sms.divideMessage(msg);
        sms.sendMultipartTextMessage(phoneNum, null, messageArray, null, null);
    }
}
