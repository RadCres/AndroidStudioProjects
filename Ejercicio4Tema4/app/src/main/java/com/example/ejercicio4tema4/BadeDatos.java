package com.example.ejercicio4tema4;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class BadeDatos extends SQLiteOpenHelper {
    Context contexto;

    public BadeDatos(Context context) {
        super(context,"DEPARTAMENTOS.db", null, 1);
        contexto = context;
    }


    @Override
    //onCreate se ejecuta cuando se CREA la BD
    public void onCreate(SQLiteDatabase db) {
        try {
            //Creamos la tabla
            db.execSQL("CREATE TABLE  departamentos  (\n" +
                    "   NumeroDepartamento  int(11) NOT NULL,\n" +
                    "   Nombre  varchar(50) DEFAULT NULL,\n" +
                    "   Presupuesto  decimal(10,2) DEFAULT NULL,\n" +
                    "  PRIMARY KEY ( NumeroDepartamento )\n" +
                    ");");

            db.execSQL("CREATE TABLE  empleados  (\n" +
                    "   NumeroEmpleado  int(11) NOT NULL,\n" +
                    "   Nombre  varchar(50) DEFAULT NULL,\n" +
                    "   Salario  decimal(8,2) DEFAULT NULL,\n" +
                    "   Comision  decimal(8,2) DEFAULT NULL,\n" +
                    "   Departamento  int(11) DEFAULT NULL,\n" +
                    "   Email  varchar(50) DEFAULT NULL,\n" +
                    "   Telefono  varchar(12) DEFAULT NULL,\n" +
                    "  PRIMARY KEY ( NumeroEmpleado ),\n" +
                    "  FOREIGN KEY ( Departamento ) REFERENCES  departamentos  ( NumeroDepartamento )\n" +
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
            db.execSQL("DROP TABLE IF EXISTS  departamentos;");
            db.execSQL("DROP TABLE IF EXISTS  empleados;");

            //Llamamos a onCreate para que cree la tabla con las nuevas especificaciones
            onCreate(db);
        }
        catch (SQLException e){
            //Mensaje de error si no se ha ejecutado correctamente
            Toast.makeText(contexto,""+e,Toast.LENGTH_SHORT).show();
        }

    }
    public void insertarDatos (SQLiteDatabase db){
    db.execSQL("INSERT INTO  departamentos  VALUES (1, 'Nóminas', 12000.00);");
    db.execSQL("INSERT INTO  departamentos  VALUES (2, 'Personal', 10000.00);");
    db.execSQL("INSERT INTO  departamentos  VALUES (3, 'Informática', 24000.00);");
    db.execSQL("INSERT INTO  departamentos  VALUES (4, 'Administración', 2999.00);");

    db.execSQL("INSERT INTO  empleados  VALUES ('1', 'Luis Salas', '1000.00', '501.00', '1', 'luis@gmail.com', '33333');");
    db.execSQL("INSERT INTO  empleados  VALUES ('2', 'Carlos Sainz', '2000.00', '200.00', '2', 'carlos@gmail.com', '44444');");
    db.execSQL("INSERT INTO  empleados  VALUES ('3', 'Eva Hache', '1000.00', '100.00', '2', 'eva@gmail.com', '333332');");
    db.execSQL("INSERT INTO  empleados  VALUES ('4', 'Faemino Cansado', '2100.00', '550.00', '3', 'faemino@gmail.com', '23423');");
    db.execSQL("INSERT INTO  empleados  VALUES ('5', 'Goyo Jiménez', '3000.00', '200.00', '4', 'goyo@gmail.com', '2342343');");
    db.execSQL("INSERT INTO  empleados  VALUES ('6', 'Dani Rovira', null, null, null, 'rovira@gmail.com', '383838');");
    db.execSQL("INSERT INTO  empleados  VALUES ('7', 'Enrique Saenz', null, null, null, null, null);\n");

    }
}