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
    private String urlmobil;
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
                } else {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarmobil);


        getDataMobil();

        btn = findViewById(R.id.btnbckk);
        /*btnpesan = findViewById(R.id.btnpesan);*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(daftarmobil.this, Dasboard.class));
//                daftarmobil.super.onBackPressed();
            }
        });


    }
}