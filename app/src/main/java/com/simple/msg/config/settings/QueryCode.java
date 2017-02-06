package com.simple.msg.config.settings;

import android.text.TextUtils;

import com.simple.msg.sender.Sender;
import com.simple.msg.util.Constant;

/**
 * 查询已注册的用户列表
 * Created by Administrator on 2017/1/18.
 */
public class QueryCode extends Code{

    private Sender mSender = Sender.getInstance();

    @Override
    public void todo(String fromPhone, String msg) {
        // TODO 发送短信到服务商这里回头再写
    }

    @Override
    public String getCode() {
        return Constant.CODE_QUERY;
    }
}
