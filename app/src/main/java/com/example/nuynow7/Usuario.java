package com.example.nuynow7;

public class Usuario {

    private String nombre;
    private String sexo;
    private Double edad;
    private String email;
    private String direccion;


    public Usuario(String nombre, String sexo, Double edad, String email, String direccion) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.email = email;
        this.direccion = direccion;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getEdad() {
        return edad;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
