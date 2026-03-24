package com.example.p11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    CheckBox remember;
    Button loginBtn;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        remember = findViewById(R.id.remember);
        loginBtn = findViewById(R.id.loginBtn);

        sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);

        // Load saved data
        email.setText(sharedPreferences.getString("email", ""));
        password.setText(sharedPreferences.getString("password", ""));

        loginBtn.setOnClickListener(v -> {

            String userEmail = email.getText().toString();
            String userPass = password.getText().toString();

            if (remember.isChecked()) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", userEmail);
                editor.putString("password", userPass);
                editor.apply();

            }

            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            intent.putExtra("email", userEmail);
            startActivity(intent);
        });
    }
}