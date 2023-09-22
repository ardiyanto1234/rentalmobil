package com.kelompokc4.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    public Button btn;
    public void register () {
    Intent Register = new Intent(this, MainActivity2.class);
         startActivity(Register);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main_2);

    btn = findViewById(R.id.buttonRegister);
        btn.setOnClickListener(new View.OnClickListener() {
        @Override
              public void onClick(View v) {
            register();
        }
    });
    }
}