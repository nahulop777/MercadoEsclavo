package com.example.myapplication.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.Celular;
import com.example.myapplication.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterCelular extends RecyclerView.Adapter {

    private IrAlProducto interfazDelAdapter;
    private List<Celular>celularList;

    public AdapterCelular(IrAlProducto interfazDelAdapter, List<Celular> celularList) {
        this.interfazDelAdapter = interfazDelAdapter;
        this.celularList = celularList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.celda,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Celular celular = celularList.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.bindViewHolder(celular);

    }

    @Override
    public int getItemCount() {
        return celularList.size();
    }

    public void actualizarLista (List<Celular> listaActualizada){
        this.celularList = listaActualizada;
        notifyDataSetChanged();
    }
    public interface IrAlProducto {
        void seleccionaronEsteProducto(Celular celular);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenCel;
        private TextView nombreCel;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenCel = itemView.findViewById(R.id.imagenCel);
            nombreCel =  itemView.findViewById(R.id.nombreCel);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int posicionDelCelElegido = getAdapterPosition();
                    Celular celuElegido = celularList.get(posicionDelCelElegido);
                    interfazDelAdapter.seleccionaronEsteProducto(celuElegido);
                }
            });
        }

        public void bindViewHolder(Celular celular) {

            nombreCel.setText(celular.getTitle());
            Glide.with(itemView)
                    .load(celular.getThumbnail())
                    .into(imagenCel);

            //imagenArtista.setImageResource(genero.getPicture_medium());
        }
    }
}




