package com.simple.msg.config;

import com.simple.msg.User;

import java.util.List;

/**
 * 设置相关的接口
 * Created by Administrator on 2017/1/17.
 */
public interface IConfig {
    /**
     * 添加用户
     * @param num
     * @param email
     * @return
     */
    boolean addUser(String num , String email);

    /**
     * 删除用户
     * @param num
     */
    void deleUser(String num);

    /**
     * 获取用户
     * @return
     */
    List<User> getUsers();

    /**
     * 设置收到消息后通过什么方式进行转发(单个人)
     * @param mode
     */
    void setSent2(String num , String mode);
    /**
     * 设置收到消息后通过什么方式进行转发(全局)
     * @param mode
     */
    void setSent2(String mode);

    /**
     * 发来设置消息后就会调用这个方法
     * @param phoneNum
     * @param msg
     */
    void setCode(String phoneNum, String msg);

    /**
     * 登录操作
     * @param phoneNum
     */
    void login(String phoneNum);

    /**
     * 是否是睡眠模式
     * @return
     */
    boolean isSleep();

    /**
     * 设置睡眠模式
     * 设置为睡眠模式后所有消息都不会转发
     * @return
     */
    void setSleep(boolean isSleep);

    /**
     * 是否是用户
     * @param phoneNum
     * @return
     */
    boolean isUser(String phoneNum);

    /**
     * 是否登录
     * @param phoneNum
     * @return
     */
    boolean isLogin(String phoneNum);

    /**
     * 获取密码
     * @return
     */
    String getPas();
}
