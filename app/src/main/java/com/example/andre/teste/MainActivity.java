package com.example.andre.teste;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private String url;
private EditText urlText;
private TextView teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // urlText = findViewById(R.id.urlImage);
        ContextWrapper con = new ContextWrapper(getApplicationContext());



    }
   /* private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return urls[0];
        }

    }

    public void turnOff(View view){
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/system/sleep");
    }

    public void search_button(View view) {



        url = "http://10.5.5.9:8080/videos/DCIM/100GOPRO/G0014034.JPG" ;
                *//*urlText.getText().toString();*//*
        Intent i = new Intent(this, DisplayImage.class);
        i.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(i);

    }
*/

    public void startApp(View view){
        Intent i = new Intent(this, StartCamera.class);
        startActivity(i);
    }
}

