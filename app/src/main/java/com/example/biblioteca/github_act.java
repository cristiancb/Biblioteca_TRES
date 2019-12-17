package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class github_act extends AppCompatActivity {
    private Spinner sp;
    private TextView tv;
    private String[] libros = new String[]{"Farenheith", "Revival", "El Alquimista","El Poder","Despertar"};
    private String[] precios = new String[]{"7000", "22000", "45000","88000","156000"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        sp = (Spinner)findViewById(R.id.spn);
        tv = (TextView)findViewById(R.id.tv);

        Bundle local = getIntent().getExtras();

        String[] libros= local.getStringArray("libros");

        ArrayAdapter adapt = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, libros);

        sp.setAdapter(adapt);



        if(sp.getSelectedItem().equals("Farenheith"))
        {
            String precio = precios[0];

            tv.setText("El valor de Farenheith es: "+precio);
        }

        if(sp.getSelectedItem().equals("Revival"))
        {
            String precio = precios[1];

            tv.setText("El valor de Revival es: "+precio);
        }
        if(sp.getSelectedItem().equals("El Alquimista"))
        {
            String precio = precios[2];

            tv.setText("El valor de El Alquimista es: "+precio);
        }

        if(sp.getSelectedItem().equals("El Poder"))
        {
            String precio = precios[3];

            tv.setText("El valor de El Poder es: "+precio);
        }

        if(sp.getSelectedItem().equals("Despertar"))
        {
            String precio = precios[4];

            tv.setText("El valor de Despertar es: "+precio);
        }
}
}

