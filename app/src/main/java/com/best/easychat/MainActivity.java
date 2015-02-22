package com.best.easychat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.FrameLayout;


public class MainActivity extends ActionBarActivity {

    private FrameLayout mainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContent = (FrameLayout) findViewById(R.id.main_content);
        getSupportFragmentManager().beginTransaction().add(mainContent.getId(), new ChatFragment()).commit();
    }
}
