package com.example.p13;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    CheckBox remember;
    Button login;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);
        remember = findViewById(R.id.chkRemember);
        login = findViewById(R.id.btnLogin);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        user.setText(sp.getString("username",""));
        pass.setText(sp.getString("password",""));

        login.setOnClickListener(v -> {

            if(remember.isChecked()){

                SharedPreferences.Editor ed = sp.edit();
                ed.putString("username",user.getText().toString());
                ed.putString("password",pass.getText().toString());
                ed.apply();

            }

            Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(i);

        });
    }
}