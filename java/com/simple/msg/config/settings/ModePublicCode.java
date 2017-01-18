package com.simple.msg.config.settings;

import com.simple.msg.util.Constant;

/**
 * Created by Administrator on 2017/1/18.
 */
public class ModePublicCode extends Code<Object>{

    @Override
    public void todo(Object... val) {
        if (val == null || val.length != 1)return;
    }

    @Override
    public String getCode() {
        return Constant.CODE_UNBIND;
        sdf
    }
}
