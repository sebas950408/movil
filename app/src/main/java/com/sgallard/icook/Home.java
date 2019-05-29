package com.sgallard.icook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Home extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }

    public void ingreView (View view){
        Intent in = new Intent(Home.this,AddIngredent.class);
        startActivity(in);
    }
}
