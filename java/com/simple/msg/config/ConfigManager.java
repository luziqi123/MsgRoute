package com.simple.msg.config;

import com.simple.msg.User;
import com.simple.msg.config.settings.Code;
import com.simple.msg.config.settings.LoginCode;
import com.simple.msg.sender.Sender;
import com.simple.msg.util.Constant;

import java.util.HashMap;
import java.util.List;

/**
 * 软件配置管理器
 * Created by Administrator on 2017/1/17.
 */
public class ConfigManager implements IConfig{

    public Sender mSender;

    private HashMap<String , Code> mSettingList;

    private static ConfigManager instance = new ConfigManager();
    private ConfigManager(){
        mSettingList = new HashMap<>();
        mSettingList.put("login" , new LoginCode());
    }
    public static ConfigManager getInstance(){
        return instance;
    }

    @Override
    public void setCode(String num, String msg) {

    }

    @Override
    public boolean isAdmin(String num) {
        return false;
    }

    @Override
    public boolean isCode(String msg) {
        String code;
        if (msg.contains("-")){
            String[] split = msg.split("-");
            if (split != null && split.length > 0){
                code = split[0];
            }else{
                code = "null";
            }
        }else{
            code = msg;
        }
        return Constant.CODES.contains(code);
    }

    @Override
    public boolean isSleep() {
        return false;
    }

    @Override
    public boolean isHangup() {
        return false;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public String getSendMode() {
        return null;
    }
}
