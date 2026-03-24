package com.example.p6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editStudentName;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editStudentName = findViewById(R.id.editStudentName);
        btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editStudentName.getText().toString();

                if(name.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "enter student name",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Student Name: " + name,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}