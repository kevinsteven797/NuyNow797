package com.example.nuynow7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tiendas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiendas);
    }

    public void Siguiente(View view){
        Intent siguiente = new Intent(this, LoadProduct.class);
        Intent gomenu = new Intent(this, Menu.class);
        startActivity(siguiente);
    }
}
