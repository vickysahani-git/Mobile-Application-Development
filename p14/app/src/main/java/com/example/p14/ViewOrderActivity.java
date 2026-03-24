package com.example.p14;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ViewOrderActivity extends AppCompatActivity {

    ListView listView;
    DBHelper db;
    ArrayList<String> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        listView = findViewById(R.id.orderListView);
        db = new DBHelper(this);

        orders = new ArrayList<>();

        Cursor cursor = db.getOrders();

        while(cursor.moveToNext()) {

            String phone = cursor.getString(1);
            String item = cursor.getString(2);
            String qty = cursor.getString(3);

            orders.add("Phone: "+phone+" | Item: "+item+" | Qty: "+qty);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        orders);

        listView.setAdapter(adapter);
    }
}