package com.simple.msg.config.settings;

import android.text.TextUtils;

import com.simple.msg.sender.Sender;
import com.simple.msg.util.Constant;

/**
 * Created by Administrator on 2017/1/18.
 */
public class UsersCode extends Code{

    private Sender mSender = Sender.getInstance();

    @Override
    public void todo(String fromPhone, String msg) {
        if (TextUtils.isEmpty(fromPhone) || TextUtils.isEmpty(msg))return;
        String userStr = mNote.getUserStr();
        if (!TextUtils.isEmpty(userStr)) {
            userStr = userStr.replace("-" , "\n");
            mSender.sentTo(fromPhone , "MsgRoute" , userStr);
        }

    }

    @Override
    public String getCode() {
        return Constant.CODE_USERS;
    }
}
