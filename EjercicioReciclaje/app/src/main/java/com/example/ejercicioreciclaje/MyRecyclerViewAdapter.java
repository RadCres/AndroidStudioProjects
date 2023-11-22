package com.example.ejercicioreciclaje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends
        RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    MyRecyclerViewAdapter(Context contexto, List<String> data){
        this.mInflater = LayoutInflater.from(contexto);
        this.mData =data;
    }
    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.recycler_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public class ViewHolder extends  RecyclerView.ViewHolder implements
            View.OnClickListener{
        TextView myTextView;
        ViewHolder(View itemView){
            super(itemView);
            myTextView = itemView.findViewById(R.id.textViewNombre);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
            if (mClickListener !=null)
                mClickListener.onItemClick(view,getAdapterPosition());
        }
    }
    String getItem(int id){
        return mData.get(id);
    }
    void setCLickListener(ItemClickListener itemClickListener){
        this.mClickListener = itemClickListener;
    }
    public interface  ItemClickListener{
        void onItemClick(View activista, int position);
    }
}
