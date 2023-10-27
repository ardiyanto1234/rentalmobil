package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.response.VerifyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LupaSandi extends AppCompatActivity {
    private Button btn;
    private Button btnkembali;

    private EditText inpEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_sandi);

        btn = findViewById(R.id.buttonLanjut2);
        inpEmail = findViewById(R.id.editTextNoHp);
        btnkembali = findViewById(R.id.buttonKembali2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getInstance().sendEmail(inpEmail.getText().toString(), "ForgotPass", "new")
                        .enqueue(new Callback<VerifyResponse>() {
                            @Override
                            public void onResponse(Call<VerifyResponse> call, Response<VerifyResponse> response) {

                                if (response.body() != null && response.body().getStatus().equalsIgnoreCase("success")){
                                    startActivity(
                                            new Intent(LupaSandi.this, otplupasandi.class)
                                                    .putExtra(otplupasandi.OTP, response.body().getData().getOtp())
                                                    .putExtra(otplupasandi.EMAIL, response.body().getData().getEmail())
                                    );
                                } else {
                                    Toast.makeText(LupaSandi.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<VerifyResponse> call, Throwable t) {
                                Toast.makeText(LupaSandi.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kembali();
            }
        });
    }

    public void Lanjut() {
        Intent intent = new Intent(LupaSandi.this, otplupasandi.class);
        startActivity(intent);
    }

    private void kembali() {
        Intent intent = new Intent(LupaSandi.this, MainActivity.class);
        startActivity(intent);
    }
}
