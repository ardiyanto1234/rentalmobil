package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;
import com.kelompokc4.myapplication.koneksi.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class editprofil extends AppCompatActivity {

    private EditText editTextUsername, editTextEmail, editTextAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofil);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextAlamat = findViewById(R.id.editTextAlamat);

        Button btnSelesai = findViewById(R.id.btnSelesai);
        SharedPreferences sharedPreferences =getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String id_user = sharedPreferences.getString("id_user", "");
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String alamat = sharedPreferences.getString("alamat", "");

        editTextUsername.setText(username);
        editTextEmail.setText(email);
        editTextAlamat.setText(alamat);
        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ambilusername = editTextUsername.getText().toString();
                String ambilemail = editTextEmail.getText().toString();
                String ambilalamat = editTextAlamat.getText().toString();

                RetrofitEndPoint endPoint = RetrofitClient.getConnection().create(RetrofitEndPoint.class);
                Call<UserResponse> call = endPoint.editprofil(id_user, ambilusername,ambilemail,ambilalamat);

                call.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.body().getStatus().equals("success")){
                            Toast.makeText(editprofil.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            editor.putString("username", editTextUsername.getText().toString());
                            editor.putString("alamat", editTextAlamat.getText().toString());
                            editor.putString("email", editTextEmail.getText().toString());
                            editor.apply();
                            finish();
                        }else {
                            Toast.makeText(editprofil.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Log.e("error pada update profil", t.getMessage());
                        t.printStackTrace();
                    }
                });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences =getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String id_user = sharedPreferences.getString("id_user", "");
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String alamat = sharedPreferences.getString("alamat", "");
    }
}
