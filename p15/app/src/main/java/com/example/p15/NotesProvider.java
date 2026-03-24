package com.example.p15;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;

public class NotesProvider extends ContentProvider {

    public static final String AUTHORITY = "com.example.notesapp.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/notes");

    DBHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(NotesContract.TABLE_NAME, projection, selection,
                selectionArgs, null, null, sortOrder);
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert(NotesContract.TABLE_NAME, null, values);
        return Uri.withAppendedPath(CONTENT_URI, String.valueOf(id));
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete(NotesContract.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.update(NotesContract.TABLE_NAME, values, selection, selectionArgs);
    }

    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }
}