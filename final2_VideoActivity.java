package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    Button backBtn;
    WebView webView;
    TextView tv;
    FragmentPic pic;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        backBtn = (Button) findViewById(R.id.button);
        webView = (WebView) findViewById(R.id.webView);
        tv = (TextView) findViewById(R.id.videoTitle);
        Intent intent = getIntent();
        String url = intent.getExtras().getString("url");
        String frameVideo = "<html><body><iframe width=\"420\" height=\"315\" src='" +url+ "'frameborder=\"0\" allowfullscreen></iframe></body></html>";

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.webView);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");


        String title = intent.getExtras().getString("title");
        tv.setText(title);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.container,pic);
                ft.commit();
            }
        });
    }
}
