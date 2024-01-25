package com.example.segundoejerciciotema4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public boolean insertar(String name){
        boolean verif=false;
        if (name.isEmpty()){
            bd.execSQL("INSERT INTO articulo (nombre) VALUES (`" + name + "`)");
            verif=true;
        }
        return verif;
    }
    public String consultar(int id){
        //Abrimos la BD en modo lectura/escritura
        bd = baseDatos.getReadableDatabase();

        String query = "SELECT nombre FROM articulo WHERE _id= "+ id;

        Cursor cursor = bd.rawQuery(query,null);
        if (cursor != null) cursor.moveToFirst();
        String name = cursor.getString(1);
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

