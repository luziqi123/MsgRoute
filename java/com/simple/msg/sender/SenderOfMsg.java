package com.simple.msg.sender;

import android.telephony.SmsManager;

/**
 * 短信发送者
 * Created by Administrator on 2017/1/17.
 */
public class SenderOfMsg {

    public void sent(String phoneNum, String fromNum , String msg) {
        SmsManager sms = SmsManager.getDefault();
        msg = fromNum + ":\n" + msg;
        if (msg.length() > 70) {
//            ArrayList<String> msgs = sms.divideMessage(msg);
//            ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();
//            Intent sentIntent = new Intent(SENT_SMS_ACTION);
//            PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, sentIntent, 0);
//
//            Intent deliverIntent = new Intent(DELIVERED_SMS_ACTION);
//            PendingIntent deliverPI = PendingIntent.getBroadcast(this, 0, deliverIntent, 0);
//            for(int i = 0;i<msgs.size();i++){
//                sentIntents.add(sentPI);
//            }
//            sms.sendMultipartTextMessage(phoneNum, null, msgs, sentIntents, null);
        } else {
            sms.sendTextMessage(phoneNum, null, msg, null, null);
        }
    }
}
