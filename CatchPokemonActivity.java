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

    ArrayList<Point> list;
    ArrayList<Bitmap> imgList;
    Bitmap bitAns;
    Point posAns;
    boolean isPika = false;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    private class MyView extends View {
        public MyView(Context context) {
            super(context);
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (score <= 10000) {
                        SystemClock.sleep(3000);
                        invalidate();
                    }
                }
            }.start();
        }

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


            for (int i = 0; i <= 20; i++) {
                Point pos = new Point(random.nextInt(dWidth), random.nextInt(dHeight));
                list.add(pos);
            }

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pikachu);
            bitmap = Bitmap.createScaledBitmap(bitmap, 300,300, true);
            imgList.add(bitmap);
            bitAns = bitmap;
            
            Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.eevee);
            bitmap2 = Bitmap.createScaledBitmap(bitmap2,250,250,true);
            imgList.add(bitmap2);

            Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),R.drawable.emolga);
            bitmap3 = Bitmap.createScaledBitmap(bitmap3,300,300,true);
            imgList.add(bitmap3);

            Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(),R.drawable.piplup);
            bitmap4 = Bitmap.createScaledBitmap(bitmap4,300,300,true);
            imgList.add(bitmap4);
            
            Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(),R.drawable.snorlax);
            bitmap5 = Bitmap.createScaledBitmap(bitmap5,250,250,true);
            imgList.add(bitmap5);

            Bitmap bitmap6 = BitmapFactory.decodeResource(getResources(),R.drawable.eevee);
            bitmap6 = Bitmap.createScaledBitmap(bitmap6,250,250,true);
            imgList.add(bitmap6);
            
            Bitmap bitmap7 = BitmapFactory.decodeResource(getResources(),R.drawable.emolga);
            bitmap7 = Bitmap.createScaledBitmap(bitmap7,300,300,true);
            imgList.add(bitmap7);
            
            Bitmap bitmap8 = BitmapFactory.decodeResource(getResources(),R.drawable.piplup);
            bitmap8 = Bitmap.createScaledBitmap(bitmap8,300,300,true);
            imgList.add(bitmap8);
            
            Bitmap bitmap9 = BitmapFactory.decodeResource(getResources(),R.drawable.snorlax);
            bitmap9 = Bitmap.createScaledBitmap(bitmap9,250,250,true);
            imgList.add(bitmap9);

            Bitmap bitmap10 = BitmapFactory.decodeResource(getResources(),R.drawable.eevee);
            bitmap10 = Bitmap.createScaledBitmap(bitmap10,250,250,true);
            imgList.add(bitmap10);

            Bitmap bitmap11 = BitmapFactory.decodeResource(getResources(),R.drawable.emolga);
            bitmap11 = Bitmap.createScaledBitmap(bitmap11,300,300,true);
            imgList.add(bitmap11);

            Bitmap bitmap12 = BitmapFactory.decodeResource(getResources(),R.drawable.piplup);
            bitmap12 = Bitmap.createScaledBitmap(bitmap12,300,300,true);
            imgList.add(bitmap12);

            Bitmap bitmap13 = BitmapFactory.decodeResource(getResources(),R.drawable.snorlax);
            bitmap13 = Bitmap.createScaledBitmap(bitmap13,250,250,true);
            imgList.add(bitmap13);

            Bitmap bitmap14 = BitmapFactory.decodeResource(getResources(),R.drawable.eevee);
            bitmap14 = Bitmap.createScaledBitmap(bitmap14,250,250,true);
            imgList.add(bitmap14);

            Bitmap bitmap15 = BitmapFactory.decodeResource(getResources(),R.drawable.emolga);
            bitmap15 = Bitmap.createScaledBitmap(bitmap15,300,300,true);
            imgList.add(bitmap15);

            Bitmap bitmap16 = BitmapFactory.decodeResource(getResources(),R.drawable.piplup);
            bitmap16 = Bitmap.createScaledBitmap(bitmap16,300,300,true);
            imgList.add(bitmap16);

            Bitmap bitmap17 = BitmapFactory.decodeResource(getResources(),R.drawable.snorlax);
            bitmap17 = Bitmap.createScaledBitmap(bitmap17, 250,250,true);
            imgList.add(bitmap17);

            Bitmap bitmap18 = BitmapFactory.decodeResource(getResources(),R.drawable.emolga);
            bitmap18 = Bitmap.createScaledBitmap(bitmap18,300,300,true);
            imgList.add(bitmap18);

            Bitmap bitmap19 = BitmapFactory.decodeResource(getResources(),R.drawable.piplup);
            bitmap19 = Bitmap.createScaledBitmap(bitmap19,300,300,true);
            imgList.add(bitmap19);

            Bitmap bitmap20 = BitmapFactory.decodeResource(getResources(),R.drawable.snorlax);
            bitmap20 = Bitmap.createScaledBitmap(bitmap20, 250,250,true);
            imgList.add(bitmap20);
            
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.back3),0,0,null);
            canvas.drawText("score: " + score, 100, 100, paint);



            int listIdx=0;

            for (Point pos : list){
                if(isPika) listIdx = random.nextInt(20);
                else listIdx = 0;
                if(listIdx == 0) posAns = pos;

                canvas.drawBitmap(imgList.get(listIdx), pos.x, pos.y, paint);
                isPika = true;
            }

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if ((event.getX() >= posAns.x && event.getX() <= posAns.x + 200)
                            && (event.getY() >= posAns.y && event.getY() <= posAns.y + 200)) {
                        score = score+100;
                        isPika = false;
                    }

                    break;
                default:
                    break;
            }
            return true;
        }
    }
}
