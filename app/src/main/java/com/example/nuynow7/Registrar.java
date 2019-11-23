package com.example.nuynow7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Registrar extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    Button REGISTRAR;
    EditText NOMBRE,SEXO,EDAD,EMAIL,DIRECCION,CONTRASEÑA;
    String nombre,sexo,email,direccion,contraseña;
    Double edad=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        mAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        REGISTRAR=findViewById(R.id.button12);
        REGISTRAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registrar();

            }
        });

        NOMBRE=findViewById(R.id.editText10);
        SEXO=findViewById(R.id.editText4);
        EDAD=findViewById(R.id.editText6);
        EMAIL=findViewById(R.id.editText7);
        DIRECCION=findViewById(R.id.editText8);
        CONTRASEÑA=findViewById(R.id.editText9);



    }



    public void registrar(){
        nombre= NOMBRE.getText().toString().trim();
        sexo= SEXO.getText().toString().trim();
        edad= Double.parseDouble((EDAD.getText().toString()));
        email= EMAIL.getText().toString().trim();
        direccion= DIRECCION.getText().toString().trim();
        contraseña= CONTRASEÑA.getText().toString().trim();

        if(TextUtils.isEmpty(nombre)){
            Toast.makeText(this,"Falta ingresar un nombre",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Falta ingresar un correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(this,"Falta ingresar un contraseña",Toast.LENGTH_LONG).show();
            return;
        }else if(contraseña.length()<8){
            Toast.makeText(this,"La contraseña debe tener almenos una longitud de 8",Toast.LENGTH_LONG).show();
        }

        // registrar en Auth
        mAuth.createUserWithEmailAndPassword(email, contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            crearUser(nombre,sexo,edad,email,direccion);
                            finish();
                            Intent intent = new Intent(getApplicationContext(), Menu.class);
                            startActivity(intent);

                        }else{
                            // No se ha registrado correctamente
                            Toast.makeText(Registrar.this,"Datos incorrectos",Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }

    public void crearUser(String nombre, String sexo, double edad, String email,String direccion){
        String id=databaseReference.push().getKey();
        Usuario usuario=new Usuario(nombre,sexo,edad,email,direccion);
        databaseReference.child("usuario").child(id).setValue(usuario);
        Toast.makeText(Registrar.this,"Registro exitoso ",Toast.LENGTH_LONG).show();

    }

}
