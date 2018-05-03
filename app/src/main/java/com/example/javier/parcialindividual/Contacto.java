package com.example.javier.parcialindividual;

public class Contacto {
    private String Nombre;
    private String Telefono;
    private String Correo;
    private int foto;

    //Creando Constructor
    public Contacto(String nombre, String telefono, String correo, int foto) {
        Nombre = nombre;
        Telefono = telefono;
        Correo = correo;
        this.foto = foto;
    }

    public Contacto() {
    }

    //Creando setters
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }



    //Creando Getters
    public String getNombre() {
        return Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public int getFoto() {
        return foto;
    }


}
