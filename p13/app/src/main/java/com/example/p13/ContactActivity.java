package com.example.p13;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.PackageManager;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> numbers = new ArrayList<>();
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        listView = findViewById(R.id.listView);

        if (checkSelfPermission(android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS},1);

        } else {

            loadContacts();
        }

        registerForContextMenu(listView);
    }

    private void loadContacts(){

        names.clear();
        numbers.clear();

        Cursor c = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null);

        if(c != null){

            while(c.moveToNext()){

                names.add(c.getString(
                        c.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));

                numbers.add(c.getString(
                        c.getColumnIndexOrThrow(
                                ContactsContract.CommonDataKinds.Phone.NUMBER)));
            }

            c.close();
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,names);

        listView.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 1 && grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED){

            loadContacts();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Options");
        menu.add(0,1,0,"Send SMS");

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        position = info.position;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId()==1){

            String phone = numbers.get(position);

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("sms:"+phone));
            startActivity(i);
        }

        return true;
    }
}