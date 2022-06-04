package com.example.finalproj_2022_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.provider.ContactsContract;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;


public class GameFragment extends Fragment {

    ArrayList<Point> list;
    int score = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = new MyView(getContext());

        return view;
    }
    private class MyView extends View{
        public MyView(Context context){
            super(context);
            new Thread(){
                @Override
                public void run(){
                    super.run();
                    while (score<=20){
                        SystemClock.sleep(2000);
                        invalidate();
                    }
                }
            }.start();
        }
        @Override
        public void draw(Canvas canvas){
            super.draw(canvas);
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.rgb(100, 100, 0));

            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int dWidth = metrics.widthPixels;
            int dHeight = metrics.heightPixels;

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.donut1);
            bitmap = Bitmap.createScaledBitmap(bitmap,200,200,true);

            Random random = new Random();
            list = new ArrayList<>();

            for(int i=0;i<10;i++){
                Point pos = new Point(random.nextInt(dWidth),random.nextInt(dHeight));
                list.add(pos);
            }
            canvas.drawText("score : "+score,100,100,paint);
            for(Point pos:list)
                canvas.drawBitmap(bitmap,pos.x,pos.y,paint);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    for(Point pos:list){
                        if((event.getX()>=pos.x && event.getX() <= pos.x+200)
                        && (event.getY()>=pos.y && event.getY() <= pos.y+200)){
                            score++;
                        }
                    }
                    break;
                default:
                    break;
            }
            return true;
        }
    }
}