package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kelompokc4.myapplication.GOGGLE.GoggleUser;
import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;
import com.kelompokc4.myapplication.koneksi.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    private Button btn;
    private Button btnlanjut;
    private GoggleUser google;
    Button gogglebtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnlanjut = findViewById(R.id.buttonLanjut);
        btn = findViewById(R.id.buttonKembali);
        gogglebtn = findViewById(R.id.btngoogle);

        google = new GoggleUser(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                lanjut();
                Toast.makeText(MainActivity2.this, "hello", Toast.LENGTH_SHORT).show();
                startActivityForResult(google.getIntent(), GoggleUser.REQUEST_CODE);
            }
        });

        btnlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, kodeotp.class);
                startActivity(intent);
            }
        });

        gogglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "hello", Toast.LENGTH_SHORT).show();
                startActivityForResult(google.getIntent(), GoggleUser.REQUEST_CODE);
            }
        });
    }


    public void lanjut() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
