package com.example.insta_feedphotoslicer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MakeGrid extends AppCompatActivity implements View.OnClickListener {

    Button another;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_grid);

        another= findViewById(R.id.another);
        another.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.another) {
            Intent I = new Intent(MakeGrid.this, HomePage.class);
            startActivity(I);
        }

    }
}