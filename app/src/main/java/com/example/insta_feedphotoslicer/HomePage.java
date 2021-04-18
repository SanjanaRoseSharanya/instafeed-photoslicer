package com.example.insta_feedphotoslicer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    Button gal, makeGrid;
    ImageView image;
    private static int RESULT_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        gal = findViewById(R.id.gallary);
        makeGrid= findViewById(R.id.makeGrid);
        //bin.setOnClickListener(this);
        gal.setOnClickListener(this);
        makeGrid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.gallary)
        {
            Log.d("tag", "in gallary intent");
            Intent intent = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, RESULT_IMAGE);
        }
        if(v.getId() == R.id.makeGrid)
        {
            Log.d("tag", "in Make Grid");
            Intent I1 = new Intent(HomePage.this, MakeGrid.class);
            startActivity(I1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            if (null != selectedImage) {
                Log.d("tag", "image going to be copied");
//                istring = selectedImageUri.toString();
//                Log.d("tag", istring);
                image = (ImageView) findViewById(R.id.view);
                image.setImageURI(selectedImage);
                Log.d("tag", "image copied");
            }
        }
    }
}