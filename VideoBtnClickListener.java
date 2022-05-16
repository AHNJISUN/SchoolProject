package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

public class VideoBtnClickListener implements View.OnClickListener {
    protected String url, title;
    protected Context ctx;


    public VideoBtnClickListener(String url, Context ctx, String title){
        this.url = url;
        this.ctx = ctx;
        this.title = title;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this.ctx, VideoActivity.class);
        intent.putExtra("url", this.url);
        intent.putExtra("title", this.title);


        view.getContext().startActivity(intent);
    }
}
