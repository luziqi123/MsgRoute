package com.simple.msg.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;

import com.simple.msg.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/16.
 */
public class NoteUtil {

    private static SharedPreferences mPreferences;

    public static boolean isUpdate = true;

    public static List<User> userList = new ArrayList<>();

    public static String loginUsers = "";

    public static void init(Context context){
        mPreferences = context.getSharedPreferences("msgRoute" , Context.MODE_PRIVATE);
    }

    /**
     * 这个号码是不是用户
     * @param num
     * @return
     */
    public static boolean isUser(String num){
        String u = mPreferences.getString("users", "");
        return u.contains(num);
    }

    /**
     * 是否是登录账户
     * @param num
     * @return
     */
    public static boolean isLogin(String num){
        return loginUsers.contains(num);
    }

    /**
     * 登录
     * @param num
     */
    public static void login(String num){
        if (isLogin(num))return;
        loginUsers += num;
    }

    /**
     * 退出
     * @param num
     */
    public static void sigOut(String num){
        loginUsers = loginUsers.replace(num , "");
    }

    /**
     * 设置密码
     * @param oldPas
     * @param nowPas
     */
    public static void setPas(String oldPas , String nowPas){
        if (getPas().equals("--") || getPas().equals(oldPas)){
            mPreferences.edit().putString("pas" , nowPas);
        }else{
            ToastMaker.showLongToast("旧密码错误");
        }
    }

    /**
     * 获取密码
     * @return
     */
    public static String getPas(){
        return mPreferences.getString("pas", "--");
    }













    /**
     * 获取用户组
     * @return
     */
    public static List<User> getUserGroup(){
        if (!isUpdate)return userList;
        isUpdate = false;
        userList.clear();
        String u = mPreferences.getString("users", "");
        String[] split = u.split("-");
        for (int i = 0; i < split.length; i++) {
            userList.add(new User(split[i]));
        }
        return userList;
    }

    /**
     * 删除用户
     * @param num
     * @return
     */
    public static void deleUser(String num){
        String u = mPreferences.getString("users", "");
        if (!u.contains(num))return;
        isUpdate = true;
        List<User> userGroup = getUserGroup();
        mPreferences.edit().putString("users" , "").commit();
        for (User user : userGroup) {
            if (!user.phoneNum.equals(num)){
                addUser(user.phoneNum , user.email , user.sendMode);
            }
        }
    }

    /**
     * 添加用户
     * @param num
     * @param email
     * @return
     */
    public static boolean addUser(String num , String email , String mode){
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
        if (!matcher.matches()){
            ToastMaker.showLongToast("邮箱错误");
            return false;
        }
        String u = mPreferences.getString("users", "");
        if (u.contains(num)){
            ToastMaker.showLongToast("已存在的用户");
            return false;
        }
        isUpdate = true;
        if (TextUtils.isEmpty(u)) {
            mPreferences.edit().putString("users" , num + ":" + email + ":" + mode).apply();
        } else {
            mPreferences.edit().putString("users", u + "-" + num + ":" + email + ":" + mode).apply();
        }
        return true;
    }

    /**
     * 是否是睡眠模式
     * @return
     */
    public static boolean isSleep() {
        return mPreferences.getBoolean("sleep", false);
    }

    /**
     * 打开 / 关闭睡眠模式
     * @param sleep
     */
    public static void setSleep(boolean sleep) {
        mPreferences.edit().putBoolean("sleep" , sleep).apply();
    }
}
