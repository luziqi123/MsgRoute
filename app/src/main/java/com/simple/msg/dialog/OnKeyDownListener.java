package com.simple.msg.dialog;

/**
 * Dialog被点击后的回调
 * Created by Mr.LongFace on 2017/4/5.
 */
public interface OnKeyDownListener {
    /**
     * 确定按钮 如果只有一个键返回也是他
     */
    int KEY_OK = 0;
    /**
     * 取消按钮
     */
    int KEY_NO = 1;
    void onKeyDown(int keyEvent);
}
