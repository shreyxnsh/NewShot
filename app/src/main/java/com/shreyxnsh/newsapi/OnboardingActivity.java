package com.shreyxnsh.newsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class OnboardingActivity extends AppCompatActivity {

    // button to navigate to main activity
    MaterialButton getStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        getStartedBtn = findViewById(R.id.getStartedBtn);

        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnboardingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}