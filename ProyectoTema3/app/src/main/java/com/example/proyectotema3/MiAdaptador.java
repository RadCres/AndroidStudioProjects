package com.example.proyectotema3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.V> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener itemClickListener;

    MiAdaptador(Context contexto, List<String> data) {
        this.mInflater = LayoutInflater.from(contexto);
        this.mData = data;
    }


    @NonNull
    @Override
    public MiAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class Holder extends ViewHolder{

    }
}

