package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Sec_act extends AppCompatActivity {

    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_act);

        btn = (Button) findViewById(R.id.btn);
        tv = (TextView)findViewById(R.id.tv);
    }
    public void Incidencia(View v)
    {
        tv.setText("Cryptographic Issues");
    }

    public void Incidenciados(View v)
    {
        tv.setText("Process Control");
    }


}
