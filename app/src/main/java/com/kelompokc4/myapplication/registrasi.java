package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.kelompokc4.myapplication.GOGGLE.GoggleUser;
import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.response.VerifyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registrasi extends AppCompatActivity {
    private Button btnlanjut;
    private GoggleUser google;
    EditText Username, Email, Alamat, Password;
    private Button btnKembali;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);

        Username = findViewById(R.id.editTextUsername);
        Email = findViewById(R.id.editTextEmail);
        Alamat = findViewById(R.id.editTextAlamat);
        Password = findViewById(R.id.editTextPassowrd);
        btnlanjut = findViewById(R.id.buttonLanjut);
        btnKembali = findViewById(R.id.buttonKembali);
        google = new GoggleUser(this);

        btnlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getInstance().sendEmail(Email.getText().toString(), "SignUp", "new")
                        .enqueue(new Callback<VerifyResponse>() {
                            @Override
                            public void onResponse(Call<VerifyResponse> call, Response<VerifyResponse> response) {
                                if (response.body() != null && response.body().getStatus().equalsIgnoreCase("success")) {
                                    Toast.makeText(registrasi.this, "OTP berhasil dikirim", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(registrasi.this, kodeotp.class);
                                    intent.putExtra(kodeotp.OTP, response.body().getData().getOtp());
                                    intent.putExtra(kodeotp.USERNAME, Username.getText().toString());
                                    intent.putExtra(kodeotp.EMAIL, Email.getText().toString());
                                    intent.putExtra(kodeotp.ALAMAT, Alamat.getText().toString());
                                    intent.putExtra(kodeotp.PASS, Password.getText().toString());
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(registrasi.this, "OTP gagal dikirim", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<VerifyResponse> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kembali();
            }
        });
    }

    public void kembali() {
        Intent intent = new Intent(registrasi.this, MainActivity.class);
        startActivity(intent);
    }
}
