package com.example.ejercicio4tema4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AdapterBaseDatos {

    private Context context;
    private BadeDatos baseDatos;
    private static AdapterBaseDatos adapterBD;
    private SQLiteDatabase bd;

    private AdapterBaseDatos(Context c){
        context = c;
        baseDatos = new BadeDatos(context);
    }
    public static AdapterBaseDatos getInstance(Context context){
        if (adapterBD ==null){
            adapterBD = new AdapterBaseDatos(context);
        }
        return adapterBD;
    }
    public String consultar(int id){
        bd = baseDatos.getReadableDatabase();
        String name = "";
        String query = "SELECT nombre FROM empleados WHERE NumeroEmpleado = " + id;
        Cursor cursor = bd.rawQuery(query,null);
        if (cursor != null){
            cursor.moveToFirst();
            name = cursor.getString(0);
        }
        bd.close();
        return name;
    }

    public void eliminarEmpleado(int id){
        bd = baseDatos.getWritableDatabase();
        String query = "DELETE FROM empleados WHERE NumeroEmpleado =" + id;
        bd.execSQL(query);
        bd.close();
    }

    public List<String> consultarNombreSalario() {
        bd = baseDatos.getReadableDatabase();
        List<String> nombresSalarios = new ArrayList<>();
        String query = "SELECT Nombre, Salario FROM empleados";
        Cursor cursor = bd.rawQuery(query, null);

        try {
            while (cursor != null && cursor.moveToNext()) {
                String name = cursor.getString(0);
                double salario = cursor.getDouble(1);
                nombresSalarios.add(name + " - " + salario);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            bd.close();
        }

        return nombresSalarios;
    }

    public List<String> consultarNombrePorDepartamento(int departamento){
        bd = baseDatos.getReadableDatabase();
        List<String> listaEmpleadosPorDepartamento = new ArrayList<>();
        String query = "SELECT Nombre FROM empleados WHERE Departamento = " + departamento;
        Cursor cursor = bd.rawQuery(query,null);
        try{
            while (cursor != null && cursor.moveToNext()){
                String name = cursor.getString(0);
                listaEmpleadosPorDepartamento.add(name);
            }
        }finally {
            if (cursor !=null) cursor.close();
        }

        bd.close();
        return listaEmpleadosPorDepartamento;
    }
    public void incrementarSalario(){
        bd = baseDatos.getWritableDatabase();
        String query = "UPDATE empleados SET Salario = Salario + (Salario*0.10)";
        bd.execSQL(query);
        bd.close();
    }

    public String consultarTodosLosDatos(int id){
        bd = baseDatos.getReadableDatabase();
        String datos="";
        String query = "SELECT * FROM empleados WHERE NumeroEmpleado = " + id;
        Cursor cursor = bd.rawQuery(query,null);
        if (cursor != null &&  cursor.moveToFirst()){

            datos = cursor.getString(0)+"-"+cursor.getString(1)+"-"+
                    cursor.getString(2)+"-"+cursor.getString(3)+"-"+
                    cursor.getString(4)+"-"+cursor.getString(5)+"-"+
                    cursor.getString(6);
        } if (cursor != null) {
            cursor.close();
        }
        bd.close();
        return datos;
    }

    public String getEmail(int id){
        bd = baseDatos.getReadableDatabase();
        String email="";
        String query = "SELECT Email FROM empleados WHERE NumeroEmpleado = " + id;
        Cursor cursor = bd.rawQuery(query,null);
        if (cursor != null &&  cursor.moveToFirst()){
            email = cursor.getString(0);
        } if (cursor != null) {
            cursor.close();
        }
        bd.close();
        return email;
    }
    public String getTelefono(int id){
        bd = baseDatos.getReadableDatabase();
        String telefono="";
        String query = "SELECT Telefono FROM empleados WHERE NumeroEmpleado = " + id;
        Cursor cursor = bd.rawQuery(query,null);
        if (cursor != null &&  cursor.moveToFirst()){
            telefono = cursor.getString(0);
        } if (cursor != null) {
            cursor.close();
        }
        bd.close();
        return telefono;
    }

    public void setEmailYTelefono(String email, String telefono,int id){
        bd = baseDatos.getWritableDatabase();
        String query = "UPDATE empleados SET Email = '"+ email +"', Telefono = '"+ telefono +"' WHERE NumeroEmpleado =" + id;
        bd.execSQL(query);
    }

}
