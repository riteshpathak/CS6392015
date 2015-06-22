package com.example.ritesh.asynctaskkk;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by Ritesh on 6/22/2015.
 */
public class ImgDownload extends AsyncTask< String, String, Bitmap >
{
    View rootView;

    public ImgDownload(View rootView) {
        Log.w("rit", "Imagedownloader constructor called");
        this.rootView = rootView;
    }

    @Override
    public void onPreExecute()
    { }

    @Override
    public Bitmap doInBackground(String... params) {
        URL url = null;
        HttpURLConnection httpCon = null;
        Bitmap b = null;
        try {

            Log.w("rit", "params0 " + params[0]);

            url = new URL(params[0]);
            Log.w("rit", "Url " + url.getPath());

            httpCon = (HttpURLConnection)     url.openConnection();

            Log.w("rit", "Url connection return " + httpCon.getResponseCode());

            if( httpCon.getResponseCode() != 200)
                throw new Exception(" Failed to connect");

            InputStream is = httpCon.getInputStream();
            b = BitmapFactory.decodeStream( is);
        }
        catch (Exception e) {
            Log.w("rit", "doInBackground error " + e.getMessage());
        }
        finally
        {
            return b;
        }
    }

    @Override
    public void onPostExecute( Bitmap img)
    {
        ImageView iv = (ImageView) rootView.findViewById(R.id.imageView);

        if( iv != null && img != null)
            iv.setImageBitmap( img);
    }

}
