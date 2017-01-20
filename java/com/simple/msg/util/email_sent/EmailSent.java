package com.simple.msg.util.email_sent;

import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Administrator on 2017/1/20.
 */
public class EmailSent {

    // 设置服务器
    private static String KEY_SMTP = "mail.smtp.host";
    private static String VALUE_SMTP = "smtp.163.com";
    // 服务器验证
    private static String KEY_PROPS = "mail.smtp.auth";
    private static boolean VALUE_PROPS = true;
    // 发件人用户名、密码
    private String SEND_USER = "runningmaggot@163.com";
    private String SEND_PWD = "luziqi123789";
    // 建立会话
    private MimeMessage message;
    private Session s;

    /*
     * 初始化方法
     */
    public EmailSent() {
        Properties props = System.getProperties();
        props.setProperty(KEY_SMTP, VALUE_SMTP);
        props.setProperty(KEY_PROPS, "true");
        props.setProperty("mail.smtp.auth", "true");
        s =  Session.getDefaultInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SEND_USER, SEND_PWD);
            }});
        s.setDebug(true);
        message = new MimeMessage(s);
    }

    /**
     * 发送邮件
     *
     * @param headName
     *            邮件头文件名
     * @param sendHtml
     *            邮件内容
     * @param receiveUser
     *            收件人地址
     */
    public void doSendHtmlEmail(String headName, String sendHtml,
                                String receiveUser) throws Exception {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.host", KEY_SMTP);        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 请求认证，参数名称与具体实现有关

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, SEND_USER, receiveUser);

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();

        // 5. 使用 邮箱账号 和 密码 连接邮件服务器
        //    这里认证的邮箱必须与 message 中的发件人邮箱一致，否则报错
        transport.connect(SEND_USER, SEND_PWD);

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());

        // 7. 关闭连接
        transport.close();
    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "某宝网", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
//        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("会议通知", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("今天下午全体开会", "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }

//    /**
//     * 发送邮件
//     *
//     * @param headName
//     *            邮件头文件名
//     * @param sendHtml
//     *            邮件内容
//     * @param receiveUser
//     *            收件人地址
//     */
//    public void doSendHtmlEmail(String headName, String sendHtml,
//                                String receiveUser) {
//        try {
//            // 发件人
//            InternetAddress from = new InternetAddress(SEND_USER);
//            message.setFrom(from);
//            // 收件人
//            InternetAddress to = new InternetAddress(receiveUser);
//            message.setRecipient(Message.RecipientType.TO, to);
//            // 邮件标题
//            message.setSubject(headName);
//            String content = sendHtml.toString();
//            // 邮件内容,也可以使纯文本"text/plain"
//            message.setContent(content, "text/html;charset=UTF-8");
//            message.saveChanges();
//            Transport transport = s.getTransport("smtp");
//            // smtp验证，就是你用来发邮件的邮箱用户名密码
//            transport.connect(VALUE_SMTP, SEND_USER, SEND_PWD);
//            // 发送
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//            System.out.println("send success!");
//        } catch (AddressException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }

}
