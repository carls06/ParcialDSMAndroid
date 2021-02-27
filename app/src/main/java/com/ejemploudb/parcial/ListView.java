package com.ejemploudb.parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {

    TextView txt1,txt2;
    double desc, aumento;

    List<ListElement> elements;


    String[] ArrayListN = new String[3];
    String[] ArrayListC = new String[3];
    int[] ArrayListH = new int[3];
    double[] salbas=new double[3];
    double[] salaliq=new  double[3];
    double[] ISSS= new double[3];
    double[] AFP = new double[3];
    double[] RENTA= new double[3];
    double[] pagobono= new double[3];
    boolean[] bono= new boolean[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        getSupportActionBar().hide();

        txt1=findViewById(R.id.textView5);
        txt2=findViewById(R.id.textView4);



        ArrayListN = getIntent().getStringArrayExtra("nombre");
        ArrayListC = getIntent().getStringArrayExtra("cargo");
        ArrayListH=getIntent().getIntArrayExtra("horas");


        calculos();
        textos();
        init();
    }


    public void init(){



        elements= new ArrayList<>();
        elements.add(new ListElement(""+ArrayListN[0],"Cargo: "+ArrayListC[0],"Horas: "+ArrayListH[0],"Sueldo Base: $"+salbas[0],"ISSS: $"+ISSS[0]+"\n AFP: $"+AFP[0]+"\n Renta: $"+RENTA[0],"Pago Liquido: $"+salaliq[0],bono[0],"A Pagar $"+pagobono[0]));
        elements.add(new ListElement(""+ArrayListN[1],"Cargo: "+ArrayListC[1],"Horas: "+ArrayListH[1],"Sueldo Base: $"+salbas[1],"ISSS: $"+ISSS[1]+"\n AFP: $"+AFP[1]+"\n Renta: $"+RENTA[1],"Pago Liquido: $"+salaliq[1],bono[1],"A Pagar $"+pagobono[1]));
        elements.add(new ListElement(""+ArrayListN[2],"Cargo: "+ArrayListC[2],"Horas: "+ArrayListH[2],"Sueldo Base: $"+salbas[2],"ISSS: $"+ISSS[2]+"\n AFP: $"+AFP[2]+"\n Renta: $"+RENTA[2],"Pago Liquido: $"+salaliq[2],bono[2],"A Pagar $"+pagobono[2]));

        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView recyclerView = findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    public void calculos() {

       for (int i=0;i<ArrayListH.length;i++){
           if(ArrayListC[0].equals("Gerente")&&ArrayListC[1].equals("Asistente")&&ArrayListC[2].equals("Secretaria")){
               bono[i]=false;


               Toast.makeText(getApplicationContext(), "No hay Bono", Toast.LENGTH_SHORT).show();
               if(ArrayListH[i]<=160){

                   salbas[i]=ArrayListH[i]*9.75;

                   ISSS[i]=(salbas[i]*0.525)/100;
                   AFP[i]=(salbas[i]*0.688)/100;
                   RENTA[i]=(salbas[i]*0.1)/100;

                   desc=ISSS[i]+AFP[i]+RENTA[i];
                   salaliq[i]=salbas[i]-desc;
                   pagobono[i]=salaliq[i];


               }else if (ArrayListH[i]>160){
                   int horasmas;
                   double horasnormales;
                   horasmas=ArrayListH[i]-160;
                   horasnormales=160*9.75;
                   salbas[i]=(horasmas*11.50)+horasnormales;

                   ISSS[i]=(salbas[i]*0.525)/100;
                   AFP[i]=(salbas[i]*0.688)/100;
                   RENTA[i]=(salbas[i]*0.1)/100;

                   desc=ISSS[i]+AFP[i]+RENTA[i];
                   salaliq[i]=salbas[i]-desc;
                   pagobono[i]=salaliq[i];


               }

           }else {

               if(ArrayListH[i]<=160){


                       bono[i]=true;



                   salbas[i]=ArrayListH[i]*9.75;

                   ISSS[i]=(salbas[i]*0.525)/100;
                   AFP[i]=(salbas[i]*0.688)/100;
                   RENTA[i]=(salbas[i]*0.1)/100;

                   desc=ISSS[i]+AFP[i]+RENTA[i];
                   salaliq[i]=salbas[i]-desc;

                   if (bono[i] && ArrayListC[i].equals("Gerente")){
                       aumento=salaliq[i]*0.1;
                       pagobono[i]=salaliq[i]+aumento;
                   }
                   if (bono[i] && ArrayListC[i].equals("Secretaria")){
                       aumento=salaliq[i]*0.02;
                       pagobono[i]=salaliq[i]+aumento;
                   }
                   if (bono[i] && ArrayListC[i].equals("Asistente")){
                       aumento=salaliq[i]*0.03;
                       pagobono[i]=salaliq[i]+aumento;
                   }


               }else if (ArrayListH[i]>160){
                   int horasmas;
                   double horasnormales;
                   horasmas=ArrayListH[i]-160;
                   horasnormales=160*9.75;
                   salbas[i]=(horasmas*11.50)+horasnormales;

                   ISSS[i]=(salbas[i]*0.525)/100;
                   AFP[i]=(salbas[i]*0.688)/100;
                   RENTA[i]=(salbas[i]*0.1)/100;

                   desc=ISSS[i]+AFP[i]+RENTA[i];
                   salaliq[i]=salbas[i]-desc;

                   if (bono[i] && ArrayListC[i].equals("Gerente")){
                       aumento=salaliq[i]*0.1;
                       pagobono[i]=salaliq[i]+aumento;
                   }
                   if (bono[i] && ArrayListC[i].equals("Secretaria")){
                       aumento=salaliq[i]*0.02;
                       pagobono[i]=salaliq[i]+aumento;
                   }
                   if (bono[i] && ArrayListC[i].equals("Asistente")){
                       aumento=salaliq[i]*0.03;
                       pagobono[i]=salaliq[i]+aumento;
                   }



               }
           }


       }

    }

    public void textos(){
        int indiceDelMayor = 0;
        // Recorrer arreglo y ver si no es así
        // (comenzar desde el 1 porque el 0 ya lo tenemos contemplado arriba)
        for (int x = 1; x < salaliq.length; x++) {
            if (salaliq[x] > salaliq[indiceDelMayor]) {
                indiceDelMayor = x;
            }
        }
        // Ahora podemos obtener el mayor usando la posición
        double mayor = salaliq[indiceDelMayor];

        txt2.setText("El Empleado que mas gana es: "+ArrayListN[indiceDelMayor]);
        txt1.setText("$"+mayor);

    }
}