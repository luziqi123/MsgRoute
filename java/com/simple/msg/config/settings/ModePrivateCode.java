package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * 设置私有发送模式
 * Created by Administrator on 2017/1/18.
 */
public class ModePrivateCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        if (!msg.contains("-"))return;
        String[] split = msg.split("-");
        if (split == null || split.length != 2)return;
        String mode = split[1];
        if (mode.equals(Constant.SENT_TO_EMAIL)){
        }else{
        }
    }

    @Override
    public String getCode() {
        return Constant.CODE_MODE_PRIVATE;
    }
}
