package com.example.ejercicio4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio4.bbdd.AdapterDepartamentos;
import com.example.ejercicio4.model.Empleado;

import java.util.List;

public class AdapterEmpleadosRecycle extends RecyclerView.Adapter<AdapterEmpleadosRecycle.ViewHolder> {
    private List<Empleado> mData;
    private LayoutInflater mInflater;
    private Context context;

    AdapterEmpleadosRecycle(Context context, List<Empleado> data){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.recycler_empleados, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Empleado empleado = mData.get(position);

        holder.tvNombre.setText(empleado.getNombre());
        holder.tvEmail.setText(empleado.getEmail());
        holder.tvSalario.setText(empleado.getSalario().toString());
        holder.tvTelefono.setText(empleado.getTelefono());

        String departamento = new AdapterDepartamentos(context).find(Integer.valueOf(empleado.getIdDepartamento().toString()));

        holder.tvDepartamento.setText(departamento);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNombre;
        TextView tvSalario;
        TextView tvDepartamento;
        TextView tvEmail;
        TextView tvTelefono;

        ViewHolder(View itemView){
            super(itemView);
            tvNombre = itemView.findViewById(R.id.recycler_nombre);
            tvSalario = itemView.findViewById(R.id.recycler_salario);
            tvDepartamento = itemView.findViewById(R.id.recycler_departamento);
            tvEmail = itemView.findViewById(R.id.recycler_email);
            tvTelefono = itemView.findViewById(R.id.recycler_telefono);


        }
    }
}
