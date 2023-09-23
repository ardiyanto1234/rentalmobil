package com.kelompokc4.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dasboard extends AppCompatActivity {

    BottomNavigationView navbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        navbar = findViewById(R.id.bottomNavigasi);

        navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                //iki menu sen ndek bottom navigasi
                if(item.getItemId() == R.id.Home){
                    selectedFragment = new home();
                }else if (item.getItemId() == R.id.Pesanan){
                    selectedFragment = new pesanan();
                }else if (item.getItemId() == R.id.Notif){
                    selectedFragment = new notif();
                }else if (item.getItemId() == R.id.Ulasan){
                    selectedFragment = new Ulasan();
                }else if (item.getItemId() == R.id.profil){
                    selectedFragment = new Profil();
                }

                if(selectedFragment != null){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, selectedFragment)
                            .commit();
                }
                return true;
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, new home())
                .commit();
    }
}