package com.longface.lazyui.DynamicView;

import android.view.View;

/**
 *
 * Created by Administrator on 2017/2/27.
 */
public abstract class TypeTodo {

    abstract void initView(View view);

    /**
     * 单击
     */
    void onClieck(View view , int posation){}

    /**
     * 长按
     */
    boolean onLongClick(){
        return false;
    }

    /**
     * 左滑
     */
    boolean onLeftTouch(){
        return false;
    }

    /**
     * 右滑
     */
    boolean onRightTouch(){
        return false;
    }
}
