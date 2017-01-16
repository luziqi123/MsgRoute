package com.simple.msg.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.simple.msg.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */
public class SharedUtil {

    private static SharedPreferences mPreferences;

    public static void init(Context context){
        mPreferences = context.getSharedPreferences("msgRoute" , Context.MODE_PRIVATE);
    }

    public static List<User> getUserGroup(){
        List<User> list = new ArrayList<>();
        String u = mPreferences.getString("users", "");
        u.split("")
    }
}
