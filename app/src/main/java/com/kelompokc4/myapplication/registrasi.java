package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kelompokc4.myapplication.GOGGLE.GoggleUser;
import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registrasi extends AppCompatActivity {
    private Button btn;
    private Button btnlanjut;
    private GoggleUser google;
    EditText Username, Email, Password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);

        Username = findViewById(R.id.editTextUsername);
        Email = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.editTextPassowrd);
        btnlanjut = findViewById(R.id.buttonLanjut);
        btn = findViewById(R.id.buttonKembali);

        google = new GoggleUser(this);
        btnlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getInstance().driveeasy(Username.getText().toString(), Email.getText().toString(), Password.getText().toString())
                        .enqueue(new Callback<UserResponse>() {
                                     @Override
                                     public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                         if(response.isSuccessful()){
                                             if (response.body() != null && response.body().getStatus().equalsIgnoreCase("success")) {
                                                 Toast.makeText(getApplicationContext(), "Register berhasil", Toast.LENGTH_SHORT).show();

                                                 // jajalen register terus login oke

                                                 startActivity(new Intent(registrasi.this, otplupasandi.class)); // iki ne sg salah
                                             } else {
                                                 Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
                                             }
                                         }else{
                                             Toast.makeText(registrasi.this, "Register Gagal ", Toast.LENGTH_SHORT).show();
                                         }
                                     }

                                     @Override
                                     public void onFailure(Call<UserResponse> call, Throwable t) {
                                         Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                                     }
                                 }
                        );
            }
        });

    }
}