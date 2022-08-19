package com.software.gm.fisherfrenzy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.view.MotionEvent;
import android.view.View;

public class FlyingFishView extends View {

    //static Forsound s;

    Intent intent = new Intent(getContext(), GameOverActivity.class);

    private int yellowX, yellowY, yellowSpeed = 16;
    private Paint yellowPaint = new Paint();
    private int yellowX1, yellowY1, yellowSpeed1 = 19;
    private Paint yellowPaint1 = new Paint();
    private int yellowX11, yellowY11, yellowSpeed11 = 22;
    private Paint yellowPaint11 = new Paint();
    private int yellowX2, yellowY2, yellowSpeed2 = 26;
    private Paint yellowPaint2 = new Paint();
    private int yellowX3, yellowY3, yellowSpeed3 = 39;
    private Paint yellowPaint3 = new Paint();
    private int yellowX4, yellowY4, yellowSpeed4 = 20;
    private Paint yellowPaint4 = new Paint();
    private int yellowXf, yellowYf, yellowSpeedf = 10;
    private int yellowXf2, yellowYf2, yellowSpeedf2 = 12;
    private int yellowXf3, yellowYf3, yellowSpeedf3 = 14;
    private int yellowXf4, yellowYf4, yellowSpeedf$ = 16;
    private int yellowXf5, yellowYf5, yellowSpeedf5 = 18;


    private Bitmap fish[] = new Bitmap[2];
    private int fishX = 10;
    private int fishY, fishSpeed, canvasWidth, canvasHeight;

    Boolean touch = false;

    private int score, lifeCounterOfFish;
    private Bitmap backgroundImage;
    private Bitmap pub;
    private Paint scorePaint = new Paint();
    private Bitmap life[] = new Bitmap[2];

    public FlyingFishView(Context context) {
        super(context);

        //s = new Forsound();

        fish[0] = BitmapFactory.decodeResource(getResources(), R.drawable.jnjkjnkjnknk);
        fish[1] = BitmapFactory.decodeResource(getResources(), R.drawable.fish0);

        backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
        pub = BitmapFactory.decodeResource(getResources(), R.drawable.finalbub);


        yellowPaint.setColor(Color.YELLOW);
        yellowPaint.setAntiAlias(false);

        yellowPaint11.setColor(Color.YELLOW);
        yellowPaint11.setAntiAlias(false);

        yellowPaint1.setColor(Color.YELLOW);
        yellowPaint1.setAntiAlias(false);

        yellowPaint2.setColor(Color.GREEN);
        yellowPaint2.setAntiAlias(false);

        yellowPaint3.setColor(Color.RED);
        yellowPaint3.setAntiAlias(false);

        yellowPaint4.setColor(Color.RED);
        yellowPaint4.setAntiAlias(false);

        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setAntiAlias(true);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);

        fishY = 550;
        lifeCounterOfFish = 3;

        score = 0;

        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.hearts);
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.heartgrey);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(backgroundImage, 0, 0, null);

        int minFishY = fish[0].getHeight();
        int maxFishY = canvasHeight - fish[0].getHeight();


        int minFishX = fish[0].getWidth();
        int maxFishX = canvasWidth - fish[0].getWidth();

        fishY = fishY + fishSpeed;

        if (fishY < minFishY) {
            fishY = minFishY;
        }

        if (fishY > maxFishY) {
            fishY = maxFishY;
        }
        fishSpeed = fishSpeed + 2;

        if (touch) {
            canvas.drawBitmap(fish[1], fishX, fishY, null);
            touch = false;
        } else {
            canvas.drawBitmap(fish[0], fishX, fishY, null);
        }

        yellowX = yellowX - yellowSpeed;

        if (hitBallChecker(yellowX, yellowY)) {
            score = score + 10;
            yellowX = -100;
            //s.play();
        }
        if (yellowX < 0) {
            yellowX = canvasWidth + 21;
            yellowY = (int) Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;
        }
        canvas.drawCircle(yellowX, yellowY, 20, yellowPaint);

        yellowYf = yellowYf - yellowSpeedf;

        if (yellowYf < 0) {
            yellowYf = canvasHeight + 21;
            yellowXf = (int) Math.floor(Math.random() * (maxFishX - minFishX)) + minFishX;
        }
        if (yellowYf == 300) {
            yellowYf = 1;
        }//!!!!!!!!!!##############################!!!!!!!!!!!!!
        canvas.drawBitmap(pub, yellowXf, yellowYf, null);

        yellowYf2 = yellowYf2 - yellowSpeedf2;

        if (yellowYf2 < 0) {
            yellowYf2 = canvasHeight + 21;
            yellowXf2 = (int) Math.floor(Math.random() * (maxFishX - minFishX)) + minFishX;
        }
        if (yellowYf2 == 300) {
            yellowYf2 = 1;
        }//!!!!!!!!!!##############################!!!!!!!!!!!!!
        canvas.drawBitmap(pub, yellowXf2, yellowYf2, null);

        yellowYf4 = yellowYf4 - yellowSpeedf$;

        if (yellowYf4 < 0) {
            yellowYf4 = canvasHeight + 21;
            yellowXf4 = (int) Math.floor(Math.random() * (maxFishX - minFishX)) + minFishX;
        }
        if (yellowYf4 == 300) {
            yellowYf4 = 1;
        }//!!!!!!!!!!##################4############!!!!!!!!!!!!!
        canvas.drawBitmap(pub, yellowXf4, yellowYf4, null);

        yellowYf5 = yellowYf5 - yellowSpeedf5;

        if (yellowYf5 < 0) {
            yellowYf5 = canvasHeight + 21;
            yellowXf5 = (int) Math.floor(Math.random() * (maxFishX - minFishX)) + minFishX;
        }
        if (yellowYf5 == 300) {
            yellowYf5 = 1;
        }//!!!!!!!!!!##############################!!!!!!!!!!!!!
        canvas.drawBitmap(pub, yellowXf5, yellowYf5, null);

        yellowYf3 = yellowYf3 - yellowSpeedf3;

        if (yellowYf3 < 0) {
            yellowYf3 = canvasHeight + 21;
            yellowXf3 = (int) Math.floor(Math.random() * (maxFishX - minFishX)) + minFishX;
        }
        if (yellowYf3 == 300) {
            yellowYf3 = 1;
        }//!!!!!!!!!!##############################!!!!!!!!!!!!!
        canvas.drawBitmap(pub, yellowXf3, yellowYf3, null);

        yellowX1 = yellowX1 - yellowSpeed1;

        if (hitBallChecker(yellowX1, yellowY1)) {
            score = score + 10;
            yellowX1 = -100;
            //s.play();
        }
        if (yellowX1 < 0) {
            yellowX1 = canvasWidth + 21;
            yellowY1 = (int) Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;
        }
        canvas.drawCircle(yellowX1, yellowY1, 20, yellowPaint1);

        yellowX11 = yellowX11 - yellowSpeed11;

        if (hitBallChecker(yellowX11, yellowY11)) {
            score = score + 10;
            yellowX11 = -100;
            //s.play();
        }
        if (yellowX11 < 0) {
            yellowX11 = canvasWidth + 21;
            yellowY11 = (int) Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;
        }
        canvas.drawCircle(yellowX11, yellowY11, 20, yellowPaint11);

        yellowX2 = yellowX2 - yellowSpeed2;

        if (hitBallChecker(yellowX2, yellowY2)) {
            score = score + 30;
            yellowX2 = -100;
        }
        if (yellowX2 < 0) {
            yellowX2 = canvasWidth + 21;
            yellowY2 = (int) Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;
        }
        canvas.drawCircle(yellowX2, yellowY2, 30, yellowPaint2);

        yellowX3 = yellowX3 - yellowSpeed3;

        if (hitBallChecker(yellowX3, yellowY3)) {    //red
            lifeCounterOfFish--;
            yellowX3 = -100;
            if (lifeCounterOfFish == 0) {
                /* ************ MAKE INTENT *********** */
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("score", score);
                getContext().startActivity(intent);

            }
        }
        if (yellowX3 < 0) {
            yellowX3 = canvasWidth + 21;
            yellowY3 = (int) Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;
        }
        canvas.drawCircle(yellowX3, yellowY3, 20, yellowPaint3);

        yellowX4 = yellowX4 - yellowSpeed4;

        if (hitBallChecker(yellowX4, yellowY4)) {    //red
            lifeCounterOfFish--;
            yellowX4 = -100;
            if (lifeCounterOfFish == 0) {
                /* ************ MAKE INTENT *********** */
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("score", score);
                getContext().startActivity(intent);

            }
        }
        if (yellowX4 < 0) {
            yellowX4 = canvasWidth + 21;
            yellowY4 = (int) Math.floor(Math.random() * (maxFishY - minFishY)) + minFishY;
        }
        canvas.drawCircle(yellowX4, yellowY4, 20, yellowPaint4);


        canvas.drawText("Score: " + score, 20, 60, scorePaint);

        for (int i = 0; i < 3; i++) {
            int x = (int) (580 + life[0].getWidth() * 1.5 * i);
            int y = 30;

            if (i < lifeCounterOfFish) {
                canvas.drawBitmap(life[0], x, y, null);
            } else {
                canvas.drawBitmap(life[1], x, y, null);
            }
        }

    }

    public boolean hitBallChecker(int x, int y) {
        if (fishX < x && x < (fishX + fish[0].getWidth()) && fishY < y && y < (fishY + fish[0].getHeight())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
                touch = true;


            fishSpeed = -22;
        }
        return true;
    }


}
