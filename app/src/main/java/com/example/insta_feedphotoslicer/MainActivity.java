
package com.example.insta_feedphotoslicer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

//rose was here again
//Sanjana was here again
//hi sharanya this is sanjana
//hi sharanya this is Rose
//HOPE U SEE THIS
public class MainActivity extends AppCompatActivity {

    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer= new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                {
                    Intent I1 = new Intent(MainActivity.this, HomePage.class);
                    startActivity(I1);
                    finish();
                }
            }
        },1000);
    }
}