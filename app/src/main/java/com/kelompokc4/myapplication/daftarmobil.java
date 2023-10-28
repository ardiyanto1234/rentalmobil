package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class daftarmobil extends AppCompatActivity {

    ImageView btn;
    private Button btnpesan;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarmobil);

        btn = findViewById(R.id.btnbck);
        btnpesan = findViewById(R.id.btnpesan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daftarmobil.super.onBackPressed(); 
            }
        });

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan();
            }
        });
    }
    public void pesan(){
        Intent intent = new Intent(daftarmobil.this, detailmobil.class);
        startActivity(intent);
    }
}
