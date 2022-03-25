package com.reintrinh.demotabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setControl() {
        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("home").setIndicator("HOME").setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("contact").setIndicator("CONTACT").setContent(R.id.tab2));
        tabHost.addTab(tabHost.newTabSpec("about").setIndicator("ABOUT").setContent(R.id.tab3));

        tabHost.setCurrentTab(0);
    }
}