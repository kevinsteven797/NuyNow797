package com.example.nuynow7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText Contraseña,Email;
    Button entrar,registrar;
    String contraseña,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        // La actividad está creada.

        mAuth = FirebaseAuth.getInstance();

        registrar=findViewById(R.id.button2);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Registrar.class);
                startActivity(intent);

            }
        });

        Contraseña=findViewById(R.id.editText3);
        Email=findViewById(R.id.editText2);

    }

    //Metodo de boton siguiente
    public void Siguiente(View view){
        iniciar();
    }

    public void iniciar(){
        contraseña=Contraseña.getText().toString();
        email=Email.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Ingrese un correo",Toast.LENGTH_LONG).show();
            return ;
        }
        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(this,"Ingrese una contraseña",Toast.LENGTH_LONG).show();

            return ;
        }



        mAuth.signInWithEmailAndPassword(email,contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this,"Sesión exitosa",Toast.LENGTH_LONG).show();

                    //inicio exitoso
                    finish();
                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    startActivity(intent);


                }else{
                    Toast.makeText(MainActivity.this,"Datos incorrectos",Toast.LENGTH_LONG).show();

                    // Log.d(TAG, "onComplete: Failed=" + task.getException().getMessage());

                }
            }
        });



    }
}
