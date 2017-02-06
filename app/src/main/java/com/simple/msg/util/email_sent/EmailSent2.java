package com.simple.msg.util.email_sent;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * Created by Administrator on 2017/1/20.
 */
public class EmailSent2 {

    static String a = "runningmaggot@163.com";

    /**
     * 邮件发送程序
     *
     * @param to
     *            接受人
     * @param subject
     *            邮件主题
     * @param content
     *            邮件内容
     * @throws Exception
     * @throws MessagingException
     */
    public static void sendEmail(String to, String subject, String content) throws Exception {
        String host = "smtp.163.com";
        String from = "runningmaggot@163.com";
        String password = "luziqi123789";// 密码
        String port = "25";
        SendEmail(host, from, password, to, port, subject, content);
    }

    /**
     * 邮件发送程序
     *
     * @param host
     *            邮件服务器 如：smtp.qq.com
     * @param from
     *            来自： wsx2miao@qq.com
     * @param password
     *            您的邮箱密码
     * @param to
     *            接收人
     * @param port
     *            端口（QQ:25）
     * @param subject
     *            邮件主题
     * @param content
     *            邮件内容
     * @throws Exception
     */
    public static void SendEmail(String host, String from, String password, String to, String port, String subject, String content) throws Exception {
        Multipart multiPart;
        String finalString = "";

        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", a);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");

        Authenticator myauth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication( a , "luziqi123789");
            }
        };

        Session session = Session.getDefaultInstance(props, myauth);
        DataHandler handler = new DataHandler(new ByteArrayDataSource(finalString.getBytes(), "text/plain"));
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setDataHandler(handler);

        multiPart = new MimeMultipart();
        InternetAddress toAddress;
        toAddress = new InternetAddress(to);
        message.addRecipient(Message.RecipientType.TO, toAddress);
        message.setSubject(subject);
        message.setContent(multiPart);
        message.setText(content);

        Transport transport = session.getTransport("smtp");
        transport.connect(host , a , "luziqi123789");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

}
