package com.kelompokc4.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class pesanan extends AppCompatActivity {

    MaterialButton btnimg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        btnimg = findViewById(R.id.btnback);
        Toast.makeText(getApplicationContext(), "cek", Toast.LENGTH_SHORT).show();

        btnimg.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "button", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        });
    }

    public void lanjut() {
        super.onBackPressed();
    }
}
