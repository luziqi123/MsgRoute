package com.simple.msg.config;

import com.simple.msg.User;
import com.simple.msg.config.settings.BindCode;
import com.simple.msg.config.settings.Code;
import com.simple.msg.config.settings.LoginCode;
import com.simple.msg.config.settings.OutCode;
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
        mSettingList.put(Constant.CODE_LOGIN , new LoginCode());
        mSettingList.put(Constant.CODE_OUT , new OutCode());
        mSettingList.put(Constant.CODE_BIND , new BindCode());

        mSettingList.put(Constant.CODE_UNBIND , new LoginCode());
        mSettingList.put(Constant.CODE_MODE_PRIVATE , new LoginCode());
        mSettingList.put(Constant.CODE_MODE_PUBLIC , new LoginCode());
        mSettingList.put(Constant.CODE_SLEEP , new LoginCode());
        mSettingList.put(Constant.CODE_WAKE , new LoginCode());
        mSettingList.put(Constant.CODE_QUERY , new LoginCode());
        mSettingList.put(Constant.CODE_HANGUP , new LoginCode());
        mSettingList.put(Constant.CODE_HANGUP_NOT , new LoginCode());
        mSettingList.put(Constant.CODE_HELP , new LoginCode());
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
    public User getUser(String phone) {
        return null;
    }

    @Override
    public String getSendMode() {
        return null;
    }
}
