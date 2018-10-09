package com.tcl.b2.musicplayer.util;


import com.tcl.b2.musicplayer.entity.Audio;
import com.tcl.b2.musicplayer.entity.AudioItem;

public interface AudioToAudioItem {
    AudioItem apply(Audio audio);
}