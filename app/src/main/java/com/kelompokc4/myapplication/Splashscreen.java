package com.kelompokc4.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splashscreen extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        SharedPreferences sharedPreferences = this.getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        String id_user = sharedPreferences.getString("username", "");
        Toast.makeText(this, "Selamat Datang "+id_user, Toast.LENGTH_SHORT).show();

        if (!id_user.isEmpty()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Pindah ke activity berikutnya setelah tampilan splash selesai
                    Intent mainIntent1 = new Intent(getApplicationContext(), Dasboard.class);
                    startActivity(mainIntent1);


                }
            }, 3000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Pindah ke activity berikutnya setelah tampilan splash selesai
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainIntent);


                }
            }, 3000);
        }
    }

}