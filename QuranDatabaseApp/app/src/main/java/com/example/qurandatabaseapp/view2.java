package com.example.qurandatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class view2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);

        Intent intent=getIntent();
        int surahId=intent.getIntExtra("surahId",0)+1;

        DBHelper dbHelper=new DBHelper(this);
        ArrayList<String> surah =dbHelper.getSurah(surahId);

        ListView view2ListView=findViewById(R.id.view2ListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, surah);

        view2ListView.setAdapter(arrayAdapter);

    }
}