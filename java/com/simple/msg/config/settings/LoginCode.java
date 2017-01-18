package com.simple.msg.config.settings;

import com.simple.msg.util.NoteUtil;

/**
 * 登录命令
 * Created by Administrator on 2017/1/17.
 */
public class LoginCode extends Code<Boolean, Object> {

    NoteUtil mNote = NoteUtil.getInstance();

    /**
     * 需要传两个参数
     * 第一个为号码
     * 第二个为登录还是登出
     * @param val
     */
    @Override
    public void todo(Object... val) {
        if (val == null || val.length != 1)return;
        String num = (String) val[0];
        if (mNote.getWhiteUser().contains(num))return;
        mNote.addUserToWhite(num);
    }

    /**
     * 是否已经登录
     * @param val
     * @return
     */
    @Override
    public Boolean getValue(Object... val) {
        if (val == null || val.length != 1)return false;
        String num = (String) val[0];
        return mNote.getWhiteUser().contains(num);
    }

    @Override
    public String getCode() {
        return "login";
    }
}
