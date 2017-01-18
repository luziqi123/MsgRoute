package com.simple.msg.config.settings;

/**
 * 每一个被设置项的抽象类
 * 这个抽象类包含了一下方法：
 * todo()
 * 每一项设置都会影响到一些东西，会改变一些值，也可能是做一些及时的操作，所有被设置后要做的就都在这个方法完成。
 *
 * getValue()
 * 这个方法返回该设置项被设置后影响到的值，比如登录影响到了白名单，那getValue()方法就是返回白名单。
 *
 * getCode()
 * 获取自己的代号。
 *
 * Created by Administrator on 2017/1/17.
 */
public abstract class Code<T , V>{

    /**
     * 这个命令被调用的时候需要做什么操作
     */
    public abstract void todo(V ... val);

    /**
     * 获取属性
     * @param val
     * @return
     */
    public abstract T getValue(V ... val);

    /**
     * 返回自己的关键字
     * @return
     */
    public abstract String getCode();
}
