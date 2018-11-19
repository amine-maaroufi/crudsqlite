package com.andromob.sqlitecrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.andromob.sqlitecrud.db.CustomAdapter;
import com.andromob.sqlitecrud.db.DatabaseHelper;
import com.andromob.sqlitecrud.pojo.Contact;

import java.util.ArrayList;

public class GetAllContactsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Contact> contactArrayList;
    private CustomAdapter customAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_contacts);

        listView = (ListView) findViewById(R.id.lv);

        databaseHelper = new DatabaseHelper(this);

        contactArrayList = databaseHelper.getAllContacts();

        customAdapter = new CustomAdapter(this,contactArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GetAllContactsActivity.this,UpdateDeleteActivity.class);
                intent.putExtra("contact",contactArrayList.get(position));
                startActivity(intent);
            }
        });
    }
}
