package com.example.gamewithme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

public class MainActivity extends AppCompatActivity {

    ArrayList<Point> list;   //Point pos;
    ArrayList<Bitmap> imgList;

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
                    while (score <= 100) {
                        SystemClock.sleep(1000);
                        invalidate();
                    }
                }
            }.start();
        }//MyView()

        @Override
        public void draw(Canvas canvas) {
            super.draw(canvas);
            Paint paint = new Paint();
            paint.setTextSize(85);
            paint.setColor(Color.rgb(100, 100, 0));


            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int dWidth = metrics.widthPixels;
            int dHeight = metrics.heightPixels;  //note

            Random random = new Random();
            list = new ArrayList<>();
            imgList = new ArrayList<>();

            for (int i = 0; i <= 10; i++) {
                Point pos = new Point(random.nextInt(dWidth), random.nextInt(dHeight));
                list.add(pos);
            }

            for(int i = 0; i< 5; i++){
                switch(i){
                    case 0:
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pikachu);
                        bitmap = Bitmap.createScaledBitmap(bitmap, 250,250, true);
                        imgList.add(bitmap);
                        break;
                    case 1:
                        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.eevee);
                        bitmap2 = Bitmap.createScaledBitmap(bitmap2,250,250,true);
                        imgList.add(bitmap2);
                        break;
                    case 2:
                        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),R.drawable.emolga);
                        bitmap3 = Bitmap.createScaledBitmap(bitmap3,250,250,true);
                        imgList.add(bitmap3);
                        break;
                    case 3:
                        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(),R.drawable.piplup);
                        bitmap4 = Bitmap.createScaledBitmap(bitmap4,250,250,true);
                        imgList.add(bitmap4);
                        break;
                    case 4:
                        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(),R.drawable.snorlax);
                        bitmap5 = Bitmap.createScaledBitmap(bitmap5,250,250,true);

                        imgList.add(bitmap5);
                        break;
                }
            }
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.back3),0,0,null);
            canvas.drawText("score: " + score, 100, 100, paint);

            int listIdx = 0;
            boolean isPika = false;

            for (Point pos : list){
                if(isPika){
                    if(list.indexOf(pos) > imgList.size()-1){
                        listIdx = 1;
                    }else{
                        listIdx = list.indexOf(pos);
                    }
                }
//                System.out.println("listIndex" + imgList.get(0));
                canvas.drawBitmap(imgList.get(listIdx), pos.x, pos.y, paint);
                isPika = true;
            }

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
