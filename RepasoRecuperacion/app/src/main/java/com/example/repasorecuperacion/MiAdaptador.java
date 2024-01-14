package com.example.repasorecuperacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Holder> {
    private List<String> comentarios;
    private LayoutInflater mInflater;
    private IntemClickListener intemClickListener;

    MiAdaptador(Context contexto, List<String> comentario) {
        this.mInflater = LayoutInflater.from(contexto);
        this.comentarios = comentario;
    }


    @NonNull
    @Override
    public MiAdaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(this.mInflater.inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Holder holder, int position) {
        holder.fillContent(comentarios.get(position));
    }

    @Override
    public int getItemCount() {
        return comentarios.size();
    }

    public void setClickListener(IntemClickListener mainActivity3) {
        this.intemClickListener = mainActivity3;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textComentario;


        public Holder(@NonNull View itemView) {
            super(itemView);
            textComentario = itemView.findViewById(R.id.textViewComentario);

            itemView.setOnClickListener(this);

        }

        public void fillContent(String comentario) {
            this.textComentario.setText(comentario.toString());

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
