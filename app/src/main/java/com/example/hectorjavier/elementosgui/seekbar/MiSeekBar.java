package com.example.hectorjavier.elementosgui.seekbar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.hectorjavier.elementosgui.R;

public class MiSeekBar extends AppCompatActivity {

    Button btn_trabajo;
    TextView tv_letrero;
    SeekBar sb_proceso;
    int trabajos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_seek_bar);

        btn_trabajo = (Button) findViewById(R.id.btn_trabajo);
        tv_letrero = (TextView) findViewById(R.id.tv_letrero);
        sb_proceso = (SeekBar) findViewById(R.id.seekBar);
        //sb_proceso.setMax(200);

        btn_trabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RealizaTrabajo().execute(trabajos);
            }
        });
    }

    private class RealizaTrabajo extends AsyncTask<Integer,Integer,Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            sb_proceso.setVisibility(View.VISIBLE);
            sb_proceso.setProgress(0);
            tv_letrero.setText("Realizando Trabajo");
        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            try {
                for (int i=1;i<=10;i++){
                    tarea();
                    publishProgress(i*10);
                }
            } catch (InterruptedException e) {
                return false;
            }
            params[0]++;
            trabajos=params[0];
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            sb_proceso.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            sb_proceso.setVisibility(View.GONE);
            if(aBoolean){
                tv_letrero.setText("Esperando trabajo\nTrabajos realizados: "+trabajos);
            }else{
                tv_letrero.setText("Esperando trabajo\nTrabajos realizados: "+trabajos+"\nÚltimo trabajo no realizado");
            }
        }
    }

    public void tarea() throws InterruptedException {
        Thread.sleep(1000);
    }
}
