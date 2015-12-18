package com.example.hectorjavier.elementosgui.radiogroup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hectorjavier.elementosgui.R;

public class MiRadioGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_radio_group);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);

        final TextView tv_resultado = (TextView) findViewById(R.id.resultado);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                tv_resultado.setText(""+rb.getText());
            }
        });
    }
}
