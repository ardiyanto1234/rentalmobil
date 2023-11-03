package com.kelompokc4.myapplication;

import static android.os.Build.VERSION_CODES.O;
import static android.os.Build.VERSION_CODES.P;
import static android.os.Build.VERSION_CODES.S;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;
import com.kelompokc4.myapplication.koneksi.UserResponse;
import com.otpview.OTPListener;
import com.otpview.OTPTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class kodeotp extends AppCompatActivity {


    private Button btnSelesai;

    private OTPTextView otpTextView;

    public static String OTP = "otp", EMAIL = "email", USERNAME = "username", PASS = "passs";

    private String dataOtp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kodeotp);

        btnSelesai = findViewById(R.id.btnSelesai);
        otpTextView = findViewById(R.id.votp_inp_otp);

        dataOtp = getIntent().getStringExtra(OTP);

        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            @Override
            public void onOTPComplete(@NonNull String s) {

                if (dataOtp.equals(otpTextView.getOtp())) {
                    Toast.makeText(kodeotp.this, "OTP Valid", Toast.LENGTH_SHORT).show();

                    RetrofitClient.getConnection().create(RetrofitEndPoint.class).driveeasy(getIntent().getStringExtra(USERNAME), getIntent().getStringExtra(EMAIL), getIntent().getStringExtra(PASS))
                            .enqueue(new Callback<UserResponse>() {
                                @Override
                                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                    if (response.body() != null && response.body().getStatus().equalsIgnoreCase("success")){
                                        Toast.makeText(kodeotp.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(kodeotp.this, MainActivity.class));
                                    }
                                }

                                @Override
                                public void onFailure(Call<UserResponse> call, Throwable t) {

                                }
                            });
                }

            }
        });


        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selesai();
            }
        });
    }

    public void selesai() {
        Intent intent = new Intent(kodeotp.this, MainActivity.class);
        startActivity(intent);
    }
}