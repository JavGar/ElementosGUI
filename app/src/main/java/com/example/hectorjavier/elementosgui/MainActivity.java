package com.example.hectorjavier.elementosgui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorjavier.elementosgui.expandablelistview.MiExpandableListView;
import com.example.hectorjavier.elementosgui.gridview.MiGridView;
import com.example.hectorjavier.elementosgui.listview.MiListView;
import com.example.hectorjavier.elementosgui.listview.MiListView2;
import com.example.hectorjavier.elementosgui.progresbar.MiProgressBar;
import com.example.hectorjavier.elementosgui.radiogroup.MiRadioGroup;
import com.example.hectorjavier.elementosgui.radiogroup.MiRadioGroup2;
import com.example.hectorjavier.elementosgui.searchview.MiSearchView;
import com.example.hectorjavier.elementosgui.seekbar.MiSeekBar;
import com.example.hectorjavier.elementosgui.tabhost.MiTabHost;
import com.example.hectorjavier.elementosgui.tabhost.MiTabHost2;
import com.example.hectorjavier.elementosgui.webview.MiWebView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Elementos que se muestran en la lista
         */
        List<String> listValues = new ArrayList<>();
        listValues.add("TabHost");
        listValues.add("TabHost2");
        listValues.add("ListView");
        listValues.add("ListView2");
        listValues.add("RadioGroup");
        listValues.add("RadioGroup2");
        listValues.add("GridView");
        listValues.add("ExpandableListView");
        listValues.add("SearchtView");
        listValues.add("ProgressBar");
        listValues.add("SeekBar");
        listValues.add("WebView");
        /*
        Adaptador de un arreglo de tipo String, sirve para ligar cada elemento de la lista a una
        vista definida que será la manera en que se muestren al usuario
        Recibe:
        - El Contexto de la aplicación.
        - La vista que se aplicará a cada elemento de la lista
        - La lista de elementos a mostrar al usuario
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listValues);

        /*
        Se aplica el adaptador al elemento ListView en el archivo xml.
        Al extender de un ListActivity se liga automáticamente el elemento con id="@android:id/list"
         */
        setListAdapter(adapter);
    }

    /*
     * Método definido en ListActivity sirve para obtener información del elemento seleccionado de la lista
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getApplicationContext(),((TextView) v).getText(),Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                startActivity(new Intent(getApplicationContext(), MiTabHost.class));
                break;
            case 1:
                startActivity(new Intent(getApplicationContext(), MiTabHost2.class));
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(), MiListView.class));
                break;
            case 3:
                startActivity(new Intent(getApplicationContext(), MiListView2.class));
                break;
            case 4:
                startActivity(new Intent(getApplicationContext(), MiRadioGroup.class));
                break;
            case 5:
                startActivity(new Intent(getApplicationContext(), MiRadioGroup2.class));
                break;
            case 6:
                startActivity(new Intent(getApplicationContext(), MiGridView.class));
                break;
            case 7:
                startActivity(new Intent(getApplicationContext(), MiExpandableListView.class));
                break;
            case 8:
                startActivity(new Intent(getApplicationContext(), MiSearchView.class));
                break;
            case 9:
                startActivity(new Intent(getApplicationContext(), MiProgressBar.class));
                break;
            case 10:
                startActivity(new Intent(getApplicationContext(), MiSeekBar.class));
                break;
            case 11:
                startActivity(new Intent(getApplicationContext(), MiWebView.class));
                break;
            default:
                Toast.makeText(getApplicationContext(),"Destino no definido",Toast.LENGTH_SHORT).show();
        }
    }
}
