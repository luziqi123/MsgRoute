package com.simple.msg.manager;

/**
 * 发送者接口
 * Created by Administrator on 2017/1/16.
 */
public interface ISender {

    /**
     * 发送信息
     * @param msg
     */
    boolean sentMsg(String msg);

}
