package com.simple.msg.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Activity基类
 * Created by Mr.LongFace on 2017/4/2.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getCentent());
        initView();
        if (savedInstanceState != null){
            restoreData(savedInstanceState);
        }else{
            initData();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveData(outState);
    }

    @Override
    public void onClick(View v) {
        String viewID = v.getContext().getPackageName();
        viewID += v.getId();
        TrackManager.getInstance().step(viewID);
    }

    /**
     * findViewById
     * @param ID 控件ID
     * @return 控件
     */
    protected <T extends View> T find(int ID){
        return (T)findViewById(ID);
    }

    /**
     * 设置点击事件
     */
    protected void setClick(View...views){
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }
    protected void setClick(int...Ids){
        for (int id : Ids) {
            find(id).setOnClickListener(this);
        }
    }

    /**
     * 返回你的布局文件
     * @return
     */
    public abstract int getCentent();

    /**
     * 初始化你的控件
     */
    public abstract void initView();

    /**
     * 初始化你的数据
     */
    public abstract void initData();

    /**
     * 需要恢复的数据
     * @param savedInstanceState
     */
    public void restoreData(Bundle savedInstanceState){}

    /**
     * 保存数据
     * @param outState
     */
    public void saveData(Bundle outState){}

}
