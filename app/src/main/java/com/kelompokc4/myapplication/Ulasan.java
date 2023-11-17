package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
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
import com.kelompokc4.myapplication.response.ResponseBooking;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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
        String id_user = sharedPreferencesSeniman.getString("id_user","");
        editTextUlasan = view.findViewById(R.id.editTextUlasan);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(view1 -> {
            String ulasan = editTextUlasan.getText().toString();
            RetrofitEndPoint ardData = RetrofitClient.getConnection().create(RetrofitEndPoint.class);
            Call<UserResponse> getResponse = ardData.ulasan(ulasan,Integer.parseInt(id_user));
            getResponse.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                    if (response.body().getStatus().equals("Berhasil")){
//                        startActivity(new Intent(Ulasan.this,KonfirmasiUlasan.class));
                        Toast.makeText(getActivity(), "Ulasan Terkirim", Toast.LENGTH_SHORT).show();
                    }else if(response.body().getStatus().equals("Gagal")){
                        Toast.makeText(getActivity(), "Ulasan Gagal Dikirim", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Toast.makeText(getActivity(), "Ulasan Gagal "+t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });

        return view;
    }




}
