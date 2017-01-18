package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;
import com.simple.msg.util.NoteUtil;

/**
 * Created by Administrator on 2017/1/18.
 */
public class OutCode extends Code<Object>{

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
        mNote.removeUserToWhite(num);
    }

    @Override
    public String getCode() {
        return Constant.CODE_OUT;
    }
}
