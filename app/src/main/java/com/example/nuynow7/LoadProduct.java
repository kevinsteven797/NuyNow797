package com.example.nuynow7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoadProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_product);
    }

    public void GoBuy(View view){
        Intent gobuy = new Intent(this, Buy.class);
        startActivity(gobuy);
    }
}
