package com.example.p13;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    Button btnContacts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnContacts = findViewById(R.id.btnContacts);

        btnContacts.setOnClickListener(v -> {

            Intent i = new Intent(WelcomeActivity.this, ContactActivity.class);
            startActivity(i);

        });
    }
}