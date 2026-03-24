package com.example.p15;

import android.provider.BaseColumns;

public class NotesContract {
    public static final String TABLE_NAME = "notes";

    public static class Columns implements BaseColumns {
        public static final String TITLE = "title";
        public static final String CONTENT = "content";
    }
}