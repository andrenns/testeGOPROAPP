package com.example.andre.teste;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class DownloadAndReadImage {


    String strURL;
    Bitmap bitmap=null;
    ContextWrapper con;


    // pass image url and Pos for example i:
    DownloadAndReadImage(String url, ContextWrapper con)
    {
        this.strURL=url;
        this.con=con;

    }

    String downloadBitmapImage()
    {
        InputStream input;
        // path to /data/data/yourapp/app_data/imageDir
        File directory = con.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        try {

            URL url = new URL (strURL);
            input = url.openStream();

            byte[] buffer = new byte[2048];
            OutputStream output = new FileOutputStream(mypath);
            try
            {

                int bytesRead = 0;
                while ((bytesRead = input.read(buffer, 0, buffer.length)) >= 0)
                {
                    WakeOnLan.wakeup("10.5.5.255", "28:80:23:F6:E2:3D");
                    output.write(buffer, 0, bytesRead);
                }
            }
            finally
            {
                output.close();
                buffer=null;
            }
        }
        catch(Exception e)
        {
            Toast.makeText(con,e.toString(), Toast.LENGTH_LONG).show();
        }

        return directory.getAbsolutePath();
    }

    public void loadImageFromStorage(String path, ImageView img)
    {

        try {
            File f=new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }


}
