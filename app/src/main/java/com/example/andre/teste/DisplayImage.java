package com.example.andre.teste;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class DisplayImage extends AppCompatActivity {
String path ;
    ImageView ivCurrent;
    String imgURL;
    private TextView teste;
    ContextWrapper con;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        teste= findViewById(R.id.testView);

        Intent mainActivityIntent = getIntent();

         con = new ContextWrapper(getApplicationContext());



        StrictMode.setThreadPolicy(policy);

        if (mainActivityIntent.hasExtra(Intent.EXTRA_TEXT)) {

            imgURL = mainActivityIntent.getStringExtra(Intent.EXTRA_TEXT);


        }
        else
        {

            teste.setText("URL Invalido");

        }

        ivCurrent = findViewById(R.id.show_image);

        DownloadAndReadImage dRI = new DownloadAndReadImage(imgURL, con);

       path = dRI.downloadBitmapImage();

        dRI.loadImageFromStorage(path, ivCurrent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }


}

