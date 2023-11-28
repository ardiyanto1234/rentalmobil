package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.squareup.picasso.Picasso;

public class detailmobil extends AppCompatActivity {

    ImageButton gambarbtn;
    Button btn;
    int idMobil;
    ImageView gambar_mobil;
    private String imgurl = "kosong";
    private TextView tvkursi, tvsilinder, tvbahan_bakar, tvplat, tvwarna, tvpembuatan, tvtype;

    // ...

    private void ShowData() {
        tvkursi.setText(getIntent().getStringExtra("kursi"));
        tvsilinder.setText(getIntent().getStringExtra("isi_silinder"));
        tvbahan_bakar.setText(getIntent().getStringExtra("bahan_bakar"));
        tvplat.setText(getIntent().getStringExtra("plat"));
        tvwarna.setText(getIntent().getStringExtra("warna"));
        tvpembuatan.setText(getIntent().getStringExtra("thn_produksi"));
        tvtype.setText(getIntent().getStringExtra("type"));
        imgurl = getIntent().getStringExtra("gambar_mobil");

        // Menggunakan Glide untuk memuat gambar dari URL
        gambar_mobil = findViewById(R.id.gambarmobildetail);

        if (imgurl != null) {
            Glide.with(getApplicationContext())
                    .load(RetrofitClient.BASE_URL  + imgurl)
                    .into(gambar_mobil);
            Toast.makeText(this, "img : " + imgurl, Toast.LENGTH_SHORT).show();
        } else {
            // Jika imgurl null, tampilkan pesan Toast atau ambil tindakan yang sesuai
            Toast.makeText(this, "URL gambar tidak tersedia", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
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
        gambar_mobil = findViewById(R.id.gambarmobildetail);

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
