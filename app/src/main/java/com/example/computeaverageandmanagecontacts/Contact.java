package com.example.computeaverageandmanagecontacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.computeaverageandmanagecontacts.model.ContactInfo;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {
    ListView lvContacts;
    Button btnAddContact;

    public static ArrayList<ContactInfo> contactList = new ArrayList<>();
    ArrayAdapter<ContactInfo> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvContacts = findViewById(R.id.lvContactDetails);
        btnAddContact = findViewById(R.id.btnAddContact);

        lvContacts = findViewById(R.id.lvContactDetails);
        btnAddContact = findViewById(R.id.btnAddContact);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactList);
        lvContacts.setAdapter(adapter);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contact.this, AddContact.class);
                startActivity(intent);
            }
        });

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Contact.this, ContactDetails.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}