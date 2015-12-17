package com.example.hectorjavier.elementosgui.tabhost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.hectorjavier.elementosgui.R;

/**
 * Created by HectorJavier on 17/12/2015.
 */
public class MiTabHost2 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_host_2);

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Tab 1");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Tab 2");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("Tab 3");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("Tab 4");
        TabHost.TabSpec tab5 = tabHost.newTabSpec("Tab 5");
        TabHost.TabSpec tab6 = tabHost.newTabSpec("Tab 6");

        tab1.setIndicator("Tab1");
        tab1.setContent(new Intent(this,MiTab1.class));
        tab2.setIndicator("Tab2");
        tab2.setContent(new Intent(this,MiTab1.class));
        tab3.setIndicator("Tab3");
        tab3.setContent(new Intent(this,MiTab1.class));
        tab4.setIndicator("Tab4");
        tab4.setContent(new Intent(this,MiTab1.class));
        tab5.setIndicator("Tab5");
        tab5.setContent(new Intent(this,MiTab1.class));
        tab6.setIndicator("Tab6");
        tab6.setContent(new Intent(this,MiTab1.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);
        tabHost.addTab(tab5);
        tabHost.addTab(tab6);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
