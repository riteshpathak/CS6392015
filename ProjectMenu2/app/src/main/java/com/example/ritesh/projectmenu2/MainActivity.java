package com.example.ritesh.projectmenu2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.text.Normalizer;


public class MainActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onBtnClicked(View v)
    {
        if(v.getId() == R.id.button)
        {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address", "+19174345315");
            smsIntent.putExtra("sms_body","Type you text here");
            startActivity(smsIntent);
        }

        if(v.getId() == R.id.button2)
        {
            String phno="tel:9174345315";

            Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse(phno));
            startActivity(i);
        }
        if(v.getId() == R.id.button3)
        {
            Uri uri = Uri.parse("http://www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        if(v.getId() == R.id.button4)
        {
            String uri = ("geo:19.241201600000000000,72.852946699999960000?q=19.241201600000000000,72.852946699999960000,(My Birth + Place)");
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent);

        }
        if(v.getId() == R.id.button5)
        {
            Window w = getWindow();
            w.setTitle("Share the Love");

        }

        if(v.getId()==R.id.button6)
        {
            Intent intent = new Intent(MainActivity.this, NewActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }

    public void MessageBox(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_help) {
            Intent help = new Intent(MainActivity.this,HelpActivity.class);
            startActivity(help);

        }


        return super.onOptionsItemSelected(item);
    }
}
