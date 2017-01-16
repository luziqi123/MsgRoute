package com.simple.msg.manager;

/**
 * 短信管理接口
 * Created by Administrator on 2017/1/16.
 */
public interface IMsgManager extends ISender{

    /**
     * 初始化操作
     */
    void init();

    /**
     * 来了新消息
     * @param phoneNum
     * @param msg
     */
    void haveNewMsg(String phoneNum , String msg);

}
