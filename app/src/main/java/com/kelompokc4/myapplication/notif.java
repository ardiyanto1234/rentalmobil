package com.kelompokc4.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kelompokc4.myapplication.Adapter.AdapterHistori;
import com.kelompokc4.myapplication.koneksi.ModelNotifikasi;
import com.kelompokc4.myapplication.koneksi.ResponHistori;
import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class  notif extends Fragment {

    private ArrayList<ModelNotifikasi> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        String id = sharedPreferences.getString("id_user","");

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_mobil);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        RetrofitEndPoint endPoint = RetrofitClient.getConnection().create(RetrofitEndPoint.class);
        Call<ResponHistori> call = endPoint.histori(id);
        call.enqueue(new Callback<ResponHistori>() {
            @Override
            public void onResponse(Call<ResponHistori> call, Response<ResponHistori> response) {
                Toast.makeText(getActivity(), "id = "+id, Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()){
                    ArrayList<ModelNotifikasi> list = response.body().getData();
                    data.addAll(list);
                    AdapterHistori adapterHistori = new AdapterHistori(data);
                    recyclerView.setAdapter(adapterHistori);
                    Toast.makeText(getActivity(), "test"+response.body().getData(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getActivity(), "gagalll", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponHistori> call, Throwable t) {
                Log.e("error ambil histori", t.getMessage());
            }
        });

        return view;
    }
}