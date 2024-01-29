package com.example.segundoejerciciotema4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class AdapterBD {
    private Context contexto;
    private BaseDatos baseDatos;
    private SQLiteDatabase bd;
    private static AdapterBD adapterBD;
    private AdapterBD(Context c){
//Almacenamos el contexto
        contexto=c;
//Creamos una instancia a la Base de Datos
        baseDatos=new BaseDatos(contexto);

}
    public static AdapterBD getInstance(Context context){
    if (adapterBD == null){
        adapterBD = new AdapterBD(context);
        
    }
    return adapterBD;
    }

    /*public boolean insertar(String name){
        boolean verif = false;
        if (!name.isEmpty()) {
            bd.execSQL("INSERT INTO articulo (nombre) VALUES ('" + name + "')");
            verif = true;
        }
        return verif;
    }*/
    public boolean insertar(String name) {
        boolean verif = false;
        if (!name.isEmpty()) {
            try {
                // Evitar problemas con consultas SQL mal formadas y utilizar PreparedStatement
                String query = "INSERT INTO articulo (nombre) VALUES (?)";
                SQLiteStatement statement = bd.compileStatement(query);
                statement.bindString(1, name);
                statement.executeInsert();

                verif = true;
                Log.d("MyApp", "Insertado correctamente: " + name);
            } catch (Exception e) {
                e.printStackTrace();
                // Manejar cualquier excepción que pueda ocurrir durante la inserción
                Log.e("MyApp", "Error al insertar en la base de datos: " + e.getMessage());
            }
        } else {
            Log.d("MyApp", "No se realizó la inserción porque el nombre está vacío.");
        }
        return verif;
    }



    /* public String consultar(int id){
        //Abrimos la BD en modo lectura/escritura
        bd = baseDatos.getReadableDatabase();

        String query = "SELECT nombre FROM articulo WHERE _id= "+ id;

        Cursor cursor = bd.rawQuery(query,null);
        if (cursor != null) cursor.moveToFirst();
        String name = cursor.getString(1);
        bd.close();

        return name;
    }*/
   public String consultar(int id){
       //Abrimos la BD en modo lectura/escritura
       bd = baseDatos.getReadableDatabase();

       String query = "SELECT nombre FROM articulo WHERE _id= "+ id;

       Cursor cursor = bd.rawQuery(query,null);

       String name = ""; // Inicializa el nombre antes de intentar acceder al cursor

       if (cursor != null && cursor.moveToFirst()) {
           name = cursor.getString(0); // El índice 0 representa la primera columna (nombre)
       }

       if (cursor != null) cursor.close(); // Cierra el cursor para liberar recursos
       bd.close();

       return name;
   }


    public boolean eliminar(int id){
        boolean verif=false;
            String query = "DELETE FROM vivztable WHERE _id= " + id;
            bd.execSQL(query);
            bd.close();
        return verif;
    }

}

