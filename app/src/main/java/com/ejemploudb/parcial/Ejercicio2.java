package com.ejemploudb.parcial;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
public class Ejercicio2 extends AppCompatActivity {
    Button calcular;
    TextView conteo,contador1,contador2,contador3,contador4,por1,por2,por3,por4;
    ImageButton cand1,cand2,cand3,cand4;
    ArrayList<String> votos = new ArrayList<String>();
    int c1=0,c2=0,c3=0,c4=0;
    int total;
    double   p1=0,p2=0,p3=0,p4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        getSupportActionBar().hide();
        calcular = findViewById(R.id.btncalc);
        conteo = findViewById(R.id.txtconteo);
        cand1 = findViewById(R.id.btn1);
        cand2 = findViewById(R.id.btn2);
        cand3 = findViewById(R.id.btn3);
        cand4 = findViewById(R.id.btn4);
        contador1=findViewById(R.id.cont1);
        contador2=findViewById(R.id.cont2);
        contador3=findViewById(R.id.cont3);
        contador4=findViewById(R.id.cont4);
        por1 = findViewById(R.id.porcentaje1);
        por2 = findViewById(R.id.porcentaje2);
        por3 = findViewById(R.id.porcentaje3);
        por4 = findViewById(R.id.porcentaje4);
    }

    public void candidato1(View view)
    {
        votos.add("1");
        conteo.setText(votos.toString());
    }
    public void candidato2(View view)
    {
        votos.add("2");
        conteo.setText(votos.toString());
    }
    public void candidato3(View view)
    {
        votos.add("3");
        conteo.setText(votos.toString());
    }
    public void candidato4(View view)
    {
        votos.add("4");
        conteo.setText(votos.toString());
    }
    public void limpiar(View view)
    {
        votos.clear();
        conteo.setText("");
        c1=0;
        c2=0;
        c3=0;
        c4=0;
        contador1.setText("");
        contador2.setText("");
        contador3.setText("");
        contador4.setText("");
        por1.setText("");
        por2.setText("");
        por3.setText("");
        por4.setText("");
    }

    public void conteo_votos(View view)
    {
        c1=0;
        c2=0;
        c3=0;
        c4=0;
        por1.setText("");
        por2.setText("");
        por3.setText("");
        por4.setText("");
        total=votos.size();
       for(int i=0;i<votos.size();i++)
       {
           if( votos.get(i) == "1" )
           {
                c1++;
                contador1.setText("Candidato1: "+c1);
           }

           else if (votos.get(i) == "2" )
           {
               c2++;
               contador2.setText("Candidato2: "+c2);
           }

           else if (votos.get(i) == "3" )
           {
               c3++;
               contador3.setText("Candidato3: "+c3);
           }

           else if (votos.get(i) == "4" )
           {
               c4++;
               contador4.setText("Candidato4: "+c4);
           }

           contador1.setText("Candidato1: "+c1);
           contador2.setText("Candidato2: "+c2);
           contador3.setText("Candidato3: "+c3);
           contador4.setText("Candidato4: "+c4);


       }

        p1= (c1 * 100)/total;
        p2= (c2 * 100)/total;
        p3= (c3 * 100)/total;
        p4= (c4 * 100)/total;



        por1.setText("Porcentaje:"+p1+"%");
        por2.setText("Porcentaje:"+p2+"%");
        por3.setText("Porcentaje:"+p3+"%");
        por4.setText("Porcentaje:"+p4+"%");
    }
}