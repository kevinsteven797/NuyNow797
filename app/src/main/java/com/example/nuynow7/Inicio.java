package com.example.nuynow7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio2);
    }

    //Metodo de boton siguiente
    public void Siguiente(View view){
        Intent siguiente = new Intent(this, LoadProduct.class);
        Intent gomenu = new Intent(this, Menu.class);
        startActivity(siguiente);
    }

    //Metodo de boton siguiente
    public void GoMenu(View view){
        Intent gomenu = new Intent(this, Menu.class);
        startActivity(gomenu);
    }

    //Metodo de boton siguiente
    public void GoUser(View view){
        Intent gouser = new Intent(this, User.class);
        startActivity(gouser);
    }
}
