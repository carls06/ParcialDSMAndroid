package com.ejemploudb.parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {
    List<ListElement> elements;
    ArrayList<String> ArrayListN;
    ArrayList<String> ArrayListH;
    ArrayList<String> ArrayListC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        getSupportActionBar().hide();

        ArrayListH = new ArrayList<String>();
        ArrayListN = new ArrayList<String>();
        ArrayListC = new ArrayList<String>();

        Bundle data = getIntent().getExtras();
        ArrayListN=data.getStringArrayList("nombres");





        init();
    }


    public void init(){

        Toast.makeText(getApplicationContext(), ArrayListN.size(), Toast.LENGTH_SHORT).show();

        elements= new ArrayList<>();
        elements.add(new ListElement("Carlos Armando Gonzalez","sdasd","sadasd","dasdasd","asdasd","dsf",true,"646"));
        elements.add(new ListElement("Mauricio Velasquez Vega","sdasd","sadasd","dasdasd","asdasd","dsf",false,"646"));
        elements.add(new ListElement("Rodrigo Dionisio Lemus","sdasd","sadasd","dasdasd","asdasd","dsf",true,"646"));

        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView = findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}