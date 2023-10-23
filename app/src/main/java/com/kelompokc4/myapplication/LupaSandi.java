package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LupaSandi extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_sandi);

        btn = findViewById(R.id.buttonLanjut2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lanjut();
            }
        });
    }

    public void Lanjut() {
        Intent intent = new Intent(LupaSandi.this, otplupasandi.class);
        startActivity(intent);
    }
}
