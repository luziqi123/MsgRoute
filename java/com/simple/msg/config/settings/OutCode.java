package com.simple.msg.config.settings;

import android.text.TextUtils;

import com.simple.msg.util.Constant;
import com.simple.msg.util.NoteUtil;

/**
 * 退出命令
 * Created by Administrator on 2017/1/18.
 */
public class OutCode extends Code{

    /**
     * 需要传两个参数
     * 第一个为号码
     * 第二个为登录还是登出
     */
    @Override
    public void todo(String fromPhone, String msg) {
        if (TextUtils.isEmpty(fromPhone)){
            mNote.removeUserToWhite(fromPhone);
        }
    }

    @Override
    public String getCode() {
        return Constant.CODE_OUT;
    }
}
