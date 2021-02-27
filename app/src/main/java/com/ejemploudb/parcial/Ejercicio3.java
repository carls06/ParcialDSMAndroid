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
    //ArrayList<String> ArrayListN;
    String[] ArrayListN = new String[3];
    int[] ArrayListH = new int[3];
    String[] ArrayListC = new String[3];
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
        edt1=findViewById(R.id.edtNombre);
        edt2=findViewById(R.id.edthoras);
        edt1.setText("");
        edt2.setText("");
        seleccion="";


    }

    public void Send(View view) {
        count++;

        try {
            seleccion = spinner.getSelectedItem().toString();
            String a = String.valueOf(edt1.getText());
            Integer b = Integer.valueOf(edt2.getText().toString());
            if (count==1){
                if(seleccion.equals("Seleccione Cargo")){
                    Toast.makeText(getApplicationContext(), "Seleccione Cargo", Toast.LENGTH_SHORT).show();
                    count--;
                }else {
                    ArrayListN[0]=a;
                    ArrayListH[0]=b;
                    ArrayListC[0]=seleccion;
                    Toast.makeText(getApplicationContext(), "Primer Trabajador Agregado", Toast.LENGTH_SHORT).show();
                    edt1.setText("");
                    edt2.setText("");
                    seleccion="";
                }
            }else if (count==2){
                if(seleccion.equals("Seleccione Cargo")){
                    Toast.makeText(getApplicationContext(), "Seleccione Cargo", Toast.LENGTH_SHORT).show();
                    count--;
                }else {
                ArrayListN[1]=a;
                ArrayListH[1]=b;
                ArrayListC[1]=seleccion;
                Toast.makeText(getApplicationContext(), "Segundo Trabajador Agregado", Toast.LENGTH_SHORT).show();
                edt1.setText("");
                edt2.setText("");
                seleccion="";
                }
            }else if (count==3){
                if(seleccion.equals("Seleccione Cargo")){
                    Toast.makeText(getApplicationContext(), "Seleccione Cargo", Toast.LENGTH_SHORT).show();
                    count--;
                }else {
                    ArrayListN[2] = a;
                    ArrayListH[2] = b;
                    ArrayListC[2] = seleccion;

                    Toast.makeText(getApplicationContext(), "Tercer Trabajador Agregado", Toast.LENGTH_SHORT).show();

                    intent.putExtra("nombre", ArrayListN);
                    intent.putExtra("cargo", ArrayListC);
                    intent.putExtra("horas", ArrayListH);


                    startActivityForResult(intent, 10);
                    count = 0;
                }
            }





        }catch (Exception e){
             if (count==0){
                 count=0;
                 Toast.makeText(getApplicationContext(), "Llenar Los datos Pedidos", Toast.LENGTH_SHORT).show();
             }else {
                 Toast.makeText(getApplicationContext(), "Llenar Los datos Pedidos", Toast.LENGTH_SHORT).show();
                 count--;
             }
        }


    }

    public void cerrar(View view) {
    }
}