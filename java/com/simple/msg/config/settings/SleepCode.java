package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * 设置为睡眠模式
 * 来了短信不在转发
 * Created by Administrator on 2017/1/18.
 */
public class SleepCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        if (msg == null)return;
        mNote.setSleep(true);
    }

    @Override
    public String getCode() {
        return Constant.CODE_SLEEP;
    }
}
