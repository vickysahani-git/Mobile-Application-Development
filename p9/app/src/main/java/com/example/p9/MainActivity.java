package com.example.p9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    Button btnShow;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        btnShow = findViewById(R.id.btnShow);
        txtResult = findViewById(R.id.txtResult);

        // Set 24 hour format from Java (safe method)
        timePicker.setIs24HourView(true);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                String result = "Selected Date: " + day + "/" + month + "/" + year +
                        "\nSelected Time: " + hour + ":" + minute;

                txtResult.setText(result);
            }
        });
    }
}