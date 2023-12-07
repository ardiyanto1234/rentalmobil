package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Konfirmasi_ulasan extends AppCompatActivity {

    private Button btnSelesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_ulasan);

        btnSelesai = findViewById(R.id.buttonSelesai);

            btnSelesai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Selesai();
                }
            });

    }

    private void Selesai() {
        Intent intent = new Intent(Konfirmasi_ulasan.this, home.class);
        startActivity(intent);
    }
}
