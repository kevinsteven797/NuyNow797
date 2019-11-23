package com.example.nuynow7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Siguiente(View view){
        Intent siguiente = new Intent(this, LoadProduct.class);
        startActivity(siguiente);
    }

    public void GoWhat(View view){
        Intent gowhat = new Intent(this, WhatIs.class);
        startActivity(gowhat);
    }

    public void GoRecarg(View view){
        Intent gorecarg = new Intent(this, Recarga.class);
        startActivity(gorecarg);
    }

    public void GoTiendas(View view){
        Intent gotiendas = new Intent(this, Tiendas.class);
        startActivity(gotiendas );
    }
}
