package com.example.hectorjavier.elementosgui.listview;

/**
 * Created by HectorJavier on 17/12/2015.
 */
public class ElementoLista {
    String titulo;
    int id_imagen;

    public ElementoLista(String titulo, int id_imagen) {
        this.titulo = titulo;
        this.id_imagen = id_imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId_imagen() {
        return id_imagen;
    }
}
