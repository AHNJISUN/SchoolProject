package com.example.graphic_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreadCount extends AppCompatActivity {

    int val = 0;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_count);

        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyThread myThread = new MyThread();
                myThread.start();
            }
        });
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                SystemClock.sleep(1000);
                val++;
                //tv.setText(" counter\n\n" + val);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(" counter\n\n" + val);
                    }
                });
            }
        }
    }
}