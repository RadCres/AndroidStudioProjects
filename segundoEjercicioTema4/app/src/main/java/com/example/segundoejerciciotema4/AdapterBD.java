package com.example.segundoejerciciotema4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AdapterBD {
    private Context contexto;
    private BaseDatos baseDatos;
    private SQLiteDatabase bd;
    private static AdapterBD adapterBD;
    public AdapterBD(Context c){
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



}
