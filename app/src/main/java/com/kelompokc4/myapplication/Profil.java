package com.kelompokc4.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Profil extends Fragment {

    public static int SavedState;
    public static final int EDIT_PROFILE_REQUEST = 1;
    private Button btnLogout;
    private Button btnEditProfil;
    private TextView usernameTextView, emailTextView, alamatTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        // Inisialisasi TextView
        usernameTextView = view.findViewById(R.id.tv_username);
        emailTextView = view.findViewById(R.id.tv_email_profile);
        alamatTextView = view.findViewById(R.id.tv_alamat_profile);

        // Ambil data pengguna dari SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String alamat = sharedPreferences.getString("almat", "");

        // Set data pengguna ke TextView
        usernameTextView.setText(username);
        emailTextView.setText(email);
        alamatTextView.setText(alamat);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogout = view.findViewById(R.id.logout);
        btnEditProfil = view.findViewById(R.id.edit);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btnEditProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), editprofil.class);
               startActivity(intent);
            }
        });
    }

    private void logout() {
        // Hapus semua data pengguna dari SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        Intent intent = new Intent(requireActivity(), MainActivity.class);
        startActivity(intent);
        requireActivity().finish();  // Menutup activity saat ini setelah logout
    }
}
