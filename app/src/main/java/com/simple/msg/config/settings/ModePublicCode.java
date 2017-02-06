package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * 设置全局发送类型
 * Created by Administrator on 2017/1/18.
 */
public class ModePublicCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        if (msg == null || !msg.contains(getCode()))return;
        String mode = msg.replace(getCode() , "");
        mNote.setModePublic(mode);
    }

    @Override
    public String getCode() {
        return Constant.CODE_MODE_PUBLIC;
    }
}
