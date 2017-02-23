package com.longface.lazyui.DynamicView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.SoftReference;

/**
 * Created by L on 2017/2/23.
 */

public class DynamicAdapter extends RecyclerView.Adapter{

    private SoftReference<View.OnClickListener> onClickListenerSoftReference;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setOnItemClick(View.OnClickListener click){

    }
}
