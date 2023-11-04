package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class pesanan extends AppCompatActivity {

    ImageButton btnback;
    EditText Nama, Alamat, Notlp, tglLahir;

    Button jam12, jam24, hari2, pesan ;
    boolean isJam12Hidden = false;
    boolean isJam24Hidden = false;
    boolean isHari2Hidden = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        jam12 = findViewById(R.id.jam12);
        jam24 = findViewById(R.id.jam24);
        hari2 = findViewById(R.id.hari2);

        btnback = findViewById(R.id.btnKembaliDetail);

        jam12.setOnClickListener(v -> {
                isJam24Hidden = hideButton(jam24, isJam24Hidden);
                isHari2Hidden = hideButton(hari2, isHari2Hidden);
        });

        jam24.setOnClickListener(v -> {
                isJam12Hidden = hideButton(jam12, isJam12Hidden);
                isHari2Hidden = hideButton(hari2, isHari2Hidden);
        });

        hari2.setOnClickListener(v -> {
                isJam12Hidden = hideButton(jam12, isJam12Hidden);
                isJam24Hidden = hideButton(jam24, isJam24Hidden);
        });






        btnback.setOnClickListener(v->{
                onBackPressed();
        });
    }

    public void kembali() {
        Intent intent = new Intent(pesanan.this, detailmobil.class);
        startActivity(intent);

    }
    private boolean hideButton(Button button, boolean isHidden) {
        if (isHidden) {
            button.setEnabled(true);
            button.setVisibility(View.VISIBLE);
        }else{
            button.setEnabled(false);
            button.setVisibility(View.INVISIBLE);
        }
//        Toast.makeText(this, String.valueOf(isHidden), Toast.LENGTH_SHORT).show();

        return !isHidden;
    }
}







