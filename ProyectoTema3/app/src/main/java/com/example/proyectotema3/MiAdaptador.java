package com.example.proyectotema3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectotema3.model.Nacionalidad;

import java.net.InterfaceAddress;
import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Holder> {
    private List<Nacionalidad> listaNacionalidad;
    private LayoutInflater mInflater;
   private IntemClickListener intemClickListener;

    MiAdaptador(Context contexto, List<Nacionalidad> nacionalidades) {
        this.mInflater = LayoutInflater.from(contexto);
        this.listaNacionalidad = nacionalidades;
    }


    @NonNull
    @Override
    public MiAdaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(this.mInflater.inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Holder holder, int position) {
        holder.fillContent(listaNacionalidad.get(position));
    }

    @Override
    public int getItemCount() {
        return listaNacionalidad.size();
    }

    public void setClickListener(IntemClickListener mainActivity3) {
        this.intemClickListener = mainActivity3;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nombre;
        private TextView nombre2;

        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombre);
            nombre2 = itemView.findViewById(R.id.textViewNombre2);
            itemView.setOnClickListener(this);

        }

        public void fillContent(Nacionalidad nacionalidad) {
            this.nombre.setText(nacionalidad.getPais());
            this.nombre2.setText(nacionalidad.getIdiomaOficial());
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

