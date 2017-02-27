package com.longface.lazyui.DynamicView;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.longface.lazyui.R;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2017/2/23.
 */

public class DynamicAdapter extends RecyclerView.Adapter{

    private List<TypeView> mList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.support_simple_spinner_dropdown_item;
    }

    public void setData(List<TypeView> list) {
        if (list == null || list.size() <= 0)return;
        mList.clear();
        mList.addAll(list);
    }

    class A extends RecyclerView.ViewHolder{

        public A(View itemView) {
            super(itemView);
        }
    }
}
