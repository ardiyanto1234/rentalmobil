package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class KonfirmasiPeasanan extends AppCompatActivity {

    ImageButton btnback;
    Button btnselesai;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_peasanan);

        btnback = findViewById(R.id.btnKembaliPesan);
        btnselesai = findViewById(R.id.btnSelesai);

        btnselesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selesai();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kembali();
            }
        });
    }
    public void kembali() {
        Intent intent = new Intent(KonfirmasiPeasanan.this, pesanan.class);
        startActivity(intent);
    }
        public void selesai() {
            Intent intent = new Intent(KonfirmasiPeasanan.this, daftarmobil.class);
            startActivity(intent);

    }
}