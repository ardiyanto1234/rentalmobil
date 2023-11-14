package com.kelompokc4.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kelompokc4.myapplication.koneksi.UserMode;

public class Profil extends Fragment {

    private Button btnLogout;
    private Button btneditprofil;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogout = view.findViewById(R.id.logout);
        btneditprofil = view.findViewById(R.id.edit);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        btneditprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), editprofil.class);
                startActivity(intent);
            }
        });
    }
    public void logout() {


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Simpan semua data pengguna ke SharedPreferences

        editor.putString("id_user",null);
        editor.putString("username",null);
        editor.putString("almat",null);
        editor.putString("email", null);
        editor.putString("password", null);
        editor.apply();
        Intent intent = new Intent(requireActivity(), MainActivity.class);
        startActivity(intent);

    }
}
