package com.example.insta_feedphotoslicer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Download extends AppCompatActivity implements View.OnClickListener {

    Button anotherGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        anotherGrid= findViewById(R.id.anotherGrid);
        anotherGrid.setOnClickListener(this);

    }
    public void onClick(View v) {
        if(v.getId()==R.id.anotherGrid) {
            Intent I = new Intent(Download.this, HomePage.class);
            startActivity(I);
        }

    }
}