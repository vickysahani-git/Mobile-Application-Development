package com.example.p10;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNo1, etNo2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNo1 = findViewById(R.id.etNo1);
        etNo2 = findViewById(R.id.etNo2);
        tvResult = findViewById(R.id.tvResult);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String num1Str = etNo1.getText().toString();
        String num2Str = etNo2.getText().toString();

        if(num1Str.isEmpty() || num2Str.isEmpty()){
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
            return true;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        int id = item.getItemId();

        if(id == R.id.menu_add){
            result = num1 + num2;
        }
        else if(id == R.id.menu_sub){
            result = num1 - num2;
        }
        else if(id == R.id.menu_mul){
            result = num1 * num2;
        }

        tvResult.setText("Result: " + result);

        return true;
    }
}