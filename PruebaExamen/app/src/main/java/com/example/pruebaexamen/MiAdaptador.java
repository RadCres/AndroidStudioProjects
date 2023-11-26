package com.example.pruebaexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Holder> {
    private List<String> listaLibros;
    private LayoutInflater mInflater;
   private IntemClickListener intemClickListener;

    MiAdaptador(Context contexto, List<String> listaLibros) {
        this.mInflater = LayoutInflater.from(contexto);
        this.listaLibros = listaLibros;
    }


    @NonNull
    @Override
    public MiAdaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(this.mInflater.inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Holder holder, int position) {
        holder.fillContent(listaLibros.get(position));
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    public void setClickListener(IntemClickListener mainActivity3) {
        this.intemClickListener = mainActivity3;
    }

    public void removeItem(int position) {
        listaLibros.remove(position);
    }

    public void addLibro(String nuevoLibro) {
        if (!nuevoLibro.isEmpty()){
        listaLibros.add(nuevoLibro);
        }
        
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nombre;


        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombre);

            itemView.setOnClickListener(this);

        }

        public void fillContent(String libro) {
            this.nombre.setText(libro);

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

