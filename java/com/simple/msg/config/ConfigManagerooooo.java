package com.simple.msg.config;

import com.simple.msg.config.settings.Setting;
import com.simple.msg.sender.Sender;

import java.util.ArrayList;
import java.util.List;

/**
 * 软件配置管理器
 * Created by Administrator on 2017/1/17.
 */
public class ConfigManagerooooo{

    public Sender mSender;

    private List<Setting> mSettingList;

    private static ConfigManagerooooo instance = new ConfigManagerooooo();
    private ConfigManagerooooo(){
        mSettingList = new ArrayList<>();
    }
    public static ConfigManagerooooo getInstance(){
        return instance;
    }

}
