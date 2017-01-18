package com.simple.msg.config.settings;

import com.simple.msg.sender.Sender;
import com.simple.msg.util.Constant;

/**
 * Created by Administrator on 2017/1/18.
 */
public class HelpCode extends Code{

    private Sender mSender;

    public HelpCode(Sender sender){
        mSender = sender;
    }

    @Override
    public void todo(String fromPhone, String msg) {
        String help =
                "进入编辑：login-密码\n" +
                "离开编辑：out\n" +
                "\n" +
                "设置分为\n" +
                "绑定：bind\n" +
                "解绑：unbind\n" +
                "查询用户组：userGroup\n" +
                "发送信息模式(个体)：sent2-msg|email\n" +
                "发送信息模式(全局)：sent2Group-msg|email\n" +
                "关闭：sleep\n" +
                "开启：wake\n" +
                "话费：query\n" +
                "来电挂断：hangup\n" +
                "来电不挂断：dot hangup\n" +
                "命令查询：help\n" +
                "发送信息到指定号码：sent-号码 内容\n" +
                "注：个体设置高于全局设置,默认全部为短信发送.";
        mSender.sentTo(fromPhone , "MsgRoute" , help);
    }

    @Override
    public String getCode() {
        return Constant.CODE_UNBIND;
    }
}
