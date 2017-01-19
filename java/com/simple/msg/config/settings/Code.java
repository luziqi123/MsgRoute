package com.simple.msg.config.settings;

import com.simple.msg.config.Note;

/**
 * 每一个被设置项的抽象类
 * 这个抽象类包含了一下方法：
 * todo()
 * 每一项设置都会影响到一些东西，会改变一些值，也可能是做一些及时的操作，所有被设置后要做的就都在这个方法完成。
 *
 * getCode()
 * 获取自己的代号。
 *
 * Created by Administrator on 2017/1/17.
 */
public abstract class Code{

    protected Note mNote = Note.getInstance();

    /**
     * 这个命令被调用的时候需要做什么操作
     */
    public abstract void todo(String fromPhone , String msg);

    /**
     * 返回自己的关键字
     * @return
     */
    public abstract String getCode();

}
