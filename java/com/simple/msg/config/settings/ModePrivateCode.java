package com.simple.msg.config.settings;

import android.text.TextUtils;

import com.simple.msg.util.Constant;

/**
 * 设置私有发送模式
 * Created by Administrator on 2017/1/18.
 */
public class ModePrivateCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        if (msg == null || !msg.contains("-"))return;
        String mode = msg.replace(getCode()  , "");
        if (!TextUtils.isEmpty(mode)) {
            if (mode.equals(Constant.SENT_TO_EMAIL)) {
                mNote.setModePrivate(fromPhone , Constant.SENT_TO_EMAIL);
            }else{
                mNote.setModePrivate(fromPhone , Constant.SENT_TO_MSG);
            }
        }
    }

    @Override
    public String getCode() {
        return Constant.CODE_MODE_PRIVATE;
    }
}
