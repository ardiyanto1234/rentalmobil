package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;
import com.kelompokc4.myapplication.response.GetMobil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                fetchDataFromServer();
            }
        });
    }
    private void fetchDataFromServer() {
        RetrofitEndPoint apiService = RetrofitClient.getInstance();

        Call<List<GetMobil>> call = apiService.getMobil();
        call.enqueue(new Callback<List<GetMobil>>() {
            @Override
            public void onResponse(Call<List<GetMobil>> call, Response<List<GetMobil>> response) {
                if (response.isSuccessful()) {
                    List<GetMobil> mobilList = response.body();

                    // Ambil id_mobil pertama dari list
                    int firstMobilId = mobilList.get(0).getId_mobil();

                    // Kirim id_mobil ke aktivitas selanjutnya
                    sendToDetailActivity(firstMobilId);
                } else {
                    Toast.makeText(daftarmobil.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetMobil>> call, Throwable t) {
                // Handle kesalahan di sini
                Toast.makeText(daftarmobil.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                Log.e("Error", "Retrofit Error: " + t.getMessage());
            }
        });
    }

    private void sendToDetailActivity(int idMobil) {
        Intent intent = new Intent(daftarmobil.this, detailmobil.class);

        // Kirim id_mobil ke aktivitas selanjutnya melalui Intent
        intent.putExtra("idMobil", idMobil);

        startActivity(intent);
        Toast.makeText(daftarmobil.this, "ID Mobil: " + idMobil, Toast.LENGTH_SHORT).show();
    }

}
