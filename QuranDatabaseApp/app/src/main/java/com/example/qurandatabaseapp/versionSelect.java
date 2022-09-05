package com.example.qurandatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class versionSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_select);

        Button button=findViewById(R.id.button);
        Button version2Button=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(versionSelect.this,MainActivity.class);
                intent.putExtra("version","v1");
                startActivity(intent);
            }
        });

        version2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(versionSelect.this,MainActivity.class);
                intent.putExtra("version","v2");
                startActivity(intent);
            }
        });
    }
}