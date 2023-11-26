package com.example.pruebaexamen;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptador extends ArrayAdapter<String> {

    private Context mContext;
    private String[] countries;
    private int[] flags;

    public Adaptador(Context context, String[] countries, int[] flags) {
        super(context, R.layout.diseno_personalizado_elemntos_spinner, countries);
        this.mContext = context;
        this.countries = countries;
        this.flags = flags;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.diseno_personalizado_elemntos_spinner, parent, false);
        }

        TextView textViewCountry = convertView.findViewById(R.id.textViewCountry);
        ImageView imageViewFlag = convertView.findViewById(R.id.imageViewFlag);

        textViewCountry.setText(countries[position]);
        imageViewFlag.setImageResource(flags[position]);

        return convertView;
    }
}
