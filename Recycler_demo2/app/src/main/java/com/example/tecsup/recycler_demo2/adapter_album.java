package com.example.tecsup.recycler_demo2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapter_album extends RecyclerView.Adapter<Item_holder> {
    List<Album> datos;
    LayoutInflater inflater;
    Context context;

    public adapter_album(List<Album> datos, Context context) {
        inflater = LayoutInflater.from(context);
        this.datos = datos;
        this.context = context;
    }

    @NonNull
    @Override
    public Item_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.item_group,viewGroup,false);
        return new Item_holder(v, this);
    }

    @Override
    public void onBindViewHolder(@NonNull Item_holder item_holder, int i) {
        item_holder.titulo.setText(datos.get(i).getTitulo());
        item_holder.fecha.setText(datos.get(i).getFecha_lansamiento());
        Glide.with(context).load(datos.get(i).getImagen()).into(item_holder.imageView);
        if (datos.get(i).faborito){
            Glide.with(context).load(R.drawable.ic_star_black_24dp).into(item_holder.favoritos);
        }else{
            Glide.with(context).load(R.drawable.ic_star_border_black_24dp).into(item_holder.favoritos);
        }
        item_holder.posicion = i;
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void SetFaborito(int i){
        datos.get(i).faborito = !datos.get(i).faborito;
        notifyDataSetChanged();
    }
}
