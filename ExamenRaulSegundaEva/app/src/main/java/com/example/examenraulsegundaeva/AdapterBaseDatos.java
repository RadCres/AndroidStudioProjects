package com.example.examenraulsegundaeva;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class AdapterBaseDatos {

    private Context context;
    private BaseDatos baseDatos;
    private static AdapterBaseDatos adapterBD;
    private SQLiteDatabase bd;

    private AdapterBaseDatos(Context c){
        context = c;
        baseDatos = new BaseDatos(context);
    }
    public static AdapterBaseDatos getInstance(Context context){
        if (adapterBD ==null){
            adapterBD = new AdapterBaseDatos(context);
        }
        return adapterBD;
    }


    public String consultarPlantacion(int id){
        bd = baseDatos.getReadableDatabase();
        String datos="";
        String query = "SELECT * FROM plantacion WHERE idPlantacion = " + id;
        Cursor cursor = bd.rawQuery(query,null);
        if (cursor != null &&  cursor.moveToFirst()){

            datos = cursor.getString(0)+"-"+cursor.getString(1)+"-"+
                    cursor.getString(2)+"-"+cursor.getString(3)+"-"+
                    cursor.getString(4);
        } if (cursor != null) {
            cursor.close();
        }
        bd.close();
        return datos;
    }



    public Long insertar(int idPlantacion, String nombrePlanta, int numPlantas, String grupoClase, int idTipo){
        bd =baseDatos.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idPlantacion", idPlantacion);
        contentValues.put("nombrePlanta", nombrePlanta);
        contentValues.put("numPlantas", numPlantas);
        contentValues.put("grupoClase", grupoClase);
        contentValues.put("idTipo", idTipo);
        Long plantacion = bd.insert("plantacion",null,contentValues);
        bd.close();
        return plantacion;
    }

    public boolean setPlantacion(int idPlantacion, String nombrePlanta, int numPlantas, String grupoClase, int idTipo) {
        bd = baseDatos.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nombrePlanta", nombrePlanta);
            contentValues.put("numPlantas", numPlantas);
            contentValues.put("grupoClase", grupoClase);
            contentValues.put("idTipo", idTipo);

            int filasAfectadas = bd.update("plantacion", contentValues, "idPlantacion=?", new String[]{String.valueOf(idPlantacion)});

            return filasAfectadas > 0;
        } finally {
            bd.close();
        }
    }


}
