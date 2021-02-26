package com.ejemploudb.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton ejercicio1,ejercicio2,ejercicio3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ejercicio1= (ImageButton)findViewById(R.id.btnejer1);
        ejercicio2= (ImageButton)findViewById(R.id.btnejer2);
        ejercicio3= (ImageButton)findViewById(R.id.btnejer3);



        ejercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ejer11 = new Intent(MainActivity.this, ejercicio1.class);
                startActivity(ejer11);
            }
        });

        ejercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ejer22 = new Intent(MainActivity.this, Ejercicio2.class);
                startActivity(ejer22);
            }
        });

        ejercicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ejer33 = new Intent(MainActivity.this, Ejercicio3.class);
                startActivity(ejer33);
            }
        });




    }
}