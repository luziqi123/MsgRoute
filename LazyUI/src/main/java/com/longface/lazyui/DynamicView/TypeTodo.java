package com.longface.lazyui.DynamicView;

import android.view.View;

/**
 *
 * Created by Administrator on 2017/2/27.
 */
public abstract class TypeTodo <T>{

    protected abstract void initView(View view, T data);

    /**
     * 单击
     */
    protected void onClieck(View view , int posation , T data){}

    /**
     * 长按
     */
    protected boolean onLongClick(View view , T data){
        return false;
    }

    /**
     * 左滑
     */
    protected boolean onLeftTouch(View view , T data){
        return false;
    }

    /**
     * 右滑
     */
    protected boolean onRightTouch(View view , T data){
        return false;
    }
}
