package com.example.wseemann.listexample;

import android.os.Message;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Handler imageHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            HandlerHolder handlerHolder = (HandlerHolder) msg.obj;

            RoundedBitmapDrawable roundedBitmapDrawable =
                    RoundedBitmapDrawableFactory.create(getResources(), handlerHolder.bitmap);
            roundedBitmapDrawable.setCornerRadius(Math.max(handlerHolder.bitmap.getWidth(), handlerHolder.bitmap.getHeight()) / 2.0f);

            ImageView imageView = handlerHolder.imageView;
            imageView.setImageDrawable(roundedBitmapDrawable);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(android.R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> items = Arrays.asList("http://98.212.85.121:53042/A Day to Remember/Homesick/01 - The Downfall Of Us All.mp3",
                "http://98.212.85.121:53042/American Me/Siberian Nightmare Machine/04 - Die Faster.mp3",
                "http://98.212.85.121:53042/Ben Weasel/These Ones Are Bitter/01_-_Let_Freedom_Ring.mp3",
                "http://98.212.85.121:53042/A Day to Remember/Homesick/01 - The Downfall Of Us All.mp3",
                "http://98.212.85.121:53042/American Me/Siberian Nightmare Machine/04 - Die Faster.mp3",
                "http://98.212.85.121:53042/Ben Weasel/These Ones Are Bitter/01_-_Let_Freedom_Ring.mp3",
                "http://98.212.85.121:53042/A Day to Remember/Homesick/01 - The Downfall Of Us All.mp3",
                "http://98.212.85.121:53042/American Me/Siberian Nightmare Machine/04 - Die Faster.mp3",
                "http://98.212.85.121:53042/Ben Weasel/These Ones Are Bitter/01_-_Let_Freedom_Ring.mp3",
                "http://98.212.85.121:53042/A Day to Remember/Homesick/01 - The Downfall Of Us All.mp3",
                "http://98.212.85.121:53042/American Me/Siberian Nightmare Machine/04 - Die Faster.mp3",
                "http://98.212.85.121:53042/Ben Weasel/These Ones Are Bitter/01_-_Let_Freedom_Ring.mp3",
                "http://98.212.85.121:53042/A Day to Remember/Homesick/01 - The Downfall Of Us All.mp3",
                "http://98.212.85.121:53042/American Me/Siberian Nightmare Machine/04 - Die Faster.mp3",
                "http://98.212.85.121:53042/Ben Weasel/These Ones Are Bitter/01_-_Let_Freedom_Ring.mp3");

        recyclerView.setAdapter(new RecyclerAdapter(items, imageHandler));
    }
}
