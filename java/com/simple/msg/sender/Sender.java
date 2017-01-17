package com.simple.msg.sender;

import com.simple.msg.User;
import com.simple.msg.config.ConfigManager;
import com.simple.msg.util.Constant;

import java.util.List;

/**
 * 发送消息类
 * Created by Administrator on 2017/1/17.
 */
public class Sender {

    private SenderOfMsg mSendMsg;

    private SenderOfEmail mSendEmail;

    private static Sender instance = new Sender();
    private Sender(){
        mSendMsg = new SenderOfMsg();
        mSendEmail = new SenderOfEmail();
    }
    public static Sender getInstance(){
        return instance;
    }

    /**
     * 发送消息给所有用户
     * @param phoneNum
     * @param msg
     */
    public void  sentMsg2User(String phoneNum , String msg){
        List<User> users = ConfigManager.getInstance().getUsers();
        for (User user : users) {
            if (user.sendMode.equals(Constant.SENT_TO_EMAIL)){
                mSendEmail.sent(phoneNum , msg);
            }else{
                mSendMsg.sent(phoneNum , msg);
            }
        }
    }
}
