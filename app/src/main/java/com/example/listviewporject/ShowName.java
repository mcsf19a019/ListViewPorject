package com.example.listviewporject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowName extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);
        Intent intent = getIntent();

        textView = findViewById(R.id.textView);
        textView.setText( intent.getStringExtra("snakeFriendName"));
    }
}