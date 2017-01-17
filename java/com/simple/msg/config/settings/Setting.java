package com.simple.msg.config.settings;

import java.util.Objects;

/**
 * 每一个被设置项的接口
 * Created by Administrator on 2017/1/17.
 */
public abstract class Setting<T>{

    /**
     * 获取属性
     * @param val
     * @return
     */
    abstract T getValue(Objects ... val);

    /**
     * 设置值
     * @param value
     */
    abstract void setValue(Objects ... value);

    /**
     * 返回自己的关键字
     * @return
     */
    abstract String myCode();
}
