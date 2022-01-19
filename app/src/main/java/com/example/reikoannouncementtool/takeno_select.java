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

public class takeno_select extends Activity {

    int beep;
    SoundPool soundPool;

    public void play_beep(){soundPool.play(beep,1f , 1f, 0, 0, 1f);}

    MediaPlayer p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeno_select);

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

        if (v.getId() == R.id.takeno_select_1){
            Intent intent = new Intent(getApplicationContext(), menu_takeno_take.class);
            startActivity(intent);
        }

        else if(v.getId() == R.id.takeno_select_2){
            Intent intent = new Intent(getApplicationContext(), menu_takeno_yaobase.class);
            startActivity(intent);
        }

        else if(v.getId() == R.id.takeno_select_3){
            Intent intent = new Intent(getApplicationContext(), menu_takeno_yaobs.class);
            startActivity(intent);
        }

        else if(v.getId() == R.id.takeno_one_back){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}