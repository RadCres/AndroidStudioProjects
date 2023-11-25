package com.example.proyectotema3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Holder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener itemClickListener;

    MiAdaptador(Context contexto, List<String> data) {
        this.mInflater = LayoutInflater.from(contexto);
        this.mData = data;
    }


    @NonNull
    @Override
    public MiAdaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView nombre2;

        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombre);
            nombre2 = itemView.findViewById(R.id.textViewNombre2);
        }
    }
}

