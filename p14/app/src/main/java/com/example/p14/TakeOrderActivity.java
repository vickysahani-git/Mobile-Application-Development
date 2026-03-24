package com.example.p14;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TakeOrderActivity extends AppCompatActivity {

    EditText etPhone, etItem, etQty;
    Button btnSave;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_order);

        etPhone = findViewById(R.id.etPhone);
        etItem = findViewById(R.id.etItem);
        etQty = findViewById(R.id.etQty);
        btnSave = findViewById(R.id.btnSave);

        db = new DBHelper(this);

        btnSave.setOnClickListener(v -> {

            String phone = etPhone.getText().toString();
            String item = etItem.getText().toString();
            String qty = etQty.getText().toString();

            boolean inserted = db.insertOrder(phone, item, qty);

            if(inserted)
                Toast.makeText(this,"Order Saved",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        });
    }
}