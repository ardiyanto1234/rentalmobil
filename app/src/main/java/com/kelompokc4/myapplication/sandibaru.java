package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sandibaru extends AppCompatActivity {

    public static String EMAIL = "email";
    private Button btn;

    EditText sandibaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandibaru);

        btn = findViewById(R.id.konfrimSandiBaru);
        sandibaru = findViewById(R.id.editTextUsername);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getInstance().gantiSandi(getIntent().getStringExtra(EMAIL), sandibaru.getText().toString())
                        .enqueue(new Callback<UserResponse>() {
                            @Override
                            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                if (response.body().getStatus().equalsIgnoreCase("success")){
                                    startActivity(new Intent(com.kelompokc4.myapplication.sandibaru.this, MainActivity.class));
                                }else {
                                    Toast.makeText(com.kelompokc4.myapplication.sandibaru.this, "Ganti sandi ggagal", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<UserResponse> call, Throwable t) {
                                Toast.makeText(com.kelompokc4.myapplication.sandibaru.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });



    }
}