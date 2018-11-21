package com.example.andre.teste;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;


public class StartCamera extends AppCompatActivity {
    private String url;
   private URL myUrl;
    HttpClient httpclient;
    HttpPost httppost;
    ContextWrapper con;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    private EditText urlText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_camera);
        httpclient = new DefaultHttpClient();
        httppost = new HttpPost("http://10.5.5.9/gp/gpControl/command/system/sleep");
         con = new ContextWrapper(getApplicationContext());
        StrictMode.setThreadPolicy(policy);
        urlText = findViewById(R.id.urlImage);
       // WakeOnLan.wakeup("10.5.5.255", "064169123770");
    }




    public void turnOn(View view){

        WakeOnLan.wakeup("10.5.5.255", "064169123770");

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

    public void search_button(View view) {

        url = urlText.getText().toString();
        Intent i = new Intent(this, DisplayImage.class);
        i.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(i);

    }


}
