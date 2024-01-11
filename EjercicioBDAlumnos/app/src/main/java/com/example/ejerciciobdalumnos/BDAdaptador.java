package com.example.ejerciciobdalumnos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BDAdaptador {
    private Context contexto;
    private BaseDatos baseDatos;
    private SQLiteDatabase bd;
    public BDAdaptador(Context c){
//Almacenamos el contexto
        contexto=c;
//Creamos una instancia a la Base de Datos
        baseDatos=new BaseDatos(contexto);
    }
//Método para insertar datos en la BD. Recibe los parámetros insertar
    public long insertar(String nombre, String edad, String email){
//Abrimos la BD en modo lectura/escritura
        bd=baseDatos.getWritableDatabase();
//Preparamos la información a insertar
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("edad",edad);
        contentValues.put("email",email);
//Insertarmos los datos. Recogemos el resultado
        long resultado=bd.insert("alumnos",null,contentValues);
//Cerramos la BD
        bd.close();
//Devolvemos el resultado de la inserción
        return resultado;
    }}
