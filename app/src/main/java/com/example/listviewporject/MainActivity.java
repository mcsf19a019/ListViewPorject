package com.example.listviewporject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button button;
    EditText editText;
    ArrayList<String> friendsList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myListView);
        button = findViewById(R.id.button01);
        editText = findViewById(R.id.edit01);

        friendsList = new ArrayList<String>();
        friendsList.add("Sehar doji");
        friendsList.add("Tayyab lala");
        friendsList.add("Maham Pie");
        Collections.sort(friendsList);

        arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,friendsList
        );

        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("You clicked",friendsList.get(i));
                Intent intent = new Intent(MainActivity.this,ShowName.class);
                intent.putExtra("snakeFriendName",friendsList.get(i));
                startActivity(intent);
            }
        });
    }

    public void AddFriend(View view) {
        friendsList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        Collections.sort(friendsList);
    }
}