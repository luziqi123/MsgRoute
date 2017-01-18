package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;
import com.simple.msg.util.NoteUtil;

/**
 * 取消绑定
 * Created by Administrator on 2017/1/18.
 */
public class UnbindCode extends Code{

    @Override
    public void todo(String fromPhone, String msg) {
        mNote.removeUserToWhite(fromPhone);
    }

    @Override
    public String getCode() {
        return Constant.CODE_UNBIND;
    }
}
