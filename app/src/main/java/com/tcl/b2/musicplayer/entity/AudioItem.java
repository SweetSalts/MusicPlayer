package com.tcl.b2.musicplayer.entity;
//定义AudioItem类
public class AudioItem {
    private Audio mAudio;

    private int mClassificationId;                                                         //分类ID
    private String mClassificationName;                                                    //分类名

    //初始化AudioItem
    public AudioItem(Audio audio) {
        mAudio = audio;
    }

    //获取Audio
    public Audio getAudio() {
        return mAudio;
    }

    //设置分类ID
    public void setClassificationId(int classificationId) {
        mClassificationId = classificationId;
    }

    //获取分类ID
    public int getClassificationId() {
        return mClassificationId;
    }

    //设置分类名
    public void setClassificationName(String classificationName) {
        mClassificationName = classificationName;
    }

    //获取分类名
    public String getClassificationName() {
        return mClassificationName;
    }
}