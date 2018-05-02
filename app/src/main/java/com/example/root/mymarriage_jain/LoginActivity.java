package com.example.root.mymarriage_jain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by root on 6/24/17.
 */

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.login_activity);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void loggin(View v){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
