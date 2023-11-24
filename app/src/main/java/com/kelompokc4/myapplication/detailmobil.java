package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class detailmobil extends AppCompatActivity {

    ImageButton gambarbtn;
    Button btn;
    int idMobil;

    private TextView tvkursi, tvsilinder, tvbahan_bakar, tvplat, tvwarna, tvpembuatan, tvtype;

    private void ShowData() {

        tvkursi.setText(getIntent().getStringExtra("kursi"));
        tvsilinder.setText(getIntent().getStringExtra("isi_silinder"));
        tvbahan_bakar.setText(getIntent().getStringExtra("bahan_bakar"));
        tvplat.setText(getIntent().getStringExtra("plat"));
        tvwarna.setText(getIntent().getStringExtra("warna"));
        tvpembuatan.setText(getIntent().getStringExtra("thn_produksi"));
        tvtype.setText(getIntent().getStringExtra("type"));


    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmobil);

        tvkursi = findViewById(R.id.kursi);
        tvsilinder = findViewById(R.id.silindir);
        tvbahan_bakar = findViewById(R.id.bahan_bakar);
        tvplat = findViewById(R.id.plat_mobil);
        tvwarna = findViewById(R.id.warna);
        tvpembuatan = findViewById(R.id.tahun_pembuatan);
        tvtype = findViewById(R.id.merkmobil);

        ShowData();


        // Menerima data dari Intent
        Intent receivedIntent = getIntent();
        idMobil = receivedIntent.getIntExtra("id_mobil", -1);
        Toast.makeText(this, "id " + idMobil, Toast.LENGTH_SHORT).show();
        gambarbtn = findViewById(R.id.arrowback);
        btn = findViewById(R.id.buttonBuatPesan);

        gambarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan();
            }
        });
    }

    public void pesan() {
        Intent intent = new Intent(detailmobil.this, pesanan.class);
        intent.putExtra("id_mobil", getIntent().getIntExtra("id_mobil", 1));
        startActivity(intent);
        finish();
    }
}