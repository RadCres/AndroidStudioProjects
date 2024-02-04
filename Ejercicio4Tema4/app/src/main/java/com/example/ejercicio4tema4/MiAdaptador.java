package com.example.ejercicio4tema4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Holder> {
    private List<String> empleados;
    private LayoutInflater mInflater;
    private IntemClickListener intemClickListener;

    MiAdaptador(Context contexto, List<String> empleado) {
        this.mInflater = LayoutInflater.from(contexto);
        this.empleados = empleado;
    }


    @NonNull
    @Override
    public MiAdaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(this.mInflater.inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Holder holder, int position) {
        holder.fillContent(empleados.get(position));
    }

    @Override
    public int getItemCount() {
        return empleados.size();
    }

    public void setClickListener(IntemClickListener mainActivity2) {
        this.intemClickListener = mainActivity2;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nombre;


        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombreSalario);
            itemView.setOnClickListener(this);

        }

        public void fillContent(String empleado) {
         //   this.textComentario.setText(comentario.toString());
            this.nombre.setText(empleado.toString());
        }

        @Override
        public void onClick(View v) {
            if (intemClickListener != null){
                intemClickListener.onClickSelected(v, getAdapterPosition());
            }
        }
    }

    public interface IntemClickListener{
        void onClickSelected(View vista, int position);

    }

}
