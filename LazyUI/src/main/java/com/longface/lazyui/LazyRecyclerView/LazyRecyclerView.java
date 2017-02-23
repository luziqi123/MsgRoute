package com.longface.lazyui.LazyRecyclerView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by L on 2017/2/23.
 */

public class LazyRecyclerView extends RecyclerView{

    public LazyRecyclerView(Context context) {
        this(context , null);
    }

    public LazyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public LazyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
    }
}
