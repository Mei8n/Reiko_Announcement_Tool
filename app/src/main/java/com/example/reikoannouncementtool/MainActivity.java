package com.example.reikoannouncementtool;

import android.app.Activity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.media.AudioAttributes;

public class MainActivity extends Activity {

    int beep;
    SoundPool soundPool;

    public void play_beep(){soundPool.play(beep,1f , 1f, 0, 0, 1f);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        if (v.getId() == R.id.button11) {
            Intent intent = new Intent(getApplicationContext(), takenoexp_select.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.button12) {
            Intent intent = new Intent(getApplicationContext(), takeno_select.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.button35) {
            Intent intent = new Intent(getApplicationContext(), activity_main_2page.class);
            startActivity(intent);
        }
    }
}