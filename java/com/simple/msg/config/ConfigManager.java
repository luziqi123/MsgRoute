package com.simple.msg.config;

import android.text.TextUtils;

import com.simple.msg.User;
import com.simple.msg.config.settings.BindCode;
import com.simple.msg.config.settings.Code;
import com.simple.msg.config.settings.HangupCode;
import com.simple.msg.config.settings.HelpCode;
import com.simple.msg.config.settings.LoginCode;
import com.simple.msg.config.settings.ModePrivateCode;
import com.simple.msg.config.settings.ModePublicCode;
import com.simple.msg.config.settings.OutCode;
import com.simple.msg.config.settings.QueryCode;
import com.simple.msg.config.settings.SleepCode;
import com.simple.msg.config.settings.UnbindCode;
import com.simple.msg.config.settings.UnhangupCode;
import com.simple.msg.config.settings.UsersCode;
import com.simple.msg.config.settings.WakeCode;
import com.simple.msg.util.Constant;
import com.simple.msg.util.NoteUtil;

import java.util.HashMap;
import java.util.List;

/**
 * 软件配置管理器
 * Created by Administrator on 2017/1/17.
 */
public class ConfigManager implements IConfig{

    private HashMap<String , Class<? extends Code>> mSettingList;

    private NoteUtil mNote = NoteUtil.getInstance();

    private static ConfigManager instance = new ConfigManager();
    private ConfigManager(){
        mSettingList = new HashMap<>();
        mSettingList.put(Constant.CODE_LOGIN , LoginCode.class);
        mSettingList.put(Constant.CODE_OUT , OutCode.class);
        mSettingList.put(Constant.CODE_BIND , BindCode.class);
        mSettingList.put(Constant.CODE_UNBIND , UnbindCode.class);
        mSettingList.put(Constant.CODE_USERS , UsersCode.class);
        mSettingList.put(Constant.CODE_MODE_PRIVATE , ModePrivateCode.class);
        mSettingList.put(Constant.CODE_MODE_PUBLIC , ModePublicCode.class);
        mSettingList.put(Constant.CODE_SLEEP , SleepCode.class);
        mSettingList.put(Constant.CODE_WAKE , WakeCode.class);
        mSettingList.put(Constant.CODE_QUERY , QueryCode.class);
        mSettingList.put(Constant.CODE_HANGUP , HangupCode.class);
        mSettingList.put(Constant.CODE_HANGUP_NOT , UnhangupCode.class);
        mSettingList.put(Constant.CODE_HELP , HelpCode.class);
    }
    public static ConfigManager getInstance(){
        return instance;
    }

    @Override
    public void setCode(String num, String msg) {
        try {
            if (TextUtils.isEmpty(num) || TextUtils.isEmpty(msg))return;
            if (isCode(msg)) {
                String code = getCode(msg);
                Class<? extends Code> codeClass = mSettingList.get(code);
                codeClass.newInstance().todo(num, msg);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private String getCode(String msg) {
        String code;
        if (msg.contains("-")){
            String[] split = msg.split("-");
            if (split != null && split.length > 0){
                code = split[0].trim() + "-";
            }else{
                code = "null";
            }
        }else{
            code = msg.trim();
        }
        return code;
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
        return mNote.isSleep();
    }

    @Override
    public boolean isHangup() {
        return mNote.getHangup();
    }

    @Override
    public List<User> getUserList() {
        return mNote.getUserGroup();
    }

    @Override
    public User getUser(String phone) {
        return getUser(phone);
    }

    @Override
    public String getSendMode() {
        return getSendMode();
    }
}
