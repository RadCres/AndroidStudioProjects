package com.example.recuperacionraul;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Holder> {
    private List<String> libros;
    private List<Image> imagenes;
    private LayoutInflater mInflater;
    private IntemClickListener intemClickListener;

    MiAdaptador(Context contexto, List<String> libros) {
        this.mInflater = LayoutInflater.from(contexto);
        this.libros = libros;
    }


    @NonNull
    @Override
    public MiAdaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(this.mInflater.inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Holder holder, int position) {
        holder.fillContent(libros.get(position));
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public void setClickListener(IntemClickListener mainActivity3) {
        this.intemClickListener = mainActivity3;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textLibros;


        public Holder(@NonNull View itemView) {
            super(itemView);
            textLibros = itemView.findViewById(R.id.textViewLibros);

            itemView.setOnClickListener(this);

        }

        public void fillContent(String libro) {
            this.textLibros.setText(libro.toString());

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
