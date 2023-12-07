package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;
import com.kelompokc4.myapplication.koneksi.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ulasan extends Fragment {

    private EditText editTextUlasan;
    private Button buttonSubmit;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ulasan, container, false);

        SharedPreferences sharedPreferencesSeniman = Ulasan.this.getActivity().getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        String id_user = sharedPreferencesSeniman.getString("id_user", "");

        editTextUlasan = view.findViewById(R.id.editTextUlasan);
        buttonSubmit = view.findViewById(R.id.buttonsubmit);

        buttonSubmit.setOnClickListener(view1 -> {
            String ulasan = editTextUlasan.getText().toString();
            if (TextUtils.isEmpty(ulasan)) {
                Toast.makeText(getContext(), "Isi terlebih dahulu ulasan", Toast.LENGTH_SHORT).show();
            } else {
                RetrofitEndPoint ardData = RetrofitClient.getConnection().create(RetrofitEndPoint.class);
                Call<UserResponse> getResponse = ardData.ulasan(ulasan, Integer.parseInt(id_user));
                getResponse.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            if (response.body().getStatus().equals("Berhasil")) {
                                Intent intent = new Intent(getActivity(), Konfirmasi_ulasan.class);
                                startActivity(intent);
                                Toast.makeText(getActivity(), "Ulasan Terkirim", Toast.LENGTH_SHORT).show();
                            } else if (response.body().getStatus().equals("Gagal")) {
                                Toast.makeText(getActivity(), "Ulasan Gagal Dikirim", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Response unsuccessful or body is null", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), "Ulasan Gagal " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }
}
