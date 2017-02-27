package com.longface.lazyui.DynamicView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 让你List中的Item动起来
 *
 * Created by L on 2017/2/22.
 */

public class DynamicView extends RecyclerView {

    public DynamicView(Context context) {
        this(context , null);
    }

    public DynamicView(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public DynamicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
    }

    public void setData(List<TypeView> list){
        DynamicAdapter adapter = (DynamicAdapter) getAdapter();
        if (adapter == null)return;
        adapter.setData(list);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

}
