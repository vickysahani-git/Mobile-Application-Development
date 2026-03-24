package com.example.p3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etEmail, etPhone, etCountry, etState, etBirthDate,
            etBirthTime;
    RadioGroup rgGender;
    CheckBox cbSports, cbMusic, cbReading;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // text view

        // Input fields
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etCountry = findViewById(R.id.etCountry);
        etState = findViewById(R.id.etState);
        etBirthDate = findViewById(R.id.etBirthDate);
        etBirthTime = findViewById(R.id.etBirthTime);

        // Gender + Interests
        rgGender = findViewById(R.id.rgGender);
        cbSports = findViewById(R.id.cbSports);
        cbMusic = findViewById(R.id.cbMusic);
        cbReading = findViewById(R.id.cbReading);

        // Submit button
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Gender
                int selectedId = rgGender.getCheckedRadioButtonId();
                String gender = "";
                if (selectedId != -1) {
                    RadioButton rb = findViewById(selectedId);
                    gender = rb.getText().toString();
                }
// Get Interests
                StringBuilder interests = new StringBuilder();
                if (cbSports.isChecked()) interests.append("Sports ");
                if (cbMusic.isChecked()) interests.append("Music ");
                if (cbReading.isChecked()) interests.append("Reading ");
                // Send data to DisplayActivity
                Intent intent = new Intent(MainActivity.this, ActivityDisplay.class);
                intent.putExtra("username", etUsername.getText().toString());
                intent.putExtra("password", etPassword.getText().toString());
                intent.putExtra("email", etEmail.getText().toString());
                intent.putExtra("phone", etPhone.getText().toString());
                intent.putExtra("country", etCountry.getText().toString());
                intent.putExtra("state", etState.getText().toString());
                intent.putExtra("birthDate", etBirthDate.getText().toString());
                intent.putExtra("birthTime", etBirthTime.getText().toString());
                intent.putExtra("gender", gender);
                intent.putExtra("interests", interests.toString());
                startActivity(intent);
            }
        });
    }
}