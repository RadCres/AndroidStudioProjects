package com.example.segundoejerciciotema4;

import android.content.Context;
import android.database.Cursor;
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
    public String consultar(int id){
        //Abrimos la BD en modo lectura/escritura
        bd = baseDatos.getReadableDatabase();

        String query = "Select nombre FROM articulo where iden="+1;

        Cursor cursor = bd.rawQuery(query,null);
        if (cursor != null) cursor.moveToFirst();
        String name = cursor.getString(0);
        bd.close();

        return name;
    }

    public String insertar(){
        bd.execSQL("INSERT INTO articulo ()");
        String name = null;
        return name;
    }


}

