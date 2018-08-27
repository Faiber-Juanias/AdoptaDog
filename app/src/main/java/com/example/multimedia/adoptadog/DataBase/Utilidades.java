package com.example.multimedia.adoptadog.DataBase;

public class Utilidades {
    //Constantes para la tabla Dog
    public static final String TBL_PERRO = "Dog";
    public static final String ID = "Id";
    public static final String IMAGEN = "Imagen";
    public static final String NOMBRE = "Nombre";
    public static final String EDAD = "Edad";
    public static final String RAZA = "Raza";
    public static final String GENERO = "Genero";
    public static final String CREATE_TBL_PERRO = "CREATE TABLE " + TBL_PERRO + " (" +
            ID + " INTEGER PRIMARY_KEY, " +
            IMAGEN + " INTEGER, " +
            NOMBRE + " TEXT, " +
            EDAD + " INTEGER, " +
            RAZA + " TEXT, " +
            GENERO + " TEXT)";
}
