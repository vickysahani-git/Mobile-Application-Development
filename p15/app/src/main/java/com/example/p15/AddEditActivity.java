package com.example.p15;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditActivity extends AppCompatActivity {

    EditText title, content;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        save = findViewById(R.id.save);

        save.setOnClickListener(v -> {
            ContentValues values = new ContentValues();
            values.put("title", title.getText().toString());
            values.put("content", content.getText().toString());

            getContentResolver().insert(NotesProvider.CONTENT_URI, values);

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}