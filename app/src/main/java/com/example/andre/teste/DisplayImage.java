package com.example.andre.teste;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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



    public void turnOff(View view){

        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/system/sleep");

    }



    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Done!", Toast.LENGTH_SHORT).show();
            ;
        }
    }

}
