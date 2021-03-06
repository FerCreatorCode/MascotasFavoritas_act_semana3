package com.fercreatorcode.mascotasfavoritas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> Mascotas;


    //al llamar al Constructor se guardan los datos en el ArrayLisy
    public MascotaAdaptador(ArrayList<Mascota> Mascotas) {
        this.Mascotas = Mascotas;
    }

    //infla el layout cardview_Mascota
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //asociar el layout al reclyclerView: se infla el layout que va a reciclar el recyclerView (cardview_mascota)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        //el layout a reciclar (cardview_mascota) ya inflado, se pasa al constructor MascotaViewHolder (para que obtenga cada View) y se retorna
        return new MascotaViewHolder(v) ;
    }

    //se pasa la lista a cada elemento y se asocia cada elemento con su View
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder MascotaViewHolder, int position) {
        final Mascota mascota = Mascotas.get(position);
        //se dotan los Views del Holder
        MascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        MascotaViewHolder.tvTotalCV.setText(Integer.toString(mascota.getRating()));

        //este valor se emplea para actualizar el contador de rating cuando se cambia
        final TextView tvTotalCV_nuevoValor;
        tvTotalCV_nuevoValor   = (TextView) MascotaViewHolder.tvTotalCV;

        //click en hueso +
        MascotaViewHolder.btnAddCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se a??ade 1 unidad al rating
                mascota.setRating(mascota.getRating()+1);
                //mensaje click en bot??n
                Snackbar.make(v,mascota.getNombre() + " ahora tiene un rating de " + Integer.toString(mascota.getRating()),Snackbar.LENGTH_SHORT).show();
                tvTotalCV_nuevoValor.setText(Integer.toString(mascota.getRating()));
            }
        });


    }


    //cantiadad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return Mascotas.size();
    }


    //esta clase es static
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private  ImageView imgFotoCV;
        private ImageView btnAddCV;
        private  TextView tvNombreCV;
        private  TextView tvTotalCV;
        private ImageView btnTotalCV;

        //Constructor: se pasa la vista cardview_mascota
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV    = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            btnAddCV    = (ImageView) itemView.findViewById(R.id.btnAddCV);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTotalCV   = (TextView) itemView.findViewById(R.id.tvTotalCV);
            btnTotalCV  = (ImageView) itemView.findViewById(R.id.btnTotalCV);

        }
    }


}
