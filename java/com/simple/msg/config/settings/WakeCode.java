package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * 唤醒命令
 * 开启转发功能
 * Created by Administrator on 2017/1/18.
 */
public class WakeCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        mNote.setSleep(false);
    }

    @Override
    public String getCode() {
        return Constant.CODE_WAKE;
    }
}
