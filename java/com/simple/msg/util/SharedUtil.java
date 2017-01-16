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
public class SharedUtil {

    private static SharedPreferences mPreferences;

    public static void init(Context context){
        mPreferences = context.getSharedPreferences("msgRoute" , Context.MODE_PRIVATE);
    }

    /**
     * 获取用户组
     * @return
     */
    public static List<User> getUserGroup(){
        List<User> list = new ArrayList<>();
        String u = mPreferences.getString("users", "");
        String[] split = u.split("-");
        for (int i = 0; i < split.length; i++) {
            list.add(new User(split[i]));
        }
        return list;
    }

    /**
     * 添加用户
     * @param num
     * @param email
     * @return
     */
    public boolean addUser(String num , String email){
        Pattern p = Pattern
                .compile("^1(3[0-9]|4[57]|5[0-35-9]|7[67]|8[0-9])\\d{8}$");
        Matcher m = p.matcher(num);
        if (!m.matches()) {
            ToastMaker.showLongToast("号码错误");
            return false;
        }
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
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
        if (TextUtils.isEmpty(u)) {
            mPreferences.edit().putString("users" , num + ":" + email);
        }else{
            mPreferences.edit().putString("users" , "-" + num + ":" + email);
        }
        return true;
    }
}
