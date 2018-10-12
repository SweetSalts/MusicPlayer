package com.tcl.b2.musicplayer.entity;

import android.os.Bundle;
import android.provider.MediaStore;
import java.io.Serializable;

//定义Audio类
public class Audio implements Serializable {
    private String mTitle;                                                    //标题
    private String mTitleKey;                                                 //标题键值，用于搜索，分类，聚簇
    private String mArtist;                                                   //艺术家
    private String mArtistKey;                                                //艺术家键值，用于搜索，分类，聚簇
    private String mAlbum;                                                    //专辑
    private String mAlbumKey;                                                 //专辑键值，用于搜索，分类，聚簇
    private String mAlbumArtist;                                              //专辑
    private String mComposer;                                                 //作曲家
    private String mPath;                                                     //播放路径
    private String mDisplayName;                                              //音频名称包括后缀名
    private String mMimeType;                                                 //音频资源媒体类型

    private int mId;
    private int mSize;                                                        //音频大小
    private int mDateAdd;
    private int mDuration;                                                    //音频时长
    private int mArtistId;                                                    //艺术家ID
    private int mAlbumId;                                                     //专辑ID
    private int mTrack;                                                       //音轨号
    private int mYear;                                                        //作曲年份

    //布尔值，用于判断音频类型，铃声，音乐，专辑，广播等
    private boolean mIsDrm;
    private boolean mIsRingtone;
    private boolean mIsMusic;
    private boolean mIsAlarm;
    private boolean mIsNotification;
    private boolean mIsPodcast;

    //根据Bundle传递的数据初始化Audio类
    public Audio(Bundle bundle) {
        mTitle = bundle.getString(MediaStore.Audio.AudioColumns.TITLE);
        mTitleKey = bundle.getString(MediaStore.Audio.AudioColumns.TITLE_KEY);
        mArtist = bundle.getString(MediaStore.Audio.AudioColumns.ARTIST);
        mArtistKey = bundle.getString(MediaStore.Audio.AudioColumns.ARTIST_KEY);
        mAlbum = bundle.getString(MediaStore.Audio.AudioColumns.ALBUM);
        mAlbumKey = bundle.getString(MediaStore.Audio.AudioColumns.ALBUM_KEY);
        mAlbumArtist = null;
        mComposer = bundle.getString(MediaStore.Audio.AudioColumns.COMPOSER);
        mPath = bundle.getString(MediaStore.Audio.AudioColumns.DATA);
        mDisplayName = bundle.getString(MediaStore.Audio.AudioColumns.DISPLAY_NAME);
        mMimeType = bundle.getString(MediaStore.Audio.AudioColumns.MIME_TYPE);

        mId = bundle.getInt(MediaStore.Audio.AudioColumns._ID);
        mSize = bundle.getInt(MediaStore.Audio.AudioColumns.SIZE);
        mDateAdd = bundle.getInt(MediaStore.Audio.AudioColumns.DATE_ADDED);
        mDuration = bundle.getInt(MediaStore.Audio.AudioColumns.DURATION);
        mArtistId = bundle.getInt(MediaStore.Audio.AudioColumns.ARTIST_ID);
        mAlbumId = bundle.getInt(MediaStore.Audio.AudioColumns.ALBUM_ID);
        mTrack = bundle.getInt(MediaStore.Audio.AudioColumns.TRACK);
        mYear = bundle.getInt(MediaStore.Audio.AudioColumns.YEAR);

        mIsDrm = bundle.getInt(MediaStore.Audio.AudioColumns.IS_ALARM) == 1;
        mIsRingtone = bundle.getInt(MediaStore.Audio.AudioColumns.IS_RINGTONE) == 1;
        mIsMusic = bundle.getInt(MediaStore.Audio.AudioColumns.IS_MUSIC) == 1;
        mIsAlarm = bundle.getInt(MediaStore.Audio.AudioColumns.IS_ALARM) == 1;
        mIsNotification = bundle.getInt(MediaStore.Audio.AudioColumns.IS_NOTIFICATION) == 1;
        mIsPodcast = bundle.getInt(MediaStore.Audio.AudioColumns.IS_PODCAST) == 1;
    }

    //用于获取标题
    public String getTitle() {
        return mTitle;
    }

    public String getTitleKey() {
        return mTitleKey;
    }
    //用于获取艺术家
    public String getArtist() {
        return mArtist;
    }

    public String getArtistKey() {
        return mArtistKey;
    }
    //用于获取专辑
    public String getAlbum() {
        return mAlbum;
    }

    public String getAlbumKey() {
        return mAlbumKey;
    }

    public String getAlbumArtist() {
        return mAlbumArtist;
    }

    public String getComposer() {
        return mComposer;
    }
    //用于获取路径
    public String getPath() {
        return mPath;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public String getMimeType() {
        return mMimeType;
    }
    //用于获取ID
    public int getId() {
        return mId;
    }
    //用于获取大小
    public int getSize() {
        return mSize;
    }

    public int getDateAdd() {
        return mDateAdd;
    }
    //用于获取时长
    public int getDuration() {
        return mDuration;
    }
    //用于获取艺术家ID
    public int getArtistId() {
        return mArtistId;
    }
    //用于获取专辑ID
    public int getAlbumId() {
        return mAlbumId;
    }
    //用于获取音轨号
    public int getTrack() {
        return mTrack;
    }

    public int getYear() {
        return mYear;
    }

    public boolean isDrm() {
        return mIsDrm;
    }

    public boolean isRingtone() {
        return mIsRingtone;
    }
    //用于获取是否为音乐类型
    public boolean isMusic() {
        return mIsMusic;
    }

    public boolean isAlarm() {
        return mIsAlarm;
    }

    public boolean isNotification() {
        return mIsNotification;
    }

    public boolean isPodcast() {
        return mIsPodcast;
    }
}