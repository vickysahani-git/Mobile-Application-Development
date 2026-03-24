package com.example.p14;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Orders.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE orders(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "phone TEXT," +
                "item TEXT," +
                "qty TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(db);
    }

    public boolean insertOrder(String phone,String item,String qty){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("phone",phone);
        cv.put("item",item);
        cv.put("qty",qty);

        long result = db.insert("orders",null,cv);

        return result != -1;
    }

    public Cursor getOrders(){

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("SELECT * FROM orders",null);
    }
}