package com.ejemploudb.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Ejercicio3 extends AppCompatActivity {
    String seleccion;
    Spinner spinner;
    EditText edt1, edt2;
    ArrayList<String> ArrayListN;
    ArrayList<String> ArrayListH;
    ArrayList<String> ArrayListC;
    int count=0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        getSupportActionBar().hide();
         spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cargos_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
         intent = new Intent(this,ListView.class);
        spinner.setAdapter(adapter);
        ArrayListH = new ArrayList<String>();
        ArrayListN = new ArrayList<String>();
        ArrayListC = new ArrayList<String>();
        edt1=findViewById(R.id.edtNombre);
        edt2=findViewById(R.id.edthoras);


    }

    public void Send(View view) {
        count++;
        seleccion = spinner.getSelectedItem().toString();
        String a = String.valueOf(edt1.getText());
        String b = String.valueOf(edt2.getText());
        try {

            if (count==1){
                count++;
                ArrayListN.add(0,a);
                ArrayListH.add(0,b);
                ArrayListC.add(0,seleccion);
                Toast.makeText(getApplicationContext(), "Primer Trabajador Agregado", Toast.LENGTH_SHORT).show();
                edt1.setText("");
                edt2.setText("");
                seleccion="";
            }else if (count==2){
                count++;
                ArrayListN.add(1,a);
                ArrayListH.add(1,b);
                ArrayListC.add(1,seleccion);
                Toast.makeText(getApplicationContext(), "Segundo Trabajador Agregado", Toast.LENGTH_SHORT).show();
                edt1.setText("");
                edt2.setText("");
            }else if (count==3){
                count=0;
                ArrayListN.add(2,a);
                ArrayListH.add(2,b);
                ArrayListC.add(2,seleccion);
                Toast.makeText(getApplicationContext(), "Tercer Trabajador Agregado", Toast.LENGTH_SHORT).show();
                edt1.setText("");
                edt2.setText("");


                intent.putExtra("nombre",ArrayListN);
                intent.putExtra("horas",ArrayListH);
                intent.putExtra("cargo",ArrayListC);

                startActivityForResult(intent,10);
            }





        }catch (Exception e){
             Toast.makeText(getApplicationContext(), "Llenar Los datos Pedidos", Toast.LENGTH_SHORT).show();
        }


    }

    public void cerrar(View view) {
    }
}