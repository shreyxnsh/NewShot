package com.shreyxnsh.newsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    // splash screen timer
    private static int splash_timer = 4000;

    ImageView appIcon;
    TextView appName;
    Animation bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        appIcon = findViewById(R.id.appIcon);
        appName = findViewById(R.id.appName);

        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        // animation
        appIcon.setAnimation(bottomAnim);
        appName.setAnimation(bottomAnim);

        // navigate on onboarding screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, OnboardingActivity.class);
                startActivity(intent);
            }
        }, splash_timer);

    }
}