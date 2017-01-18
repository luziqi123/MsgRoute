package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * 登录命令
 * Created by Administrator on 2017/1/17.
 */
public class LoginCode extends Code {

    @Override
    public void todo(String fromPhone, String msg) {
        String[] split = msg.split("-");
        if (split == null || split.length != 2)return;
        String pas = split[1];
        if (mNote.getWhiteUser().contains(fromPhone))return;
        if (mNote.getUserStr().contains(fromPhone))return;
        if (!mNote.getPassword().equals(pas))return;
        mNote.addUserToWhite(fromPhone);
    }

    @Override
    public String getCode() {
        return Constant.CODE_LOGIN;
    }
}
