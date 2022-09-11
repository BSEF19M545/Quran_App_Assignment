package com.example.qurandatabaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class view2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);

        Intent intent=getIntent();
        int surahId,paraId;
        DBHelper dbHelper=new DBHelper(this);
        ArrayList<QuranDisplayModelData> data=new ArrayList<>();
        ArrayList<QuranDisplayModelData_V2> data_V2=new ArrayList<>();
        if(intent.hasExtra("surahId")){
            surahId=intent.getIntExtra("surahId",0);
            if(getIntent().getStringExtra("version").equals("v1"))
            {
                data = dbHelper.getSurah(surahId, intent.getStringExtra("language"), getIntent().getStringExtra("TaEnglish"), getIntent().getStringExtra("TaUrdu"));
            }
            else{
                data_V2 = dbHelper.getSurah_V2(surahId, getIntent().getStringExtra("TaEnglish"), getIntent().getStringExtra("TaUrdu"));
            }
        }
        else if (intent.hasExtra("paraId"))
        {
            paraId=intent.getIntExtra("paraId",0);
//            Toast.makeText(this, String.valueOf(paraId), Toast.LENGTH_SHORT).show();
            if(getIntent().getStringExtra("version").equals("v1")) {
                data = dbHelper.getPara(paraId, intent.getStringExtra("language"), getIntent().getStringExtra("TaEnglish"), getIntent().getStringExtra("TaUrdu"));
            }
            else{
                data_V2 = dbHelper.getSurah_V2(paraId, getIntent().getStringExtra("TaEnglish"), getIntent().getStringExtra("TaUrdu"));
            }
        }



        ListView view2ListView=findViewById(R.id.view2ListView);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
//                (this, android.R.layout.simple_list_item_1, data);
//
//        view2ListView.setAdapter(arrayAdapter);
        if(getIntent().getStringExtra("version").equals("v1")) {
            customListView2 adapter = new customListView2(getApplicationContext(), data);
            view2ListView.setAdapter(adapter);
        }
        else{
//            customListView2_V2 adapter = new customListView2_V2(getApplicationContext(), data_V2);
//            view2ListView.setAdapter(adapter);
            //ListView view1ListView=findViewById(R.id.view1ListView);
            RecyclerView recyclerView = findViewById(R.id.recyclerViewList2);
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager;
            RecyclerView.Adapter adapter;

            //LinearLayoutManager GridLayoutManager
            // layoutManager = new LinearLayoutManager(MainActivity.this);
            layoutManager = new LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL,
                    false);
            recyclerView.setLayoutManager(layoutManager);
            //con=this;
            adapter = new recyclerViewAdapterView2(data_V2) ;
            recyclerView.setAdapter(adapter);
        }


    }
}