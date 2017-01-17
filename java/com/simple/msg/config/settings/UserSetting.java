package com.simple.msg.config.settings;

import com.simple.msg.User;
import com.simple.msg.util.NoteUtil;

import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/1/17.
 */
public class UserSetting extends Setting<List<User>>{

    @Override
    List<User> getValue(Objects... val) {
        return NoteUtil.getInstance().getUserGroup();
    }

    @Override
    void setValue(Objects... value) {
        // 什么也不做
    }

    @Override
    String myCode() {
        return "userGroup";
    }
}
