package com.example.segundoejerciciotema4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class AdapterBD{
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

    public Long insertar(String name){
        bd =baseDatos.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", name);
        Long longito = bd.insert("articulo",null,contentValues);
        bd.close();
        return longito;
    }
    public String consultar(int id){

        //Abrimos la BD en modo lectura/escritura
        bd = baseDatos.getReadableDatabase();
        String query = "SELECT nombre FROM articulo WHERE _id = "+ id;
        Log.e("miapp", query);
        Cursor cursor = bd.rawQuery(query,null);
        String name="";
        if (cursor != null){
            cursor.moveToFirst();
            name = cursor.getString(0);
        }
        bd.close();
        return name;
    }

    public void eliminar(int id){
            bd = baseDatos.getWritableDatabase();
            String query = "DELETE FROM articulo WHERE _id = " + id;
            bd.execSQL(query);
            bd.close();
    }

    public void modificar(int id, String name){
        bd = baseDatos.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",name);
        bd.update("articulo",contentValues, "_id = ?", new String[]{String.valueOf(id)});

        bd.close();
    }
    public void modificarFACIL(int id, String name){
        bd = baseDatos.getWritableDatabase();
        String query = "UPDATE articulo set nombre = " + name + "WHERE _id = " + id;
        bd.close();
    }
}

