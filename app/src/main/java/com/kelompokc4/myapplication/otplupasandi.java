package com.kelompokc4.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.otpview.OTPListener;
import com.otpview.OTPTextView;

public class otplupasandi extends AppCompatActivity {


    public static String OTP = "otp";
    public static String EMAIL = "email";
    String otpCode, otpEmail;

    private OTPTextView otpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otplupasandi);

        otpTextView = findViewById(R.id.votp_inp_otp);

        otpCode = getIntent().getStringExtra(OTP);
        otpEmail = getIntent().getStringExtra(EMAIL);

        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            @Override
            public void onOTPComplete(@NonNull String s) {
                // jika otp valid
                if (otpCode.equals(otpTextView.getOtp())){
                    Toast.makeText(otplupasandi.this, "OTP BENAR", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(otplupasandi.this, "OTP SALAH", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}