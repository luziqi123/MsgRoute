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
     * @param fromNum
     * @param msg
     */
    public void  sentAll(String fromNum , String msg){
        List<User> users = ConfigManager.getInstance().getUserList();
        if (users == null)return;
        for (User user : users) {
            if (user.sendMode.equals(Constant.SENT_TO_EMAIL)){
                mSendEmail.sent(user.email , fromNum , msg);
            }else{
                mSendMsg.sent(user.phoneNum , fromNum , msg);
            }
        }
    }

    /**
     * 发送消息给指定用户
     */
    public void  sentTo(String toPhone , String fromNum , String msg){
        User user = ConfigManager.getInstance().getUser(toPhone);
        if (user == null || user.sendMode.equals(Constant.SENT_TO_EMAIL)){
            mSendEmail.sent(user.email , toPhone , msg);
        }else{
            mSendMsg.sent(toPhone , fromNum , msg);
        }
    }
}
