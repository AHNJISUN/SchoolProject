package com.example.graphic_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class DonutGame extends AppCompatActivity {

    ArrayList<Point> list;   //Point pos;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    private class MyView extends View {
        public MyView(Context context) {
            super(context);
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (score <= 20) {
                        SystemClock.sleep(2000);
                        invalidate();
                    }
                }
            }.start();
        }//MyView()

        @Override
        public void draw(Canvas canvas) {
            super.draw(canvas);
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.rgb(100, 100, 0));

            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int dWidth = metrics.widthPixels;
            int dHeight = metrics.heightPixels;  //note

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.donut1);
            bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, true);

            Random random = new Random();
            list = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Point pos = new Point(random.nextInt(dWidth), random.nextInt(dHeight));
                list.add(pos);
            }

            canvas.drawText("score: " + score, 100, 100, paint);
            for (Point pos : list)
                canvas.drawBitmap(bitmap, pos.x, pos.y, paint);


        }//draw()

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    for (Point pos : list) {
                        if ((event.getX() >= pos.x && event.getX() <= pos.x + 200)
                                && (event.getY() >= pos.y && event.getY() <= pos.y + 200)) {
                            score++;
                        }
                    }
                    break;
                default:
                    break;
            }
            return true;
        }//onTouchEvent()
    }//MyView class
}
