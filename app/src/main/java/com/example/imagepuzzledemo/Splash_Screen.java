package com.example.imagepuzzledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_Screen extends AppCompatActivity {
    Animation left, right, down;
    ImageView imageLeft, imageRight, imageDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        //Initialize ImageView
        imageLeft = findViewById(R.id.splash_screen_left);
        imageRight = findViewById(R.id.splash_screen_right);
        imageDown = findViewById(R.id.splash_screen_down);
        //Initialize Animation
        left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);
        right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);
        down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down);
        //Setting Animation
        imageLeft.setAnimation(left);
        imageRight.setAnimation(right);
        imageDown.setAnimation(down);
        //Setting splash Screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3500);


    }
}