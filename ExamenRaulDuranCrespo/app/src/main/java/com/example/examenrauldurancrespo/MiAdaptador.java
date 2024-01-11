package com.example.examenrauldurancrespo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Holder> {
    private List<String> mdata;
    private LayoutInflater mInflater;
    private IntemClickListener intemClickListener;

    MiAdaptador(Context contexto, List<String> data) {
        this.mInflater = LayoutInflater.from(contexto);
        this.mdata = data;
    }

    @NonNull
    @Override
    public MiAdaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(this.mInflater.inflate(R.layout.activity_main2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Holder holder, int position) {
        String data = mdata.get(position);
        holder.nombre.setText(data);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public void setClickListener(IntemClickListener mainActivity3) {
        this.intemClickListener = mainActivity3;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombre;


        public Holder(@NonNull View itemView) {
            super(itemView);
//            nombre = itemView.findViewById(R.id.textViewNombre);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (intemClickListener != null) {
                intemClickListener.onClickSelected(v, getAdapterPosition());
            }
        }
    }

    public interface IntemClickListener {
        void onClickSelected(View vista, int position);

    }

}

