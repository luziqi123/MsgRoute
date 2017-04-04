package com.simple.msg.base;

import java.util.ArrayList;

/**
 * 用户点击轨迹追踪
 * Created by Mr.LongFace on 2017/4/2.
 */
public class TrackManager {

    /**
     * 步骤记录
     */
    private ArrayList<String> mTrackList;

    /**
     * 记录最大数量
     * 大于此数量将缓存存入文件 并释放缓存
     */
    private int STEP_MAX = 500;

    private static TrackManager instance;
    private TrackManager(){
        mTrackList = new ArrayList<>();
    }
    public static TrackManager getInstance(){
        if (instance == null){
            synchronized (TrackManager.class){
                if (instance == null){
                    instance = new TrackManager();
                }
            }
        }
        return instance;
    }

    public void step(String stepName){
        mTrackList.add(stepName);
        if (mTrackList.size() >= STEP_MAX) {
            flash();
        }
    }

    private void flash() {
        synchronized (mTrackList){
            final ArrayList<String> list = (ArrayList<String>) mTrackList.clone();
            mTrackList.clear();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO 将集合中的数据写到文件中
                }
            }).start();
        }
    }
}
