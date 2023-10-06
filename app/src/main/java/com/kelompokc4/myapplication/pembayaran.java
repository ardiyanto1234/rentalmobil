package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pembayaran extends AppCompatActivity {

    ImageButton btn;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        btn = findViewById(R.id.btnKembalibooking);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pembayaran.this, pesanan.class));
                Toast.makeText(pembayaran.this, "Kembali", Toast.LENGTH_SHORT).show();

            }
        });
    }
}



