package com.example.multimedia.adoptadog.DataDog;

public class Dog {
    private int id;
    private int imagen;
    private String nombre;
    private int edad;
    private String raza;
    private String genero;

    public Dog(int id, int imagen, String nombre, int edad, String raza, String genero) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }

    public String getGenero() {
        return genero;
    }
}
