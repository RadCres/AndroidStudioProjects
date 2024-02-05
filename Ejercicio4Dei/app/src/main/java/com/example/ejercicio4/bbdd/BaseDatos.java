package com.example.ejercicio4.bbdd;

//Imports necesarios
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

//Crear una clase que extienda de SQLiteOpenHelper
public class BaseDatos extends SQLiteOpenHelper {

    private static final int VERSION = 7;
    private static BaseDatos instance;
    private Context contexto;

    //Constructor
    private BaseDatos(Context context) {
        super(context,"BD.db", null, VERSION);
        contexto=context;
    }

    public static BaseDatos getInstance(Context context){
        if(instance == null){
            instance = new BaseDatos(context);
        }

        return instance;

    }


    @Override
    //onCreate se ejecuta cuando se CREA la BD
    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL("CREATE TABLE departamentos " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT);");

            //Creamos la tabla
            db.execSQL("CREATE TABLE empleados " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT," +
                    " salario REAL," +
                    " email TEXT," +
                    " telefono TEXT," +
                    " departamento INTEGER,"  +
                    " FOREIGN KEY ('departamento') REFERENCES 'departamentos'('id'));");

            db.execSQL("INSERT INTO departamentos(id, nombre) VALUES (1, 'Recursos Humanos')");
            db.execSQL("INSERT INTO departamentos(id, nombre) VALUES (2, 'Programador')");
            db.execSQL("INSERT INTO departamentos(id, nombre) VALUES (3, 'Coordinador')");
            db.execSQL("INSERT INTO departamentos(id, nombre) VALUES (4, 'Puto inutil')");

            db.execSQL("INSERT INTO empleados VALUES (1,'Santi Pivon', 1344.32, 'santiguapo@gmail.com', '634525666', 4)");
            db.execSQL("INSERT INTO empleados VALUES (2,'David Beltran', 13.32, 'bbesita@gmail.com', '771628716', 1)");
            db.execSQL("INSERT INTO empleados VALUES (3,'tetas sanchez', 13.32, 'bbesita@gmail.com', '771628716', 2)");
            db.execSQL("INSERT INTO empleados VALUES (4,'elva ginon', 13.32, 'bbesita@gmail.com', '771628716', 3)");
            db.execSQL("INSERT INTO empleados VALUES (5,'analisa melano', 13.32, 'bbesita@gmail.com', '771628716', 4)");

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
            db.execSQL("DROP TABLE IF EXISTS departamentos");
            db.execSQL("DROP TABLE IF EXISTS departamento");
            db.execSQL("DROP TABLE IF EXISTS empleados");
            db.execSQL("DROP TABLE IF EXISTS empleado");
            //Llamamos a onCreate para que cree la tabla con las nuevas especificaciones
            onCreate(db);
        }
        catch (SQLException e){
            //Mensaje de error si no se ha ejecutado correctamente
            Toast.makeText(contexto,""+e,Toast.LENGTH_SHORT).show();
        }

    }

    public void test(){
//        db.execSQL("INSERT INTO departamento(id, nombre) VALUES (1, 'Recursos Humanos')");
//        db.execSQL("INSERT INTO departamento(id, nombre) VALUES (2, 'Programador')");
//        db.execSQL("INSERT INTO departamento(id, nombre) VALUES (3, 'Coordinador')");
//        db.execSQL("INSERT INTO departamento(id, nombre) VALUES (4, 'Puto inutil')");
//
//        db.execSQL("INSERT INTO empleados VALUES (1,'Santi Pivon', 1344.32, 'santiguapo@gmail.com', '634525666', 4)");
//        db.execSQL("INSERT INTO empleados VALUES (2,'David Beltran', 13.32, 'bbesita@gmail.com', '771628716', 1)");
    }
}