package com.example.ejercicio4.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.ejercicio4.model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class AdapterEmpleados implements IAdapter<Empleado, Long>{

    private BaseDatos baseDatos;
    private SQLiteDatabase bd;
    private Context context;


    public AdapterEmpleados(Context context) {
        this.context = context;
        this.baseDatos = BaseDatos.getInstance(context);

    }


    @Override
    public Empleado find(Long key) {

        bd = baseDatos.getReadableDatabase();

        Cursor cursor = bd.rawQuery("SELECT * FROM empleados WHERE id = ?", new String[]{key.toString()});

        Empleado result = null;

        if(cursor.moveToFirst()){
            result = new Empleado();
            result.setId(Long.valueOf(cursor.getInt(0)));
            result.setNombre(cursor.getString(1));
            result.setSalario(Double.valueOf(cursor.getInt(2)));
            result.setEmail(cursor.getString(3));
            result.setTelefono(cursor.getString(4));
            result.setIdDepartamento(Long.valueOf(cursor.getInt(5)));
        }

        bd.close();

        return result;
    }

    @Override
    public List<Empleado> findAll() {

        List<Empleado> lista = new ArrayList<>();

        bd = baseDatos.getWritableDatabase();

        Empleado result = null;

        Cursor cursor = bd.rawQuery("SELECT * FROM empleados", null);

        if(cursor.moveToFirst()){
            do{
                result = new Empleado();
                result.setId(Long.valueOf(cursor.getInt(0)));
                result.setNombre(cursor.getString(1));
                result.setSalario(Double.valueOf(cursor.getInt(2)));
                result.setEmail(cursor.getString(3));
                result.setTelefono(cursor.getString(4));
                result.setIdDepartamento(Long.valueOf(cursor.getInt(5)));

                lista.add(result);
            }while(cursor.moveToNext());
            cursor.close();
        }

        bd.close();

        return lista;
    }

    public List<Empleado> findAllByDepartamento(Long idDepartamento) {

        List<Empleado> lista = new ArrayList<>();

        bd = baseDatos.getWritableDatabase();

        Empleado result = null;

        Cursor cursor = bd.rawQuery("SELECT * FROM empleados", null);

        if(cursor.moveToFirst()){
            do{
                if(Long.valueOf(cursor.getInt(5)) != idDepartamento) continue;
                result = new Empleado();
                result.setId(Long.valueOf(cursor.getInt(0)));
                result.setNombre(cursor.getString(1));
                result.setSalario(Double.valueOf(cursor.getInt(2)));
                result.setEmail(cursor.getString(3));
                result.setTelefono(cursor.getString(4));
                result.setIdDepartamento(Long.valueOf(cursor.getInt(5)));

                lista.add(result);
            }while(cursor.moveToNext());
            cursor.close();
        }

        bd.close();

        return lista;
    }

    @Override
    public void insert(Empleado obj) {

    }

    @Override
    public void delete(Long key) {
        bd = baseDatos.getWritableDatabase();

        bd.delete("empleados", "id = ?", new String[]{key.toString()});

        bd.close();

    }

    @Override
    public void update(Empleado newEmpleado) {

        bd = baseDatos.getWritableDatabase();

        Long id = newEmpleado.getId();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", newEmpleado.getNombre());
        contentValues.put("salario", newEmpleado.getSalario());
        contentValues.put("email", newEmpleado.getEmail());
        contentValues.put("telefono", newEmpleado.getTelefono());
        contentValues.put("departamento", newEmpleado.getIdDepartamento());

        bd.update("empleados", contentValues, "id = ?", new String[]{id.toString()});

        bd.close();
    }

    public void increase10percent() {
        List<Empleado> empleados = this.findAll();

        empleados.stream().forEach(e -> {
            e.setSalario(e.getSalario()*1.10);
            this.update(e);
        });
    }
}
