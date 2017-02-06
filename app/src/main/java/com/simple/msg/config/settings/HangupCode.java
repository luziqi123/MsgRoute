package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * 来电挂断
 * Created by Administrator on 2017/1/18.
 */
public class HangupCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        mNote.setHangup(true);
    }

    @Override
    public String getCode() {
        return Constant.CODE_HANGUP;
    }
}
