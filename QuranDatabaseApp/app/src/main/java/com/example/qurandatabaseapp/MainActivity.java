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
         english="6";
         urdu="4";
        RadioGroup rGroup = (RadioGroup)findViewById(R.id.rg1);
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked)
                {
                    if(checkedRadioButton.getText().toString().equals("Dr Mohsin Khan"))
                    {
                        english="6";
//                        Toast.makeText(MainActivity.this, checkedRadioButton.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        english="7";
//                        Toast.makeText(MainActivity.this, checkedRadioButton.getText().toString(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        RadioGroup rGroup2 = (RadioGroup)findViewById(R.id.rg2);
        rGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked)
                {
                    if(checkedRadioButton.getText().toString().equals("Fateh Muhammad Jalandhri"))
                    {
                        urdu="4";
//                        Toast.makeText(MainActivity.this, checkedRadioButton.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        urdu="5";
//                        Toast.makeText(MainActivity.this, checkedRadioButton.getText().toString(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_surah:
                        Intent intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","surah");

                        if(mySwitch.isChecked()) {
                            intent.putExtra("language", "urdu");
                            intent.putExtra("TaUrdu", urdu);
                        }
                        else{
                            intent.putExtra("language", "english");
                            intent.putExtra("TaEnglish", english);
                        }
                            startActivity(intent);
                        break;

                    case R.id.nav_parah:
//                        Toast.makeText(getApplicationContext(), "Return is Clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","para");

                        if(mySwitch.isChecked()) {
                            intent.putExtra("language", "urdu");
                            intent.putExtra("TaUrdu", urdu);
                        }

                        else {
                            intent.putExtra("language", "english");
                            intent.putExtra("TaEnglish", english);

                        }
                        startActivity(intent);
                        break;

                    
                }

                return true;
            }
        });


    }

}