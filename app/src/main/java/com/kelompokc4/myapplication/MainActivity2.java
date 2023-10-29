package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button btn;
    private Button btnlanjut;

    private EditText inptEmail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnlanjut = findViewById(R.id.buttonLanjut);
        btn = findViewById(R.id.buttonKembali);
        inptEmail = findViewById(R.id.editTextEmail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjut();
            }
        });

        btnlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, kodeotp.class);
                startActivity(intent);
            }
        });
    }

    public void lanjut() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
