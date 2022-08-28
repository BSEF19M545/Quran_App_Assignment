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
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;



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




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_surah:
//                        Toast.makeText(getApplicationContext(), "Book is Clicked", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","surah");
                        if(mySwitch.isChecked())
                            intent.putExtra("language","urdu");
                        else
                            intent.putExtra("language","english");
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_parah:
//                        Toast.makeText(getApplicationContext(), "Return is Clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","para");
                        if(mySwitch.isChecked())
                            intent.putExtra("language","urdu");
                        else
                            intent.putExtra("language","english");

                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }

                return true;
            }
        });


    }

}