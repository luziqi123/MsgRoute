package com.simple.msg.config;

import com.simple.msg.User;

import java.util.List;

/**
 * 设置相关的接口
 * Created by Administrator on 2017/1/17.
 */
public interface IConfig {

    void setCode(String num , String msg);

    /**
     * 是否是管理员
     * @param num
     * @return
     */
    boolean isAdmin(String num);

    /**
     * 是不是指令信息
     * @param msg
     * @return
     */
    boolean isCode(String msg);

    /**
     * 是否是睡眠状态
     * @return
     */
    boolean isSleep();

    /**
     * 来电是否挂断
     * @return
     */
    boolean isHangup();

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 根据号码获取用户
     * @param phone
     * @return
     */
    User getUser(String phone);

    /**
     * 获取全局发送模式
     * @return
     */
    String getSendMode();


}
