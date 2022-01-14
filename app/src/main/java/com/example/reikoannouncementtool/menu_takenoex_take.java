package com.example.reikoannouncementtool;

import android.app.Activity;
import android.content.Intent;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;

import android.media.SoundPool;
import android.os.Build;
import android.view.View;

import android.os.Bundle;

public class menu_takenoex_take extends Activity {

    int beep;
    SoundPool soundPool;

    public void play_beep(){soundPool.play(beep,1f , 1f, 0, 0, 1f);}

    MediaPlayer p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_takenoex_take);

        //beep 初期化
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        }
        else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(1)
                    .build();
        }
        beep = soundPool.load(this, R.raw.beep, 1);
    }

    public void onClick(View v) {
        play_beep();

        if (v.getId() == R.id.menu_voice){
            Intent intent = new Intent(getApplicationContext(), menu_announce.class);
            startActivity(intent);
        }

        else if(v.getId() == R.id.takenoex_take_pl_button1){
            p = MediaPlayer.create(getApplicationContext(), R.raw.an_101a0); //定義
            p.start(); //再生
        }

        else if(v.getId() == R.id.takenoex_take_pl_button2){
            p = MediaPlayer.create(getApplicationContext(), R.raw.an_101a1); //定義
            p.start(); //再生
        }

        else if(v.getId() == R.id.takenoex_take_pl_button3){
            p = MediaPlayer.create(getApplicationContext(), R.raw.an_101a2); //定義
            p.start(); //再生
        }

        else if (v.getId() == R.id.takenoex_take_one_back){
            Intent intent = new Intent(getApplicationContext(), takenoex_select.class);
            startActivity(intent);
        }
    }

    @Override//解放作業
    protected void onDestroy() {
        super.onDestroy();
        p.release();//メモリ解放
        p = null; //破棄
    }
}