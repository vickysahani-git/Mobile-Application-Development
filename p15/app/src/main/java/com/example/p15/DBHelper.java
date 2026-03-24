package com.example.p15;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "NotesDB";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + NotesContract.TABLE_NAME + " (" +
                NotesContract.Columns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NotesContract.Columns.TITLE + " TEXT, " +
                NotesContract.Columns.CONTENT + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NotesContract.TABLE_NAME);
        onCreate(db);
    }
}