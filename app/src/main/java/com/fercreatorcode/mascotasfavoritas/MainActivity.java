package com.fercreatorcode.mascotasfavoritas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;

    private RecyclerView RecyclerViewListaMacotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //asociación XML a RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) findViewById(R.id.rvPets);

        //LayoutManager: LinearLayoutManager
        LinearLayoutManager LayoutManagerMascotas = new LinearLayoutManager(this);
        LayoutManagerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagerMascotas);

        //inicializar ArrayList mascotas
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.gato,"Miau",1));
        mascotas.add(new Mascota(R.drawable.dog_1,"Fox",3));
        mascotas.add(new Mascota(R.drawable.conejo,"Buny",2));
        mascotas.add(new Mascota(R.drawable.pato,"Cuak",4));
        mascotas.add(new Mascota(R.drawable.raton,"Mousi",2));
        mascotas.add(new Mascota(R.drawable.tortuga,"Tourtly",3));

        //Adaptador
        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);
    }
    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.mimenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            // intent SegundaActividad
            Intent intento = new Intent(this,SegundaActividad.class);
            startActivity(intento);
        }
        return super.onOptionsItemSelected(item);
    }
}