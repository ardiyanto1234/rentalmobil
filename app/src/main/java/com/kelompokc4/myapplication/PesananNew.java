package com.kelompokc4.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class PesananNew extends AppCompatActivity {

    MaterialButton btnimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_new);

        btnimg = findViewById(R.id.pesan_button);
        Toast.makeText(getApplicationContext(), "cek", Toast.LENGTH_SHORT).show();

        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "button diclik", Toast.LENGTH_SHORT).show();
                PesananNew.super.onBackPressed();
            }
        });
    }
}