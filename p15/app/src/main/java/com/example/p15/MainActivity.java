package com.example.p15;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> notesList = new ArrayList<>();
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton fab = findViewById(R.id.fab);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();

        adapter = new NotesAdapter(this, notesList);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(v ->
                startActivity(new Intent(this, AddEditActivity.class))
        );
    }

    private void loadData() {
        Cursor cursor = getContentResolver().query(
                NotesProvider.CONTENT_URI, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                notesList.add(cursor.getString(1)); // title
            }
            cursor.close();
        }
    }
}