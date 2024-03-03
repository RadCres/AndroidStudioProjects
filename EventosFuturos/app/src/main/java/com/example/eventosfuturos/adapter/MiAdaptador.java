package com.example.eventosfuturos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventosfuturos.R;
import com.example.eventosfuturos.model.dto.Evento;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Holder> {
    private List<Evento> eventos;
    private LayoutInflater mInflater;
    private IntemClickListener intemClickListener;

    MiAdaptador(Context contexto, List<Evento> eventos) {
        this.mInflater = LayoutInflater.from(contexto);

    }


    @NonNull
    @Override
    public MiAdaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(this.mInflater.inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Holder holder, int position) {
        holder.fillContent(eventos.get(position));
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public void setClickListener(IntemClickListener mainActivity3) {
        this.intemClickListener = mainActivity3;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textTitulo;
        private TextView textDia;
        private TextView textHora;


        public Holder(@NonNull View itemView) {
            super(itemView);
            textTitulo = itemView.findViewById(R.id.titulo);
            textDia = itemView.findViewById(R.id.dia);
            textHora = itemView.findViewById(R.id.hora);
            itemView.setOnClickListener(this);

        }

        public void fillContent(Evento evento) {
            this.textTitulo.setText(evento.toString());
            this.textDia.setText(evento.toString());
            this.textHora.setText(evento.toString());

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
