package com.example.p5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnDhoni, btnSachin, btnYuvraj, btnVirat, btnHardik, btnRahul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDhoni = findViewById(R.id.btnDhoni);
        btnSachin = findViewById(R.id.btnSachin);
        btnYuvraj = findViewById(R.id.btnYuvraj);
        btnVirat = findViewById(R.id.btnVirat);
        btnHardik = findViewById(R.id.btnHardik);
        btnRahul = findViewById(R.id.btnRahul);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        };

        btnDhoni.setOnClickListener(listener);
        btnSachin.setOnClickListener(listener);
        btnYuvraj.setOnClickListener(listener);
        btnVirat.setOnClickListener(listener);
        btnHardik.setOnClickListener(listener);
        btnRahul.setOnClickListener(listener);
    }
}