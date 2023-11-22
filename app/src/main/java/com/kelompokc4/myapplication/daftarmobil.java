package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;
import com.kelompokc4.myapplication.response.Detailresponmobil;
import com.kelompokc4.myapplication.response.GetMobil;
import com.kelompokc4.myapplication.response.GetMobileResponse;
import com.kelompokc4.myapplication.response.model_det_mobil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class daftarmobil extends AppCompatActivity {

    ImageView btn;
    private Button btnpesan;

    RecyclerView rc_mobil;

    private void getDataMobil() {
        RetrofitEndPoint REP = RetrofitClient.getInstance();
        rc_mobil = findViewById(R.id.recyclerview_mobil);
        Call<GetMobileResponse> data = REP.getMobil();
        data.enqueue(new Callback<GetMobileResponse>() {
            @Override
            public void onResponse(Call<GetMobileResponse> call, Response<GetMobileResponse> response) {
                if (response.isSuccessful()) {
                    ArrayList<GetMobil> datamobil = response.body().getData();
                    adapter_daftar_mobil adaptermobil = new adapter_daftar_mobil(daftarmobil.this, datamobil);
                    rc_mobil.setAdapter(adaptermobil);
                    Toast.makeText(daftarmobil.this, "size -> " + datamobil.get(0).getId_mobil(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(daftarmobil.this, "ON FAILURE", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetMobileResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(daftarmobil.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarmobil);




        getDataMobil();

        btn = findViewById(R.id.btnbck);
        /*btnpesan = findViewById(R.id.btnpesan);*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daftarmobil.super.onBackPressed();
            }
        });


       /* btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetchDataFromServer();
            }
        });
    }*/
   /* private void fetchDataFromServer() {
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
    }*/

    /*private void sendToDetailActivity(int idMobil) {
        Intent intent = new Intent(daftarmobil.this, detailmobil.class);

        // Kirim id_mobil ke aktivitas selanjutnya melalui Intent
        intent.putExtra("idMobil", idMobil);

        startActivity(intent);
        Toast.makeText(daftarmobil.this, "ID Mobil: " + idMobil, Toast.LENGTH_SHORT).show();
    }*/

    }
}