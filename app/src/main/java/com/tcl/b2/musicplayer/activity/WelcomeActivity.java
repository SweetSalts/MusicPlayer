package com.tcl.b2.musicplayer.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.tcl.b2.musicplayer.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private static String[] permissionArray = new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
    };
    private static final int PERMISSION_REQUEST_CODE = 1;

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
        // 权限分配
        List<String> requestList = new ArrayList<>();

        for (String permission : permissionArray) {
            if (ActivityCompat.checkSelfPermission(this, permission)
                    != PermissionChecker.PERMISSION_GRANTED) {
                requestList.add(permission);
            }
        }

        if (requestList.size() > 0) {
            ActivityCompat.requestPermissions(this, requestList.toArray(new String[] {}),
                    PERMISSION_REQUEST_CODE);
        } else {
            handler.sendEmptyMessageDelayed(0,3000);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                boolean good = true;
                for (int i = 0; i < permissions.length; ++i) {
                    if (grantResults[i] != PermissionChecker.PERMISSION_GRANTED) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WelcomeActivity.this);
                        builder.setTitle("提示").setMessage("不允许读取SD卡权限则无法正常使用哦")
                                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        WelcomeActivity.super.finish();
                                    }
                                }).show();
                        good = false;
                        break;
                    }
                }
                if (good) {
                    handler.sendEmptyMessageDelayed(0,3000);
                }
                break;
        }
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
