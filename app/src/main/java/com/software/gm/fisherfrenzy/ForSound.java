package com.software.gm.fisherfrenzy;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

public class ForSound extends  Activity {

    public static MediaPlayer mp;

    public ForSound() {
         mp = MediaPlayer.create(this, R.raw.yellow);

    }

    public static void play(){
        mp.start();
    }
}
