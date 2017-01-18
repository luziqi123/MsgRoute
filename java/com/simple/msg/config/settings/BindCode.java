package com.simple.msg.config.settings;

import com.simple.msg.User;

/**
 * Created by Administrator on 2017/1/18.
 */
public class BindCode extends Code<User , User>{

    @Override
    public void todo(User... val) {

    }

    @Override
    public User getValue(User... val) {
        return null;
    }

    @Override
    public String getCode() {
        return "";
    }
}
