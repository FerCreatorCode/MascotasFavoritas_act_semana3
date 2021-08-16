package com.fercreatorcode.mascotasfavoritas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.ArrayList;

public class SegundaActividad extends AppCompatActivity {
    ArrayList<Mascota> mascotas;

    private RecyclerView RecyclerViewListaMacotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_actividad);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //activandpo la navegación hacia atrás
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        //inicializar ArrayList mascotas
        mascotas = new ArrayList<Mascota>();

        //5 mascotas favoritas
        mascotas.add(new Mascota(R.drawable.dog_1,"Fox",3));
        mascotas.add(new Mascota(R.drawable.conejo,"Buny",2));
        mascotas.add(new Mascota(R.drawable.pato,"Cuak",4));
        mascotas.add(new Mascota(R.drawable.raton,"Mousi",2));
        mascotas.add(new Mascota(R.drawable.tortuga,"Tourtly",3));

        //asociación XML a RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) findViewById(R.id.rvPetsFavs);

        //LayoutManagwer: LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(this);
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagwerMascotas);

        //Adaptador
        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);

    }

    //si se pulsa retroceder se realiza un Intent a MainActivity
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(SegundaActividad.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}