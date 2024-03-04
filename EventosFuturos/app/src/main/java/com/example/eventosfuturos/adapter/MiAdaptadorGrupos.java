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
import com.example.eventosfuturos.model.dto.Grupo;

import java.util.List;

public class MiAdaptadorGrupos extends RecyclerView.Adapter<MiAdaptadorGrupos.Holder> {
    private List<Grupo> grupos;
    private LayoutInflater mInflater;
    private IntemClickListener intemClickListener;

    public MiAdaptadorGrupos(Context contexto, List<Grupo> grupos) {
        this.mInflater = LayoutInflater.from(contexto);
        this.grupos = grupos;

    }


    @NonNull
    @Override
    public MiAdaptadorGrupos.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(this.mInflater.inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptadorGrupos.Holder holder, int position) {
        holder.fillContent(grupos.get(position));
    }

    @Override
    public int getItemCount() {
        return grupos.size();
    }

    public void setClickListener(IntemClickListener mainActivity3) {
        this.intemClickListener = mainActivity3;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView itemGrupo;
        //private TextView email;


        public Holder(@NonNull View itemView) {
            super(itemView);
            itemGrupo = itemView.findViewById(R.id.textGrupo);

            itemView.setOnClickListener(this);

        }

        public void fillContent(Grupo grupo) {
            this.itemGrupo.setText(grupo.getNombre().toString());


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
