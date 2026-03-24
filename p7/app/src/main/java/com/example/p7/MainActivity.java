package com.example.p7;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    LinearLayout mainLayout;

    String[] colors = {"Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "Gray"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewColors);
        mainLayout = findViewById(R.id.mainLayout);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                colors
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedColor = colors[position];

                switch (selectedColor) {
                    case "Red":
                        mainLayout.setBackgroundColor(Color.RED);
                        break;

                    case "Green":
                        mainLayout.setBackgroundColor(Color.GREEN);
                        break;

                    case "Blue":
                        mainLayout.setBackgroundColor(Color.BLUE);
                        break;

                    case "Yellow":
                        mainLayout.setBackgroundColor(Color.YELLOW);
                        break;

                    case "Cyan":
                        mainLayout.setBackgroundColor(Color.CYAN);
                        break;

                    case "Magenta":
                        mainLayout.setBackgroundColor(Color.MAGENTA);
                        break;

                    case "Gray":
                        mainLayout.setBackgroundColor(Color.GRAY);
                        break;
                }
            }
        });
    }
}