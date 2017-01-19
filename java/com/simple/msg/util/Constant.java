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


    public static String CODE_LOGIN = "login-";
    public static String CODE_OUT = "out";
    public static String CODE_BIND = "bind";
    public static String CODE_UNBIND = "unbind";
    public static String CODE_USERS = "userGroup";
    public static String CODE_MODE_PRIVATE = "sent2-";
    public static String CODE_MODE_PUBLIC = "sent2Group-";
    public static String CODE_SLEEP = "sleep";
    public static String CODE_WAKE = "wake";
    public static String CODE_QUERY = "query";
    public static String CODE_HANGUP = "hangup";
    public static String CODE_HANGUP_NOT = "dot hangup";
    public static String CODE_HELP = "help";

    /**
     * 所有命令
     */
    public static String CODES =
                    "login- " +
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
