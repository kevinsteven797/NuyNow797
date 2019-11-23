package com.example.nuynow7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Buy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
    }

    public void GoFinish(View view){
        Intent gofinish = new Intent(this, Finish.class);
        startActivity(gofinish);
    }
}
