package com.example.hectorjavier.elementosgui.tabhost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.example.hectorjavier.elementosgui.R;

/**
 * Created by HectorJavier on 17/12/2015.
 */
public class MiTabHost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_host);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab 1");
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab 2");
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab 3");
        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("Tab 4");
        TabHost.TabSpec tabSpec5 = tabHost.newTabSpec("Tab 5");
        TabHost.TabSpec tabSpec6 = tabHost.newTabSpec("Tab 6");

        tabSpec1.setIndicator("Primera");
        tabSpec1.setContent(R.id.linearLayout);
        tabSpec2.setIndicator("Segunda");
        tabSpec2.setContent(R.id.linearLayout2);
        tabSpec3.setIndicator("Tercera");
        tabSpec3.setContent(R.id.linearLayout3);
        tabSpec4.setIndicator("Cuarta");
        tabSpec4.setContent(R.id.linearLayout4);
        tabSpec5.setIndicator("Quinta");
        tabSpec5.setContent(R.id.linearLayout5);
        tabSpec6.setIndicator("Sexta");
        tabSpec6.setContent(R.id.linearLayout6);

        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
        tabHost.addTab(tabSpec4);
        tabHost.addTab(tabSpec5);
        tabHost.addTab(tabSpec6);

        tabHost.setCurrentTab(1);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
