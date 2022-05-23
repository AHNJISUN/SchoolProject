package com.example.graphic_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Audio extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(this, R.raw.song1);

        final Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (switch1.isChecked() == true)
                    mPlayer.start();
                else
                    mPlayer.stop();
            }
        });
    }
}