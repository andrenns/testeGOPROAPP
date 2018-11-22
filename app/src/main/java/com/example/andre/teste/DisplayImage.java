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
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;


public class DisplayImage extends AppCompatActivity {
String path ;
    ImageView ivCurrent;
    HttpClient httpclient;
    HttpPost httppost;
    String imgURL;
    private TextView teste;
    ContextWrapper con;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
        httpclient = new DefaultHttpClient();
        httppost = new HttpPost("http://10.5.5.9/gp/gpControl/command/system/sleep");
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


        Picasso.with(con).load("http://10.5.5.9:8080/videos/DCIM/100GOPRO/G0014034.JPG").into(ivCurrent);


/*
        DownloadAndReadImage dRI = new DownloadAndReadImage(imgURL, con);

       path = dRI.downloadBitmapImage();

        dRI.loadImageFromStorage(path, ivCurrent);*/

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void turnOff(View view) {

        try {
            httpclient.execute(httppost);
        }
        catch(IOException e)
        {
            Toast.makeText(con,"Failure!", Toast.LENGTH_LONG).show();

        }
/*
        client.get("http://10.5.5.9/gp/gpControl/command/system/sleep", new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String res) {
                Toast.makeText(con,"Sucess!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                Toast.makeText(con,"Failure!", Toast.LENGTH_LONG).show();
            }
        });

       String webID = "http://10.5.5.9/gp/gpControl/command/system/sleep";
        Intent bIntent = new Intent();
        bIntent.setAction(Intent.ACTION_VIEW);
        bIntent.addCategory(Intent.CATEGORY_BROWSABLE);
        bIntent.setData(Uri.parse(webID));
        startActivity(bIntent);*/
        //new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/system/sleep");
    }


}

