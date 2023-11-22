package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;
import com.kelompokc4.myapplication.response.GetMobil;
import com.kelompokc4.myapplication.response.GetMobileResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class daftarmobilkursi4 extends AppCompatActivity {

    ImageView btnback;
    Button btnpesan;


    RecyclerView rv_mobil4;

    private void getDataMobil4() {
        RetrofitEndPoint REP = RetrofitClient.getInstance();
        rv_mobil4 = findViewById(R.id.recyclerview_mobil4);
        Call<GetMobileResponse> data = REP.ambildatamobil4();
        data.enqueue(new Callback<GetMobileResponse>() {
            @Override
            public void onResponse(Call<GetMobileResponse> call, Response<GetMobileResponse> response) {
                if (response.isSuccessful()) {

                    ArrayList<GetMobil> datamobil = response.body().getData();
                    adapter_daftar_mobil adaptermobil = new adapter_daftar_mobil(daftarmobilkursi4.this, datamobil);
                    rv_mobil4.setAdapter(adaptermobil);
                    Toast.makeText(daftarmobilkursi4.this, "size -> " + datamobil.get(0).getId_mobil(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(daftarmobilkursi4.this, "ON FAILURE", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetMobileResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(daftarmobilkursi4.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarmobilkursi4);

        btnback = findViewById(R.id.btnbck);
        getDataMobil4();
        //btnpesan = findViewById(R.id.btnpesan);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
      /*  btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan();
            }
        });*/
    }
      /*  public void pesan() {
            Intent intent = new Intent(daftarmobilkursi4.this, daftarmobil.class);
            startActivity(intent);
    }*/
        public void kembali() {
            Intent intent = new Intent(daftarmobilkursi4.this, home.class);
            startActivity(intent);
    }
}