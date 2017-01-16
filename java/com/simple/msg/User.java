package com.simple.msg;

/**
 * Created by Administrator on 2017/1/16.
 */
public class User {

    public String phoneNum = null;

    public String email = null;

    public User(String info){
        String[] split = info.split(":");
        if (split.length >= 2){
            phoneNum = split[0];
            email = split[1];
        }
    }
}
