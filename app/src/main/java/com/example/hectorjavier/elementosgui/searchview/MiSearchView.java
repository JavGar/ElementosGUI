package com.example.hectorjavier.elementosgui.searchview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import com.example.hectorjavier.elementosgui.R;

import java.util.ArrayList;

public class MiSearchView extends ListActivity {

    SearchView sv_busqueda;
    ArrayList<String> palabras_reserbadas;
    ArrayList<String> resultado;
    ArrayList<String> vacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_search_view);

        sv_busqueda = (SearchView) findViewById(R.id.searchView);
        vacio = new ArrayList<>();
        vacio.add("Sin resultados");

        palabras_reserbadas = new ArrayList<>();
        palabras_reserbadas.add("abstract");
        palabras_reserbadas.add("assert");
        palabras_reserbadas.add("boolean");
        palabras_reserbadas.add("break");
        palabras_reserbadas.add("byte");
        palabras_reserbadas.add("case");
        palabras_reserbadas.add("catch");
        palabras_reserbadas.add("char");
        palabras_reserbadas.add("class");
        palabras_reserbadas.add("const");
        palabras_reserbadas.add("continue");
        palabras_reserbadas.add("default");
        palabras_reserbadas.add("do");
        palabras_reserbadas.add("double");
        palabras_reserbadas.add("else");
        palabras_reserbadas.add("enum");
        palabras_reserbadas.add("extends");
        palabras_reserbadas.add("final");
        palabras_reserbadas.add("finally");
        palabras_reserbadas.add("float");
        palabras_reserbadas.add("for");
        palabras_reserbadas.add("goto");
        palabras_reserbadas.add("if");
        palabras_reserbadas.add("implements");
        palabras_reserbadas.add("import");
        palabras_reserbadas.add("instanceof");
        palabras_reserbadas.add("int");
        palabras_reserbadas.add("interface");
        palabras_reserbadas.add("long");
        palabras_reserbadas.add("native");
        palabras_reserbadas.add("new");
        palabras_reserbadas.add("package");
        palabras_reserbadas.add("private");
        palabras_reserbadas.add("protected");
        palabras_reserbadas.add("public");
        palabras_reserbadas.add("return");
        palabras_reserbadas.add("short");
        palabras_reserbadas.add("static");
        palabras_reserbadas.add("strictfp");
        palabras_reserbadas.add("super");
        palabras_reserbadas.add("switch");
        palabras_reserbadas.add("synchronized");
        palabras_reserbadas.add("this");
        palabras_reserbadas.add("throw");
        palabras_reserbadas.add("throws");
        palabras_reserbadas.add("transient");
        palabras_reserbadas.add("try");
        palabras_reserbadas.add("void");
        palabras_reserbadas.add("volatile");
        palabras_reserbadas.add("while");

        sv_busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                resultado = new ArrayList<>();
                for (String palabra : palabras_reserbadas) {
                    if (palabra.contains(query))
                        resultado.add(palabra);
                }
                if (resultado.size() != 0) {
                    setListAdapter(new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, resultado));
                } else {
                    setListAdapter(new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, vacio));
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                resultado = new ArrayList<>();
                for (String palabra : palabras_reserbadas) {
                    if (palabra.contains(newText))
                        resultado.add(palabra);
                }
                if (resultado.size() != 0) {
                    setListAdapter(new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, resultado));
                } else {
                    setListAdapter(new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, vacio));
                }
                return true;
            }
        });

        setListAdapter(new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,palabras_reserbadas));
    }
}
