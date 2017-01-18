package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * 绑定号码命令
 * Created by Administrator on 2017/1/18.
 */
public class BindCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        if (mNote.getUserStr().contains(fromPhone)) return;
        if (!mNote.getWhiteUser().contains(fromPhone))return;
        mNote.addUser(fromPhone, "null" , Constant.SENT_TO_MSG);
    }

    @Override
    public String getCode() {
        return Constant.CODE_BIND;
    }
}
