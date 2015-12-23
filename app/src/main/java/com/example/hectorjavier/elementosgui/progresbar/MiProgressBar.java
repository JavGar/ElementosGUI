package com.example.hectorjavier.elementosgui.progresbar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hectorjavier.elementosgui.R;

public class MiProgressBar extends AppCompatActivity {

    Button btn_trabajo;
    TextView tv_letrero;
    int trabajos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_progress_bar);

        btn_trabajo = (Button) findViewById(R.id.btn_trabajo);
        tv_letrero = (TextView) findViewById(R.id.tv_letrero);

        btn_trabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RealizaTrabajo().execute(trabajos);
            }
        });
    }

    private class RealizaTrabajo extends AsyncTask<Integer,Integer,Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
            tv_letrero.setText("Realizando Trabajo");
        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            try {
                tarea();
            } catch (InterruptedException e) {
                return false;
            }
            params[0]++;
            trabajos=params[0];
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            findViewById(R.id.progressBar).setVisibility(View.GONE);
            if(aBoolean){
                tv_letrero.setText("Esperando trabajo\nTrabajos realizados: "+trabajos);
            }else{
                tv_letrero.setText("Esperando trabajo\nTrabajos realizados: "+trabajos+"\nÚltimo trabajo no realizado");
            }
        }
    }

    public void tarea() throws InterruptedException {
        Thread.sleep(5000);
    }
}
