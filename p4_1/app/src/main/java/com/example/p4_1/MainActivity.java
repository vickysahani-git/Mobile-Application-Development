package com.example.p4_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite, btnLocation, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);
        btnLocation = findViewById(R.id.btnLocation);
        btnShare = findViewById(R.id.btnShare);

        // 1️ Open Website
        btnWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        // 2️ Open Location (Google Maps)
        btnLocation.setOnClickListener(v -> {
            Uri location = Uri.parse("geo:0,0?q=Ahmedabad");
            Intent intent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(intent);
        });

        // 3️ Share Text using ShareCompat
        btnShare.setOnClickListener(v -> {
            ShareCompat.IntentBuilder
                    .from(MainActivity.this)
                    .setType("text/plain")
                    .setText("my name is pankho")
                    .startChooser();
        });
    }
}