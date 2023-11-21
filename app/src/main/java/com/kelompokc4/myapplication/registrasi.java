package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
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
    boolean passwordvisible;

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
                // Pemeriksaan apakah semua formulir telah diisi
                if (TextUtils.isEmpty(Email.getText().toString()) ||
                        TextUtils.isEmpty(Username.getText().toString()) ||
                        TextUtils.isEmpty(Alamat.getText().toString()) ||
                        TextUtils.isEmpty(Password.getText().toString())) {

                    // Set error pada formulir yang kosong
                    if (TextUtils.isEmpty(Email.getText().toString())) {
                        Email.setError("Email harus diisi");
                    }

                    if (TextUtils.isEmpty(Username.getText().toString())) {
                        Username.setError("Username harus diisi");
                    }

                    if (TextUtils.isEmpty(Alamat.getText().toString())) {
                        Alamat.setError("Alamat harus diisi");
                    }

                    if (TextUtils.isEmpty(Password.getText().toString())) {
                        Password.setError("Password harus diisi");
                    }

                } else {
                    // Semua formulir diisi, lanjutkan dengan pemeriksaan panjang dan karakter password
                    String passwordString = Password.getText().toString();

                    // Pemeriksaan panjang password
                    if (passwordString.length() < 8) {
                        Password.setError("Password minimal 8 karakter");
                    }

                    // Pemeriksaan karakter kapital, huruf kecil, dan angka pada password
                    else if
                    (!passwordString.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$")) {
                        Password.setError("Password harus mengandung karakter kapital, huruf kecil, dan angka");
                    }
                    else {

                        // Jika pemeriksaan panjang dan karakter password lulus, lanjutkan dengan mengirim OTP
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
                }
            }
        });
        Password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int right = 2;

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= Password.getRight() - Password.getCompoundDrawables()[right].getBounds().width()) {
                        int pilih = Password.getSelectionEnd();
                        if (passwordvisible) {
                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visibleoff, 0);
                            Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible = false;
                        } else {
                            Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visible, 0);
                            Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible = true;
                        }
                        Password.setSelection(pilih);
                        return true;
                    }
                }
                return false;
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
