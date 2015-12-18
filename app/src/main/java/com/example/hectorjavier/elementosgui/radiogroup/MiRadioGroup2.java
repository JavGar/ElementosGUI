package com.example.hectorjavier.elementosgui.radiogroup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hectorjavier.elementosgui.R;

public class MiRadioGroup2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_radio_group2);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);

        final TextView tv_resultado = (TextView) findViewById(R.id.resultado);
        final TextView tv_operacion = (TextView) findViewById(R.id.operacion);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                tv_resultado.setText("Valor del tag: " + rb.getTag());
                switch (Integer.valueOf(rb.getTag().toString())){
                    case 1:
                        tv_operacion.setText("5 + 3 = "+(5+3));
                        break;
                    case 2:
                        tv_operacion.setText("5 - 3 = "+ (5-3));
                        break;
                    case 3:
                        tv_operacion.setText("5 * 3 = "+(5*3));
                        break;
                    case 4:
                        tv_operacion.setText("5 / 3 = "+(5/3));
                        break;
                }
            }
        });
    }
}
