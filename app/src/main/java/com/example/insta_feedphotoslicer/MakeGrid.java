package com.example.insta_feedphotoslicer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.insta_feedphotoslicer.HomePage.SplitImage;

public class MakeGrid extends AppCompatActivity implements View.OnClickListener {

    ImageView img0,img1 ,img2,img3,img4,img5,img6,img7,img8;
    Button download;
    Bitmap bmp [];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("tag", "Inside Make Grid");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_grid);

        download= findViewById(R.id.download);
        download.setOnClickListener(this);
        bmp= SplitImage();

        img0= (ImageView)findViewById(R.id.img0);
        img0.setImageBitmap(bmp[0]);

        img1= (ImageView)findViewById(R.id.img1);
        img1.setImageBitmap(bmp[1]);

        img2= (ImageView)findViewById(R.id.img2);
        img2.setImageBitmap(bmp[2]);

        img3= (ImageView)findViewById(R.id.img3);
        img3.setImageBitmap(bmp[3]);

        img4= (ImageView)findViewById(R.id.img4);
        img4.setImageBitmap(bmp[4]);

        img5= (ImageView)findViewById(R.id.img5);
        img5.setImageBitmap(bmp[5]);

        img6= (ImageView)findViewById(R.id.img6);
        img6.setImageBitmap(bmp[6]);

        img7= (ImageView)findViewById(R.id.img7);
        img7.setImageBitmap(bmp[7]);

        img8= (ImageView)findViewById(R.id.img8);
        img8.setImageBitmap(bmp[8]);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.download) {
            Intent I = new Intent(MakeGrid.this, Download.class);
            startActivity(I);
        }

    }
}