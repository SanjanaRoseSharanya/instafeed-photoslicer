package com.example.insta_feedphotoslicer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
//import android.os.Parcelable;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//import javax.imageio.ImageIO;
import java.io.*;
public class HomePage<BufferedImage> extends AppCompatActivity implements View.OnClickListener {

    Button gal, makeGrid;
    ImageView image;
    //Bitmap tiles[];
   // ImageView sample;
    private static int RESULT_IMAGE = 1;
    //private ByteArrayInputStream ImageIO;
    //private OutputStream ImageIO;


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
    public void onClick(View v)  {
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

        image.buildDrawingCache();
        Bitmap original_image = image.getDrawingCache();

        int grid_side = 3; //as it is a 3x3 grid
        int total_tiles = grid_side*grid_side; //total num of tiles
        int tile_length = image.getWidth() / grid_side; //stores pixel length of a single tile

        Bitmap tiles[] = new Bitmap[total_tiles]; //array of buffered image

        int pos = 0;
        for (int tile_col = 0; tile_col < grid_side; tile_col++)
        {

            for (int tile_row = 0; tile_row < grid_side; tile_row++)
            {
                tiles[pos] = Bitmap.createBitmap(original_image,tile_row*(original_image.getWidth()/3),tile_col*original_image.getWidth()/3, original_image.getWidth()/3, original_image.getWidth()/3);// array of buffered image is initiallized
                Log.d("tag", String.valueOf(pos));
                //sample.setImageBitmap(tiles[pos]);
                pos = pos+1;

            }
        }
        for (int postorder = total_tiles; (postorder > 0)&&(pos<total_tiles); postorder--)
        {
            File slice = new File("Post" + (postorder) + ".png");
            storeImage(tiles[pos],"(\"Post\" + (postorder) + \".png\")");
            pos++;
        }

        //try {
            //pos = 0;
            //for (int postorder = total_tiles; (postorder > 0) && (pos < total_tiles); postorder--) {
                //File file = new File("Post" + (postorder) + ".jpeg");
                //ByteArrayOutputStream out = new ByteArrayOutputStream();
                //tiles[pos].compress(Bitmap.CompressFormat.JPEG, 90, out);
                //Drawable d = Drawable.createFromStream(new ByteArrayInputStream(out[pos]), null);

                /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
                tiles[pos].compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
                InputStream is;*/

                //int buff = ImageIO.read(byteArray);
                //ImageIO.write(bis , "jpg", new File("final_file.jpg") );
                //BufferedImage buffimage = ImageIO.read(bis);
                //ImageIO.write(buffimage, "jpg", new File("output.jpg") );

           // }
       // }
        //catch (Exception e){}

    }


    public void storeImage(Bitmap bitmap, String filename) {
        String path = Environment.getExternalStorageDirectory().toString() + "/" + filename;
        OutputStream out = null;
        File imageFile = new File(path);

        try {
            out = new FileOutputStream(imageFile);
            // choose JPEG format
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
        } catch (FileNotFoundException e) {
            // manage exception ...
        } catch (IOException e) {
            // manage exception ...
        } finally {

            try {
                if (out != null) {
                    out.close();
                }

            } catch (Exception exc) {
            }

        }
    }


}