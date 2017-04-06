package com.simple.msg.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.simple.msg.User;
import com.simple.msg.util.Constant;
import com.simple.msg.util.ToastMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/16.
 */
public class Note {

    private static SharedPreferences mPreferences;

    public static boolean isUpdate = true;

    public static List<User> userList = new ArrayList<>();

    public static String loginUsers = "";

    private static Note instance = new Note();
    private Note(){}
    public static Note getInstance(){
        return instance;
    }

    public static void init(Context context) {
        mPreferences = context.getSharedPreferences("msgRoute", Context.MODE_PRIVATE);
    }

    /**
     * 获取所有用户的字符串
     * @return 用户名组成的字符串
     */
    public String getUserStr() {
        return mPreferences.getString("users", "");
    }

    /**
     * 获取白名单用户
     * @return 白名单用户拼成的字符串
     */
    public String getWhiteUser() {
        return loginUsers;
    }

    /**
     * 添加至白名单
     * @param num
     */
    public void addUserToWhite(String num) {
        loginUsers += num;
    }

    /**
     * 从白名单移除
     * @param num
     */
    public void removeUserToWhite(String num) {
        loginUsers = loginUsers.replace(num, "");
    }

    /**
     * 设置密码
     * @param oldPas
     * @param nowPas
     */
    public void setPassword(String oldPas, String nowPas) {
        mPreferences.edit().putString("pas", nowPas).apply();
    }

    /**
     * 获取密码
     *
     * @return
     */
    public String getPassword() {
        return mPreferences.getString("pas", "--");
    }

    /**
     * 获取用户组
     *
     * @return
     */
    public List<User> getUserGroup() {
        if (!isUpdate) return userList;
        isUpdate = false;
        userList.clear();
        String u = getUserStr();
        String[] split = u.split("-");
        for (int i = 0; i < split.length; i++) {
            userList.add(new User(split[i]));
        }
        return userList;
    }


    /**
     * 删除用户
     *
     * @param num
     * @return
     */
    public void deleUser(String num) {
        String u = getUserStr();
        if (!u.contains(num)) return;
        isUpdate = true;
        List<User> userGroup = getUserGroup();
        mPreferences.edit().putString("users", "").commit();
        for (User user : userGroup) {
            if (!user.phoneNum.equals(num)) {
                addUser(user.name , user.phoneNum, user.email, user.sendMode);
            }
        }
    }

    /**
     * 根据手机号码获取用户
     * @param phone
     * @return
     */
    public User getUser(String phone) {
        for (User user : getUserGroup()) {
            if (user.phoneNum.equals(phone))
                return user;
        }
        return null;
    }

    /**
     * 添加用户
     *
     * @param num
     * @param email
     * @return
     */
    public boolean addUser(String name , String num, String email, String mode) {
        Pattern p = Pattern
                .compile("^1(3[0-9]|4[57]|5[0-35-9]|7[67]|8[0-9])\\d{8}$");
        Matcher m = p.matcher(num);
        if (!m.matches()) {
            ToastMaker.showLongToast("号码错误");
            return false;
        }
        Pattern regex = Pattern
                .compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        Matcher matcher = regex.matcher(email);
        if (!matcher.matches()) {
            ToastMaker.showLongToast("邮箱错误");
            return false;
        }
        String u = mPreferences.getString("users", "");
        if (u.contains(num)) {
            ToastMaker.showLongToast("已存在的用户");
            return false;
        }
        isUpdate = true;
        if (TextUtils.isEmpty(u)) {
            mPreferences.edit().putString("users" , num + ":" + email + ":" + mode + ":" + name).apply();
        } else {
            mPreferences.edit().putString("users", u + "-" + num + ":" + email + ":" + mode + ":" + name).apply();
        }
        return true;
    }

    /**
     * 是否是睡眠模式
     *
     * @return
     */
    public boolean isSleep() {
        return mPreferences.getBoolean("sleep", false);
    }

    /**
     * 打开 / 关闭睡眠模式
     *
     * @param sleep
     */
    public void setSleep(boolean sleep) {
        mPreferences.edit().putBoolean("sleep", sleep).apply();
    }

    /**
     * 设置单个人的发送模式
     *
     * @param num
     * @param mode
     */
    public void setModePrivate(String num, String mode) {
        String u = mPreferences.getString("users", "");
        if (!u.contains(num)) return;
        isUpdate = true;
        List<User> userGroup = getUserGroup();
        mPreferences.edit().putString("users", "").commit();
        for (User user : userGroup) {
            if (!user.phoneNum.equals(num)) {
                addUser(user.name , user.phoneNum, user.email, user.sendMode);
            } else {
                addUser(user.name , user.phoneNum, user.email, mode);
            }
        }
    }

    /**
     * 设置全局的发送模式
     *
     * @param mode
     */
    public void setModePublic(String mode) {
        if (Constant.SENT_TO_EMAIL.equals(mode)){
            mPreferences.edit().putString("sentMode" , Constant.SENT_TO_EMAIL);
        }else{
            mPreferences.edit().putString("sentMode" , Constant.SENT_TO_MSG);
        }
    }

    /**
     * 设置是否挂断电话
     * @param hangup
     */
    public void setHangup(boolean hangup) {
        mPreferences.edit().putBoolean(Constant.CODE_HANGUP , hangup);
    }

    /**
     * 获取是否挂断电话
     */
    public boolean getHangup() {
        return mPreferences.getBoolean(Constant.CODE_HANGUP , false);
    }

}
