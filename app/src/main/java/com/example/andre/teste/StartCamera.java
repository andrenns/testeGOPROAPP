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

import java.net.URL;


public class StartCamera extends AppCompatActivity {
    private String url;
   private URL myUrl;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    private EditText urlText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_camera);
        ContextWrapper con = new ContextWrapper(getApplicationContext());
        StrictMode.setThreadPolicy(policy);
        urlText = findViewById(R.id.urlImage);
       // WakeOnLan.wakeup("10.5.5.255", "064169123770");
    }




    public void turnOn(View view){

        WakeOnLan.wakeup("10.5.5.255", "064169123770");

    }


    public void search_button(View view) {




        url = urlText.getText().toString();
        Intent i = new Intent(this, DisplayImage.class);
        i.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(i);

    }


}
