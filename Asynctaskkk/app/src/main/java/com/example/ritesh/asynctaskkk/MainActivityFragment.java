package com.example.ritesh.asynctaskkk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    View rootView = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button myb = (Button)rootView.findViewById(R.id.button);
        myb.setOnClickListener(this);
        return rootView;
    }


    public void onClick(View v) {


        ImgDownload id = new ImgDownload(rootView);

        id.execute("http://hubchi.com/wp-content/uploads/2015/03/mumbai.jpg");


    }
}
