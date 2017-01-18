package com.simple.msg.util;

/**
 * 常量
 * Created by Administrator on 2017/1/17.
 */
public class Constant {

    /**
     * 收到信息通过短信方式转发
     */
    public static String SENT_TO_MSG = "SentToMsg";

    /**
     * 收到信息通过Email方式转发
     */
    public static String SENT_TO_EMAIL = "SentToEmail";

    /**
     * 所有命令
     */
    public static String CODES =
                    "out " + // 退出登录
                    "bind " + // 绑定
                    "unbind " + // 解绑
                    "userGroup " + // 查询用户组
                    "sent2email " + // 发送信息到邮箱(个体)
                    "sent2msg " + // 发送信息到短信(个体)
                    "sent2emailAll " + // 发送信息到邮箱(全局)
                    "sent2msgAll " + // 发送信息到短信(全局)
                    "sleep " + //关闭
                    "wake " + // 开启
                    "query " + // 话费
                    "hangup " + // 来电挂断
                    "dot hangup " + // 来电不挂断
                    "sent " + // 发送信息到指定号码
                    "help "; // 命令查询
}
