package com.example.qurandatabaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    String english,urdu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        Switch mySwitch = findViewById(R.id.myswitch);
        //mySwitch.setOnCheckedChangeListener(this);
        RadioButton rb11,rb12,rb21,rb22;
        RadioGroup rg1,rg2;
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg1.getCheckedRadioButtonId();
        rb11=findViewById(rg1.getCheckedRadioButtonId());
        rb12=findViewById(R.id.radioButton16);
        rb21=findViewById(rg2.getCheckedRadioButtonId());
        rb22=findViewById(R.id.radioButton10);
         english="6";
         urdu="4";

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_surah:
//                        Toast.makeText(getApplicationContext(), "Book is Clicked", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","surah");
                        if(rb11.isChecked())
                        {
                            urdu="4";
                        }
                        else if(rb12.isChecked())
                        {
                            urdu="5";
                        }
                        if(rb21.isChecked())
                        {
                            english="6";
                        }
                        else if(rb22.isChecked())
                        {
                            english="7";
                        }
                        if(mySwitch.isChecked()) {
                            intent.putExtra("language", "urdu");
                            intent.putExtra("TaUrdu", urdu);
                        }
                        else{
                            intent.putExtra("language", "english");
                            intent.putExtra("TaEnglish", english);
                        }
                            startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_parah:
//                        Toast.makeText(getApplicationContext(), "Return is Clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","para");
                        if(rb11.isChecked())
                        {
                            urdu="4";
                        }
                        else if(rb12.isChecked())
                        {
                            urdu="5";
                        }
                        if(rb21.isChecked())
                        {
                            english="6";
                        }
                        else if(rb22.isChecked())
                        {
                            english="7";
                        }
                        if(mySwitch.isChecked()) {
                            intent.putExtra("language", "urdu");
                            intent.putExtra("TaUrdu", urdu);
                        }

                        else {
                            intent.putExtra("language", "english");
                            intent.putExtra("TaEnglish", english);

                        }
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    
                }

                return true;
            }
        });


    }

}