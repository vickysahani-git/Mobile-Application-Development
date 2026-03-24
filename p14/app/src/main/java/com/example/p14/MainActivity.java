package com.example.p14;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnTakeOrder, btnViewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTakeOrder = findViewById(R.id.btnTakeOrder);
        btnViewOrder = findViewById(R.id.btnViewOrder);

        btnTakeOrder.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TakeOrderActivity.class));
        });

        btnViewOrder.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ViewOrderActivity.class));
        });
    }
}