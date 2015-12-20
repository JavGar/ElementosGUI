package com.example.hectorjavier.elementosgui.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.hectorjavier.elementosgui.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MiExpandableListView extends AppCompatActivity {

    ExpandableListView expandableListView;
    AdaptadorListaExpandible adapter;

    ArrayList<String> cabeceras = new ArrayList<String>();

    HashMap<String, ArrayList<String>> cabecera_elementos = new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_expandable_list_view);

        expandableListView = (ExpandableListView) findViewById(R.id.expListView);

        cabeceras.add("Dias de la Semana");
        cabeceras.add("Dias festivos");
        cabeceras.add("Colores");

        ArrayList<String> dias = new ArrayList<String>();
        dias.add("Domingo");
        dias.add("Lunes");
        dias.add("Martes");
        dias.add("Miércoles");
        dias.add("Jueves");
        dias.add("Viernes");
        dias.add("Sábado");
        cabecera_elementos.put(cabeceras.get(0), dias);

        ArrayList<String> festivos = new ArrayList<String>();
        festivos.add("Navidad");
        festivos.add("Amor y Amistad");
        festivos.add("Trabajo");
        festivos.add("Independencia");
        cabecera_elementos.put(cabeceras.get(1), festivos);

        ArrayList<String> colores = new ArrayList<String>();
        colores.add("Rojo");
        colores.add("Verde");
        colores.add("Naranja");
        cabecera_elementos.put(cabeceras.get(2), colores);

        adapter = new AdaptadorListaExpandible(getApplicationContext(), cabeceras,cabecera_elementos);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "Elemento seleccionado:\nPadre: "+groupPosition+"\nHijo: "+childPosition, Toast.LENGTH_LONG).show();
                return false;
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,int groupPosition, long id) {
                Toast.makeText(getApplicationContext(), "Cabecera seleccionada: "+groupPosition, Toast.LENGTH_LONG).show();
                return false;
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), "Grupo contraido: "+groupPosition, Toast.LENGTH_LONG).show();
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), "Grupo expandido: "+groupPosition, Toast.LENGTH_LONG).show();
            }
        });

    }
}
