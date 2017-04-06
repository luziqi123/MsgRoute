package com.simple.msg;

import com.simple.msg.util.Constant;

/**
 * 用户类
 * Created by Administrator on 2017/1/16.
 */
public class User {

    public String name = "";

    public String phoneNum = "";

    public String email = "";

    public String sendMode = Constant.SENT_TO_MSG;

    public User(String info){
        String[] split = info.split(":");
        if (split.length == 4){
            phoneNum = split[0];
            email = split[1];
            sendMode = split[2];
            name = split[3];
        }
    }
}
