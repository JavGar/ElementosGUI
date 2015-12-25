package com.example.hectorjavier.elementosgui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MiWebView extends AppCompatActivity {

    EditText et_url;
    Button btn_cargar;
    WebView wv_navegador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_web_view);

        et_url = (EditText) findViewById(R.id.et_url);
        btn_cargar = (Button) findViewById(R.id.btn_cargar);
        wv_navegador = (WebView) findViewById(R.id.wv_navegador);

        btn_cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv_navegador.loadUrl(et_url.getText().toString());
            }
        });
    }
}
