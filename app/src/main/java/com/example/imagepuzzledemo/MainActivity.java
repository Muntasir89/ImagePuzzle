package com.example.imagepuzzledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button PLAY, rate_us_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Background animation
        RelativeLayout relativeLayout = findViewById(R.id.main_page);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        //Initialize btn
        PLAY = findViewById(R.id.play);
        rate_us_btn = findViewById(R.id.rate_us_btn);
        //Setting onClicActionListener
        PLAY.setOnClickListener(this);
        rate_us_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.play){
            Intent i = new Intent(this, ChooseImage.class);
            startActivity(i);
        }else if(v.getId()==R.id.rate_us_btn){

        }
    }
}