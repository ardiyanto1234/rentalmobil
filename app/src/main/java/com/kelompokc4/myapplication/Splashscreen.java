package com.kelompokc4.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splashscreen extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);
    }
}
