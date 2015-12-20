package com.example.hectorjavier.elementosgui.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hectorjavier.elementosgui.R;

import java.util.List;

/**
 * Created by HectorJavier on 17/12/2015.
 */
public class MiAdaptador extends BaseAdapter {

    List<?> elementos;
    Context context;

    public MiAdaptador(List<?> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.elemento_lista,null);
        }

        ((TextView) view.findViewById(R.id.titulo)).setText( ((ElementoLista)elementos.get(position)).getTitulo());
        ((ImageView) view.findViewById(R.id.imagen)).setImageResource(((ElementoLista) elementos.get(position)).getId_imagen());

        return view;
    }
}
