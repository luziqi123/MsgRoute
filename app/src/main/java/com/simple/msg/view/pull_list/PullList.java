package com.simple.msg.view.pull_list;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by L on 2017/2/22.
 */

public class PullList extends ViewGroup{

    public PullList(Context context) {
        this(context , null);
    }

    public PullList(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public PullList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PullList(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
