package hifly.ac.kr.attention;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by CYSN on 2017-11-14.
 */

public class VoiceTest extends AppCompatActivity {
    private final String TAG = "KKKK";

    private Intent voiceIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        moveTaskToBack(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1001);
        }
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1002);
        voiceIntent = new Intent(getApplicationContext(), VoiceService.class);

        startService(voiceIntent);
    }



    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy!!");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG, "Voice Finish");
        stopService(voiceIntent);
        super.onBackPressed();
    }
/*
    @Override
    protected void onPause() {
        Log.i(TAG,"onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
       Log.i(TAG,"onStop");
       super.onStop();
    }*/
}
