package com.software.gm.fisherfrenzy;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity implements GestureDetector.OnGestureListener {

    GestureDetectorCompat gestureDetectorCompat;
    Animation togo, toin, toout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        togo = AnimationUtils.loadAnimation(this,R.anim.togo);
        toin = AnimationUtils.loadAnimation(this,R.anim.toin);
        toout = AnimationUtils.loadAnimation(this,R.anim.toout);

        gestureDetectorCompat = new GestureDetectorCompat(this,this);

        /*Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
            try{
                sleep(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
            }
        };
        thread.start();*/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Intent intent1 = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent1);
        overridePendingTransition(R.anim.toout, R.anim.toin);

        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
