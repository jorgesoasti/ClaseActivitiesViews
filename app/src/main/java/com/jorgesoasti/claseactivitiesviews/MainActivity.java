package com.jorgesoasti.claseactivitiesviews;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        sfiMiIndicadorRefresh = findViewById(R.id.sfiMiIndicadorRefresh); //(SwipeRefreshLayout) REDUNDANTE
        lstMiLista = findViewById(R.id.lstMiLista); // (ListView) REDUNDANTE

        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }

    public void refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAB(){
        FloatingActionButton miFAB = findViewById(R.id.fabMiFab); //(FloatingActionButton) REDUNDANTE
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Esta forma ya no se utiliza, ahora se la reemplazo por Snackbar
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje_like), Toast.LENGTH_SHORT).show();
                //Snackbar
                Snackbar.make(view, getResources().getString(R.string.mensaje_like), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.text_accion_sb), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorLightPrimaryColor))
                        .show();
            }
        });
    }
}
