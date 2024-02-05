package com.example.ejercicio4.bbdd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.ejercicio4.model.Empleado;

import java.util.List;

public class AdapterDepartamentos implements IAdapter<String, Integer>{

    private BaseDatos baseDatos;
    private SQLiteDatabase bd;
    private Context context;

    public AdapterDepartamentos(Context context) {
        this.context = context;
        this.baseDatos = BaseDatos.getInstance(context);
    }

    @Override
    public String find(Integer key) {
        bd = baseDatos.getWritableDatabase();

        Cursor cursor = bd.rawQuery("SELECT * FROM departamentos WHERE id = ?", new String[]{String.valueOf(key)});

        String result = null;

        if(cursor.moveToFirst()){
            bd.close();
            return cursor.getString(1);
        }

        bd.close();

        return result;
    }

    @Override
    public List<String> findAll() {
        return null;
    }

    @Override
    public void insert(String obj) {

    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(String obj) {

    }
}
