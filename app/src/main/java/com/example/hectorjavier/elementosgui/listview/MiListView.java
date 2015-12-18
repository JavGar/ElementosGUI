package com.example.hectorjavier.elementosgui.listview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorjavier.elementosgui.R;
import com.example.hectorjavier.elementosgui.tabhost.MiTabHost;
import com.example.hectorjavier.elementosgui.tabhost.MiTabHost2;

import java.util.ArrayList;
import java.util.List;

public class MiListView extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_list_view);

        List<ElementoLista> elementos = new ArrayList<>();
        elementos.add(new ElementoLista("TabHost",R.drawable.tab));
        elementos.add(new ElementoLista("TabHost2",R.drawable.tab));
        elementos.add(new ElementoLista("ListView",R.drawable.list));

        setListAdapter(new MiAdaptador(elementos,getApplicationContext()));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getApplicationContext(),((TextView) v.findViewById(R.id.titulo)).getText(),Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                startActivity(new Intent(getApplicationContext(), MiTabHost.class));
                finish();
                break;
            case 1:
                startActivity(new Intent(getApplicationContext(), MiTabHost2.class));
                finish();
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(), MiListView.class));
                finish();
                break;
            default:
                Toast.makeText(getApplicationContext(),"Destino no definido",Toast.LENGTH_SHORT).show();
        }
    }
}
