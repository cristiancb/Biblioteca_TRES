package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_act extends AppCompatActivity {

    private EditText et1,et2,et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
    }

    public void Añadir(View view){
        AdminSQLiteOpenHelper BD = new AdminSQLiteOpenHelper(this ,"BIBLIOTECA", null,1);
        SQLiteDatabase BIBLIOTECA = BD.getWritableDatabase();

        if(!et1.getText().toString().isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("CODIGO",et1.getText().toString());
            registro.put("NOMBRE",et2.getText().toString());
            registro.put("PRECIO",et3.getText().toString());

            BIBLIOTECA.insert("LIBROS",null,registro);
            BIBLIOTECA.close();
            Toast.makeText(this, "Producto Ingresado",Toast.LENGTH_LONG).show();
        }


    }

    public void Modificar(View view){

        AdminSQLiteOpenHelper BD = new AdminSQLiteOpenHelper(this ,"BIBLIOTECA", null,1);
        SQLiteDatabase BIBLIOTECA = BD.getWritableDatabase();
        String codigo = et1.getText().toString();
        ContentValues cont = new ContentValues();
        cont.put("CODIGO",et1.getText().toString() );
        cont.put("NOMBRE",et2.getText().toString() );
        cont.put("PRECIO",et3.getText().toString() );


        if(!et1.getText().toString().isEmpty()) {

            BIBLIOTECA.update("LIBROS", cont, "CODIGO=" + codigo, null);
            BIBLIOTECA.close();
            Toast.makeText(this, "Producto Modificado Código " + codigo, Toast.LENGTH_LONG).show();

        }

    }

    public void Eliminar(View view){
        AdminSQLiteOpenHelper BD = new AdminSQLiteOpenHelper(this ,"BIBLIOTECA", null,1);
        SQLiteDatabase BIBLIOTECA = BD.getWritableDatabase();

        String codigo = et1.getText().toString();
        BIBLIOTECA.delete("LIBROS", "CODIGO="+codigo, null);
        BIBLIOTECA.close();
        Toast.makeText(this, "Producto Eliminado Código "+codigo,Toast.LENGTH_LONG).show();






    }
}
