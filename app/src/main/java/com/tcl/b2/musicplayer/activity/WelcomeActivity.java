package com.tcl.b2.musicplayer.activity;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.tcl.b2.musicplayer.R;

import java.io.File;

public class WelcomeActivity extends AppCompatActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            scanMusic();
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        handler.sendEmptyMessageDelayed(0,3000);
    }

    private void scanMusic(){
        File musicDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath());
        final File[] toBeScannedMusicFiles = musicDir.listFiles();
        if(toBeScannedMusicFiles != null){
            String[] toBeScanerMusicPath = new String[toBeScannedMusicFiles.length];
            for(int i = 0; i < toBeScannedMusicFiles.length; i++){
                toBeScanerMusicPath[i] = toBeScannedMusicFiles[i].getAbsolutePath();
            }
            MediaScannerConnection.scanFile(WelcomeActivity.this,
                    toBeScanerMusicPath, null, new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String s, Uri uri) {
                            Intent intent = new Intent(WelcomeActivity.this, ListActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
        }
    }
}
