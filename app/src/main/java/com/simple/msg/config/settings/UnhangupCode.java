package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * 设置来电不挂断
 * Created by Administrator on 2017/1/18.
 */
public class UnhangupCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        mNote.setHangup(false);
    }

    @Override
    public String getCode() {
        return Constant.CODE_HANGUP_NOT;
    }
}
