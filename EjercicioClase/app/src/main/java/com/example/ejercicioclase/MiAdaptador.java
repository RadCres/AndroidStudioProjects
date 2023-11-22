package com.example.ejercicioclase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptador extends ArrayAdapter {
    private Context ctx;
    private int miLayaout;
    private List<Contactos> misContactos;

    public MiAdaptador(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.ctx= context;
        this.miLayaout=resource;
        this.misContactos=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.elementospinner,parent,false);
        Contactos elementoActual=misContactos.get(position);
        TextView nombre=(TextView) v.findViewById(R.id.textViewNombre);
        TextView direccion=(TextView) v.findViewById(R.id.textView2Direccion);
        nombre.
        return super.getView(position, convertView, parent);
    }
}
