package com.example.finalproject;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentPic extends Fragment {
    ImageView videoBtn,videoBtn2,videoBtn3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pic, container, false);
        videoBtn = (ImageView)view.findViewById(R.id.videoImageBtn);
        videoBtn2=(ImageView)view.findViewById(R.id.videoImageBtn2);
        videoBtn3=(ImageView)view.findViewById(R.id.videoImageBtn3);

        videoBtn.setOnClickListener(new VideoBtnClickListener("https://www.youtube.com/embed/C0b649V8jro",
                getContext(), "세탁법 동영상"));

        videoBtn2.setOnClickListener(new VideoBtnClickListener("https://www.youtube.com/embed/TTnYVeSUl9k",
                getContext(),"옷 정리 동영상"));

        videoBtn3.setOnClickListener(new VideoBtnClickListener("https://www.youtube.com/embed/WknSBlAIgdY",
                getContext(),"세탁팁 동영상"));
        return view;
    }
}
