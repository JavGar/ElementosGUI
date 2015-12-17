package com.example.hectorjavier.elementosgui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorjavier.elementosgui.tabhost.MiTabHost;
import com.example.hectorjavier.elementosgui.tabhost.MiTabHost2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> listValues = new ArrayList<String>();
        listValues.add("TabHost");
        listValues.add("TabHost2");
        listValues.add("Symbian");
        listValues.add("Blackberry");
        listValues.add("Windows Phone");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listValues);
        setListAdapter(adapter);
    }

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
            default:
                Toast.makeText(getApplicationContext(),"Destino no definido",Toast.LENGTH_SHORT).show();
        }
    }
}
