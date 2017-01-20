package com.simple.msg.util.email_sent;


/**
 * 发件箱工厂
 *
 * @author MZULE
 *
 */
public class MailSenderFactory {

    /**
     * 服务邮箱
     */
    private static SimpleMailSender serviceSms = null;

    /**
     * 获取邮箱
     *
     * @return 符合类型的邮箱
     */
    public static SimpleMailSender getSender() {
        if (serviceSms == null) {
            serviceSms = new SimpleMailSender("invisible@126.com",
                    "hidden");
        }
        return serviceSms;
    }

}