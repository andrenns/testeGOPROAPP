package com.example.andre.teste;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayImage extends AppCompatActivity {
String path ;
    ImageView ivCurrent;
    String imgURL;
    private TextView teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        teste= findViewById(R.id.testView);

        Intent mainActivityIntent = getIntent();

        ContextWrapper con = new ContextWrapper(getApplicationContext());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

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

        WakeOnLan.wakeup("10.5.5.255", "28:80:23:F6:E2:3D");

       path = dRI.downloadBitmapImage();

        dRI.loadImageFromStorage(path, ivCurrent);

    }
}
