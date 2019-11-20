package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {



    private EditText et1, et2;
    private ProgressBar pb;
    private Button btn;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        pb = (ProgressBar) findViewById(R.id.pb);
        btn = (Button) findViewById(R.id.btn);

        pb.setVisibility(View.INVISIBLE); // hace invisible la barra de progreso.

        // El botón que va a escuchar mi acción.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute(et1.getText().toString());
            }
        });

    }



    class Task extends AsyncTask<String, Void, String>
    {

        // Configura la tarea inicial.
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE); // hace visible mi progress bar.
            btn.setEnabled(false); // desactivo mi botón.
        }

        // Aquí va mi proceso o hilo de mayor peso.
        @Override
        protected String doInBackground(String... strings) {
            try
            {
                Thread.sleep(5000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        // se va a realizar después  de la tarea pesada del doInBackground
        @Override
        protected void onPostExecute(String s) {

            btn.setEnabled(true);
            pb.setVisibility(View.INVISIBLE);
            Toast.makeText(getBaseContext(), "Acceso Concedido",
                    Toast.LENGTH_LONG).show();
            // PASAR VALORES CON PUT EXTRA.

            String user = et1.getText().toString();
            String pass = et2.getText().toString();




            Intent i = new Intent(getBaseContext(), Home_act.class);
            i.putExtra("nombre", user);
            i.putExtra("contrasena", pass);
            startActivity(i);

        }
    }




}
