package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class detailmobilkursi4 extends AppCompatActivity {

    ImageView btnback;
    Button btnpesan;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarmobilkursi4);

        btnback = findViewById(R.id.btnbck);
        btnpesan = findViewById(R.id.btnpesan);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan();
            }
        });
    }
        public void pesan() {
            Intent intent = new Intent(detailmobilkursi4.this, daftarmobil.class);
            startActivity(intent);
    }
        public void kembali() {
            Intent intent = new Intent(detailmobilkursi4.this, home.class);
            startActivity(intent);
    }
}