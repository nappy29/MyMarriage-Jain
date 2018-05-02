package com.example.root.mymarriage_jain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by root on 6/24/17.
 */

public class HomeActivity extends AppCompatActivity {

    @Override public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.home_activity);
    }

    public void login(View v){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    public void signUp(View v){
        startActivity(new Intent(getApplicationContext(), SignupActivity.class));
    }
}
