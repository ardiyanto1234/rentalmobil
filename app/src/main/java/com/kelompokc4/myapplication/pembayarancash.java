package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class pembayarancash extends AppCompatActivity {

    ImageButton btn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayarancash);

        btn = findViewById(R.id.btnKembalibooking);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pembayarancash.this, pesanan.class));
                Toast.makeText(pembayarancash.this, "Kembali", Toast.LENGTH_SHORT).show();

            }
        });
    }
    }