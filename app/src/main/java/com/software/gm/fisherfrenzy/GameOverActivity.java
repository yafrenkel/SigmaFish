package com.software.gm.fisherfrenzy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends Activity {

    private Button StartGameAgain;
    private TextView dispsc;
    private String st;
    private TextView txtForHighestScore;


    public static final String SHARED_PREFS = "sharedPrefs";

    Animation togo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        st = getIntent().getExtras().get("score").toString();
        togo = AnimationUtils.loadAnimation(this,R.anim.togo);

        /////////////////////////////////////////SHARED_PREFS///////////////////////////////////////
        txtForHighestScore = findViewById(R.id.txtForHighestScore);

        int i = Integer.parseInt(st);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (i> sharedPreferences.getInt("score",0)){
            editor.putInt("score",i);
            editor.apply();
        }


        txtForHighestScore.setText("Highest Score: " + sharedPreferences.getInt("score", 0));
        /////////////////////////////////////////SHARED_PREFS///////////////////////////////////////

        StartGameAgain = (Button) findViewById(R.id.play_again_btn);

        dispsc = (TextView) findViewById(R.id.score2);
        dispsc.startAnimation(togo);

        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });
        dispsc.setText("Score: " + st);
    }
}
