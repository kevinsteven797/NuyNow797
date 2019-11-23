package com.example.nuynow7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
    }

    //Metodo de boton siguiente
    public void Siguiente(View view){
        Intent siguiente = new Intent(this, Inicio.class);
        startActivity(siguiente);
    }
}
