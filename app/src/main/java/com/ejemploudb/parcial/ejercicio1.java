package com.ejemploudb.parcial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ejercicio1 extends AppCompatActivity {

    Button calcular;
    EditText a,b,c;
    TextView x1,x2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        calcular=findViewById(R.id.button);
        a=findViewById(R.id.edta);
        b=findViewById(R.id.edtb);
        c=findViewById(R.id.edtc);
        x1= findViewById(R.id.txt1);
        x2= findViewById(R.id.txt2);

    }


   @RequiresApi(api = Build.VERSION_CODES.M)
   public void calcular_valores(View view)
    {
        try {


            double A, B, C;
            double R1, R2;
            double inside;

            View view1 = this.getCurrentFocus();
            view1.clearFocus();

            A = Double.parseDouble(a.getText().toString());
            B = Double.parseDouble(b.getText().toString());
            C = Double.parseDouble(c.getText().toString());

            inside = ((Math.pow(B, 2)) - 4 * A * C);

            if (inside<0)
            {
                Toast.makeText(getApplicationContext(), "No existen ecuaciones reales para esta ecuacion", Toast.LENGTH_SHORT).show();
                x1.setText("X1: ");
                x2.setText("X2: ");

                if (view1 != null)
                {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                b.setText("");
                b.setText("");
                c.setText("");


            }

            else{
                    R1 = (-B + Math.sqrt(inside)) / (2 * A);
                    R2 = (-B - Math.sqrt(inside)) / (2 * A);

                    x1.setText("X1: " + R1);
                    x2.setText("X2: " + R2);

                    a.setText("");
                    b.setText("");
                    c.setText("");

                    //para esconder el teclado despues de apretar el boton


                    if (view1 != null)
                    {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                 }
        }

        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Digite otros numeros", Toast.LENGTH_SHORT).show();
        }



    }

}