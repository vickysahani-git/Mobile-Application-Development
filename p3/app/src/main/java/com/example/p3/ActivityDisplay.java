package com.example.p3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDisplay extends AppCompatActivity {
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        tvDisplay = findViewById(R.id.tvDisplay);
        String info = "Username: " + getIntent().getStringExtra("username") + "\n" +
                "Password: " + getIntent().getStringExtra("password") + "\n" +
                "Email: " + getIntent().getStringExtra("email") + "\n" +
                "Phone: " + getIntent().getStringExtra("phone") + "\n" +
                "Country: " + getIntent().getStringExtra("country") + "\n" +
                "State: " + getIntent().getStringExtra("state") + "\n" +
                "Gender: " + getIntent().getStringExtra("gender") + "\n" +
                "Interests: " + getIntent().getStringExtra("interests") + "\n" +
                "Birth Date: " + getIntent().getStringExtra("birthDate") + "\n" +
                "Birth Time: " + getIntent().getStringExtra("birthTime");
        tvDisplay.setText(info);
    }
}
