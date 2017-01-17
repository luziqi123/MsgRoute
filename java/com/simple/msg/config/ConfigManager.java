package com.simple.msg.config;

import com.simple.msg.User;
import com.simple.msg.sender.Sender;
import com.simple.msg.util.Constant;
import com.simple.msg.util.NoteUtil;

import java.util.List;

/**
 * 软件配置管理器
 * Created by Administrator on 2017/1/17.
 */
public class ConfigManager implements IConfig{

    public Sender mSender;

    private NoteUtil mNoteUtil = NoteUtil.getInstance();

    private static ConfigManager instance = new ConfigManager();
    private ConfigManager(){

    }
    public static ConfigManager getInstance(){
        return instance;
    }

    /**
     * 添加用户
     * @param num
     * @param email
     * @return
     */
    public boolean addUser(String num , String email){
        return mNoteUtil.addUser(num, email , Constant.SENT_TO_MSG);
    }

    /**
     * 删除用户
     * @param num
     */
    public void deleUser(String num){
        mNoteUtil.deleUser(num);
    }

    /**
     * 获取用户
     * @return
     */
    public List<User> getUsers(){
        return mNoteUtil.getUserGroup();
    }

    /**
     * 设置收到消息后通过什么方式进行转发(单个人)
     * @param mode
     */
    public void setSent2(String num , String mode){
        mNoteUtil.setSent2(num , mode);
    }
    /**
     * 设置收到消息后通过什么方式进行转发(全局)
     * @param mode
     */
    public void setSent2(String mode){
//        mNoteUtil.setSent2(mode);
    }


    /**
     * 发来设置消息后就会调用这个方法
     * @param phoneNum
     * @param msg
     */
    public void setCode(String phoneNum, String msg) {

    }

    /**
     * 登录操作
     * @param phoneNum
     */
    public void login(String phoneNum) {
        mNoteUtil.login(phoneNum);
    }

    /**
     * 是否是用户
     * @param phoneNum
     * @return
     */
    public boolean isUser(String phoneNum) {
        return mNoteUtil.isUser(phoneNum);
    }

    /**
     * 是否登录
     * @param phoneNum
     * @return
     */
    public boolean isLogin(String phoneNum) {
        return mNoteUtil.isLogin(phoneNum);
    }

    /**
     * 获取密码
     * @return
     */
    public String getPas() {
        return mNoteUtil.getPas();
    }

    /**
     * 是否是睡眠模式
     * @return
     */
    public boolean isSleep() {
        return mNoteUtil.isSleep();
    }

    /**
     * 设置睡眠模式
     * 设置为睡眠模式后所有消息都不会转发
     * @return
     */
    public void setSleep(boolean isSleep){
        mNoteUtil.setSleep(isSleep);
    }
}
