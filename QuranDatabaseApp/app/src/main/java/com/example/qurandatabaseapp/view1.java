package com.example.qurandatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class view1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);
        DBHelper db=new DBHelper(this);
        ArrayList<String> surahIds=db.getSurahIds();
        ListView view1ListView=findViewById(R.id.view1ListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, surahIds);

        view1ListView.setAdapter(arrayAdapter);
        view1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view1.this, view2.class);
                intent.putExtra("surahId",i);
                startActivity(intent);
            }
        });
    }
}