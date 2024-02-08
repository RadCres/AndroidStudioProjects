package com.example.examenraulsegundaeva;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class BaseDatos extends SQLiteOpenHelper {
    Context contexto;

    public BaseDatos(Context context) {
        super(context,"HuertoHanirna.db", null, 2);
        contexto = context;
    }

    @Override
    //onCreate se ejecuta cuando se CREA la BD
    public void onCreate(SQLiteDatabase db) {
        try {
            //Creamos la tabla
            db.execSQL("CREATE TABLE  tipoplanta (\n" +
                    "   idTipo  int(11) NOT NULL,\n" +
                    "   NombreTipo  varchar(100) DEFAULT NULL,\n" +
                    "  PRIMARY KEY ( idTipo )\n" +
                    ");");

            db.execSQL("CREATE TABLE  plantacion  (\n" +
                    "   idPlantacion  int(11) NOT NULL,\n" +
                    "   nombrePlanta  varchar(100) DEFAULT NULL,\n" +
                    "   numPlantas  int(11) DEFAULT NULL,\n" +
                    "   grupoClase  varchar(20) DEFAULT NULL,\n" +
                    "   idTipo  int(11) ,\n" +
                    "  PRIMARY KEY ( idPlantacion ),\n" +
                    "  FOREIGN KEY ( idTipo ) REFERENCES  tipoplanta  ( idTipo )\n" +
                    ");");
            insertarDatos(db);
        }
        catch (SQLException e){
            //Mensaje de error si no se ha ejecutado correctamente
            Toast.makeText(contexto,""+e,Toast.LENGTH_SHORT).show();
        }
    }

    //onUpgrade se ejecuta cuando se ACTUALIZA la versíon de la BD
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            //Eliminamos la tabla anterior (si existe)
            db.execSQL("DROP TABLE IF EXISTS  tipoplanta;");
            db.execSQL("DROP TABLE IF EXISTS  plantacion;");

            //Llamamos a onCreate para que cree la tabla con las nuevas especificaciones
            onCreate(db);
        }
        catch (SQLException e){
            //Mensaje de error si no se ha ejecutado correctamente
            Toast.makeText(contexto,""+e,Toast.LENGTH_SHORT).show();
        }

    }
    public void insertarDatos (SQLiteDatabase db){
        //Insert tipoplanta
        db.execSQL("INSERT INTO  tipoplanta  VALUES (1, 'Hortaliza');");
        db.execSQL("INSERT INTO  tipoplanta  VALUES (2, 'Verdura');");

        //Insert plantacion
        db.execSQL("INSERT INTO  plantacion  VALUES (1,'patatas',20,'1A',1);");
        db.execSQL("INSERT INTO  plantacion  VALUES (2,'tomates',30,'2B',2);");

    }

}

