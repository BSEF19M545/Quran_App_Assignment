package com.example.qurandatabaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class view1 extends AppCompatActivity implements recyclerViewAdapter.onNoteListener {
    ArrayList<surahListModel> displayData=new ArrayList<surahListModel>();
    ArrayList<surahListModel_V2> displayData_V2=new ArrayList<surahListModel_V2>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Intent intent;
    recyclerViewAdapter.onNoteListener con;
//    ArrayList<String> displayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);
        DBHelper db=new DBHelper(this);
        intent = new Intent(view1.this, view2.class);

        if(getIntent().getStringExtra("version").equals("v1")) {

            if (getIntent().getStringExtra("type").equals("surah")) {
                //if(getIntent().getStringExtra("TaUrdu").equals)
                displayData = db.getSurahList(getIntent().getStringExtra("language"));
            } else if (getIntent().getStringExtra("type").equals("para")) {
                displayData = db.getParaList(getIntent().getStringExtra("language"));
            }
        }
        else{
            if (getIntent().getStringExtra("type").equals("surah")) {
                displayData_V2 = db.getSuraList_V2();
            }
            else if (getIntent().getStringExtra("type").equals("para")) {
                displayData_V2 = db.getParaList_V2();
            }
        }
        ListView view1ListView=findViewById(R.id.view1ListView);
        recyclerView = findViewById(R.id.recyclerViewList);

        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, displayData);

        view1ListView.setAdapter(arrayAdapter);*/
        if(getIntent().getStringExtra("version").equals("v1")) {
            customListView adapter = new customListView(getApplicationContext(), displayData);
            view1ListView.setAdapter(adapter);
        }
        else
        {
            /*customListView_V2 adapter = new customListView_V2(getApplicationContext(), displayData_V2);
            view1ListView.setAdapter(adapter);*/



            recyclerView.setHasFixedSize(true);

            //LinearLayoutManager GridLayoutManager
            // layoutManager = new LinearLayoutManager(MainActivity.this);
            layoutManager = new LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL,
                    false);
            recyclerView.setLayoutManager(layoutManager);
            con=this;
            adapter = new recyclerViewAdapter(displayData_V2,this) ;
            recyclerView.setAdapter(adapter);
        }
        view1ListView.setOnItemClickListener((adapterView, view, i, l) -> {
            //if(getIntent().getStringExtra("version").equals("v1")) {
                if (getIntent().getStringExtra("type").equals("surah")) {
                    TextView tv = (TextView) view.findViewById(R.id.textView1);
                    //findViewById(R.id.textView1);
                    intent.putExtra("surahId", Integer.parseInt(tv.getText().toString()));
                    //Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
                    intent.putExtra("TaUrdu", getIntent().getStringExtra("TaUrdu"));
                    intent.putExtra("TaEnglish", getIntent().getStringExtra("TaEnglish"));
                    intent.putExtra("version", "v1");



                    intent.putExtra("language", getIntent().getStringExtra("language"));
                } else if (getIntent().getStringExtra("type").equals("para")) {
                    TextView tv = (TextView) view.findViewById(R.id.textView1);
//                Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();

                    intent.putExtra("paraId", Integer.parseInt(tv.getText().toString()));
                    intent.putExtra("TaUrdu", getIntent().getStringExtra("TaUrdu"));
                    intent.putExtra("TaEnglish", getIntent().getStringExtra("TaEnglish"));
                    intent.putExtra("language", getIntent().getStringExtra("language"));
                    intent.putExtra("version", "v1");


                }
           // }
            //else
            //{
            /*intent= new Intent(view1.this, view2.class);
            if (getIntent().getStringExtra("type").equals("surah")) {
                TextView tv = (TextView) findViewById(R.id.textView1);
                intent.putExtra("surahId", Integer.parseInt(tv.getText().toString()));
                intent.putExtra("TaEnglish", getIntent().getStringExtra("TaEnglish"));
                intent.putExtra("version", "v2");


            } else if (getIntent().getStringExtra("type").equals("para")) {
                TextView tv = (TextView) findViewById(R.id.textView1);
                intent.putExtra("paraId", Integer.parseInt(tv.getText().toString()));
                intent.putExtra("TaUrdu", getIntent().getStringExtra("TaUrdu"));
                intent.putExtra("version", "v2");
*/

                // }

            startActivity(intent);
        });

        /*recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                Toast.makeText(view1.this, "Helo", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });*/

        EditText searchBar=findViewById(R.id.searchBar);

        searchBar.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void afterTextChanged(Editable mEdit)
            {
                if(getIntent().getStringExtra("version").equals("v1")) {
                    ArrayList<surahListModel> rtn = new ArrayList<>();
                    String str;
                    for(int i=0;i<displayData.size();i++)
                    {
                        str=String.valueOf(displayData.get(i).getSurahNO())+ " "+displayData.get(i).surahName;
                        if (str.toLowerCase(Locale.ROOT).contains(mEdit.toString().toLowerCase(Locale.ROOT)))//String.valueOf(displayData.get(i).surahNO).equals(mEdit.toString())||displayData.get(i).surahName.toLowerCase(Locale.ROOT).contains(mEdit.toString().toLowerCase(Locale.ROOT)))
                        {
                            rtn.add(displayData.get(i));
                        }
                    }
                    if(rtn.size()>0)
                    {
                    /*ArrayAdapter<String> adapter = new ArrayAdapter<>(view1.this, android.R.layout.simple_list_item_1, rtn);
                    view1ListView.setAdapter(adapter);*/
                        customListView adapter= new customListView(getApplicationContext(),rtn);
                        view1ListView.setAdapter(adapter);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    ArrayList<surahListModel_V2> rtn_V2 = new ArrayList<>();
                    String str;
                    for(int i=0;i<displayData_V2.size();i++)
                    {
                        str=String.valueOf(displayData_V2.get(i).getSurahNO())+ " "+displayData_V2.get(i).getSurahNameUrdu()+" "+displayData_V2.get(i).getSurahNameEnglish();
                        if (str.toLowerCase(Locale.ROOT).contains(mEdit.toString().toLowerCase(Locale.ROOT)))//String.valueOf(displayData.get(i).surahNO).equals(mEdit.toString())||displayData.get(i).surahName.toLowerCase(Locale.ROOT).contains(mEdit.toString().toLowerCase(Locale.ROOT)))
                        {
                            rtn_V2.add(displayData_V2.get(i));
                        }
                    }
                    if(rtn_V2.size()>0)
                    {
                        /*customListView_V2 adapter= new customListView_V2(getApplicationContext(),rtn_V2);
                        view1ListView.setAdapter(adapter);*/



                        adapter = new recyclerViewAdapter(rtn_V2,con) ;
                        recyclerView.setAdapter(adapter);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_SHORT).show();
                    }
                }



            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
    }

    @Override
    public void onNoteClick(int position,View view) {
        //else
        //{
            intent= new Intent(view1.this, view2.class);
            if (getIntent().getStringExtra("type").equals("surah")) {
                TextView tv = (TextView) view.findViewById(R.id.textView1);
                //TextView tv = (TextView) findViewById(R.id.textView1);
                //Toast.makeText(this, String.valueOf(displayData_V2.get(position).getSurahNO()), Toast.LENGTH_SHORT).show();
//                intent.putExtra("surahId", /*Integer.parseInt(/*tv.getText().toString())*/ displayData_V2.get(position).getSurahNO());
                intent.putExtra("surahId", Integer.parseInt(tv.getText().toString()) );
                intent.putExtra("TaEnglish", getIntent().getStringExtra("TaEnglish"));
                intent.putExtra("version", "v2");


            } else if (getIntent().getStringExtra("type").equals("para")) {
                //TextView tv = (TextView) findViewById(R.id.textView1);
//                intent.putExtra("paraId",displayData_V2.get(position).getSurahNO() /*Integer.parseInt(tv.getText().toString())*/);
                TextView tv = (TextView) view.findViewById(R.id.textView1);
                intent.putExtra("paraId",Integer.parseInt(tv.getText().toString()));
                intent.putExtra("TaUrdu", getIntent().getStringExtra("TaUrdu"));
                intent.putExtra("version", "v2");


           // }
        }
        startActivity(intent);

    }


}