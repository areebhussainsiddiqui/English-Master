package com.cognitive.englishmaster.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.cognitive.englishmaster.R;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_TIMEOUT = 2000;

    @Override
    protected void onStart() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_TIMEOUT);
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    }
}
