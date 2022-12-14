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
import android.view.View;
import android.widget.Button;
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


        //Switch mySwitch = findViewById(R.id.myswitch);
        Switch mySwitch=(Switch) navigationView.getMenu().findItem(R.id.language).getActionView();

        english="6";
         urdu="4";
        /*RadioGroup rGroup = (RadioGroup)findViewById(R.id.rg1);
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
        });*/
        Button sura_button,para_button;




        boolean languageSelector=false;



        RadioButton rbUrdu1=(RadioButton) navigationView.getMenu().findItem(R.id.urdu1).getActionView();
        rbUrdu1.setChecked(true);
        RadioButton rbUrdu2=(RadioButton) navigationView.getMenu().findItem(R.id.urdu2).getActionView();

        RadioButton rbEnglish1=(RadioButton) navigationView.getMenu().findItem(R.id.english1).getActionView();
        rbEnglish1.setChecked(true);
        RadioButton rbEnglish2=(RadioButton) navigationView.getMenu().findItem(R.id.english2).getActionView();

        sura_button=findViewById(R.id.sura_button);
        para_button=findViewById(R.id.para_button);
        sura_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, view1.class);
                intent.putExtra("type","surah");
                if(getIntent().getStringExtra("version").equals("v1")) {
                    if (mySwitch.isChecked()) {
                        if (rbUrdu2.isChecked())
                            urdu = "5";
                        intent.putExtra("language", "urdu");
                        intent.putExtra("version", "v1");
                        intent.putExtra("TaUrdu", urdu);

                    } else {
                        if (rbEnglish2.isChecked())
                            english = "7";
                        intent.putExtra("language", "english");
                        intent.putExtra("version", "v1");
                        intent.putExtra("TaEnglish", english);
                    }
                }
                else{
                    if (rbUrdu2.isChecked())
                        urdu = "5";
                    //intent.putExtra("language", "urdu");
                    intent.putExtra("TaUrdu", urdu);
                    if (rbEnglish2.isChecked())
                        english = "7";
                    //intent.putExtra("language", "english");
                    intent.putExtra("TaEnglish", english);

                    intent.putExtra("version", "v2");


                }
                startActivity(intent);
            }
        });

        para_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, view1.class);
                intent = new Intent(MainActivity.this, view1.class);
                intent.putExtra("type","para");
                if(getIntent().getStringExtra("version").equals("v1")) {

                    if (mySwitch.isChecked()) {
                        if (rbUrdu2.isChecked())
                            urdu = "5";
                        intent.putExtra("language", "urdu");
                        intent.putExtra("TaUrdu", urdu);
                        intent.putExtra("version", "v1");

                    } else {
                        if (rbEnglish2.isChecked())
                            english = "7";
                        intent.putExtra("language", "english");
                        intent.putExtra("TaEnglish", english);
                        intent.putExtra("version", "v1");


                    }
                }
                else{
                    if (rbUrdu2.isChecked())
                        urdu = "5";
                    //intent.putExtra("language", "urdu");
                    intent.putExtra("TaUrdu", urdu);
                    if (rbEnglish2.isChecked())
                        english = "7";
                    //intent.putExtra("language", "english");
                    intent.putExtra("TaEnglish", english);
                    intent.putExtra("version", "v2");

                }
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    /*case R.id.nav_surah:
                        Intent intent = new Intent(MainActivity.this, view1.class);
                        intent.putExtra("type","surah");

                        if(mySwitch.isChecked()) {
                            if(rbUrdu2.isChecked())
                                urdu="5";
                            intent.putExtra("language", "urdu");
                            intent.putExtra("TaUrdu", urdu);
                        }
                        else{
                            if(rbEnglish2.isChecked())
                                english="7";
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
                            if(rbUrdu2.isChecked())
                                urdu="5";
                            intent.putExtra("language", "urdu");
                            intent.putExtra("TaUrdu", urdu);
                        }

                        else {
                            if(rbEnglish2.isChecked())
                                english="7";
                            intent.putExtra("language", "english");
                            intent.putExtra("TaEnglish", english);

                        }
                        startActivity(intent);
                        break;*/
                    case R.id.language:
//                        Switch sw=(Switch) navigationView.getMenu().findItem(R.id.language).getActionView();
                        /*if(sw.isChecked())
                            Toast.makeText(MainActivity.this, "Urdu", Toast.LENGTH_SHORT).show();*/

                        break;
                    case R.id.urdu1:

                        RadioButton rb=(RadioButton) navigationView.getMenu().findItem(R.id.urdu1).getActionView();
                        RadioButton rb2=(RadioButton) navigationView.getMenu().findItem(R.id.urdu2).getActionView();
//                        rb.setChecked(true);
                        if(!rb.isChecked())
                        {
                            //rb.setChecked(false);
//                            Toast.makeText(MainActivity.this, " urdu Checked", Toast.LENGTH_SHORT).show();
                            rb.setChecked(true);
                        }
//                        else if(!rb.isChecked())
//                        {
//                            rb.setChecked(true);
//                        }
                        if(rb.isChecked())
                        {
                            rb2.setChecked(false);
                        }

                        break;
                    case R.id.urdu2:

                        RadioButton rb21=(RadioButton) navigationView.getMenu().findItem(R.id.urdu1).getActionView();
                        RadioButton rb22=(RadioButton) navigationView.getMenu().findItem(R.id.urdu2).getActionView();
                        if(!rb22.isChecked())
                        {
                            //rb22.setChecked(false);
//                            Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                            rb22.setChecked(true);
                        }
//                        else
//                        {
//                            rb22.setChecked(true);
//                        }
                        if(rb22.isChecked())
                        {
                            rb21.setChecked(false);
                        }
                        break;
                    case R.id.english1:

                        RadioButton rbe1=(RadioButton) navigationView.getMenu().findItem(R.id.english1).getActionView();
                        RadioButton rbe2=(RadioButton) navigationView.getMenu().findItem(R.id.english2).getActionView();
//                        rb.setChecked(true);
                        if(!rbe1.isChecked())
                        {
                            //rb.setChecked(false);
//                            Toast.makeText(MainActivity.this, " urdu Checked", Toast.LENGTH_SHORT).show();
                            rbe1.setChecked(true);
                        }
//                        else if(!rb.isChecked())
//                        {
//                            rb.setChecked(true);
//                        }
                        if(rbe1.isChecked())
                        {
                            rbe2.setChecked(false);
                        }

                        break;

                    case R.id.english2:

                        RadioButton rbe21=(RadioButton) navigationView.getMenu().findItem(R.id.english1).getActionView();
                        RadioButton rbe22=(RadioButton) navigationView.getMenu().findItem(R.id.english2).getActionView();
                        if(!rbe22.isChecked())
                        {
                            //rb22.setChecked(false);
//                            Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                            rbe22.setChecked(true);
                        }
//                        else
//                        {
//                            rb22.setChecked(true);
//                        }
                        if(rbe22.isChecked())
                        {
                            rbe21.setChecked(false);
                        }
                        break;

                }

                return true;
            }
        });


    }

}