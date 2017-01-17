package com.simple.msg.message;

import com.simple.msg.config.ConfigManager;
import com.simple.msg.sender.Sender;
import com.simple.msg.util.Constant;
import com.simple.msg.util.ToastMaker;

/**
 * 短信管理接口
 * Created by Administrator on 2017/1/16.
 */
public abstract class MsgManager {

    ConfigManager mConfig = ConfigManager.getInstance();

    Sender mSender = Sender.getInstance();

    /**
     * 初始化操作
     */
    public abstract void init();

    /**
     * 来了新消息
     * @param phoneNum
     * @param msg
     */
    public void haveNewMsg(String phoneNum , String msg){
        phoneNum = phoneNum.replace("+86" , "");
        if (isCode(msg)){
            if (hasPermission(phoneNum)){
                mConfig.setCode(phoneNum , msg);
            }else if (isPassword(msg)){
                mConfig.login(phoneNum);
            }else{
                ToastMaker.showLongToast("没有权限");
            }
        }else{
            if (!mConfig.isSleep()) {
                mSender.sentMsg2User(phoneNum, msg);
            }else{
                ToastMaker.showLongToast("睡眠模式");
            }
        }
    }

    /**
     * 是否有权限操作
     * @param phoneNum
     * @return
     */
    private boolean hasPermission(String phoneNum){
        return mConfig.isUser(phoneNum) || mConfig.isLogin(phoneNum);
    }

    /**
     * 是否是登录操作
     * @param msg
     * @return
     */
    private boolean isPassword(String msg){
        return msg != null && msg.equals(mConfig.getPas());
    }

    /**
     * 是否是命令
     * @return
     */
    private boolean isCode(String msg){
        return isPassword(msg) || Constant.CODES.contains(msg.split("-")[0]);
    }

}
