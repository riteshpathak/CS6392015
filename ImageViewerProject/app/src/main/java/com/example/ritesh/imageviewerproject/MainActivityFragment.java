package com.example.ritesh.imageviewerproject;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import java.util.ArrayList;

import java.lang.reflect.Array;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    int[] ima ={R.drawable.eiffeltower,R.drawable.greatwallofchina,R.drawable.rio,R.drawable.statueofliberty,R.drawable.tajmahal};
    Button prev,next;
    ImageView image;
    int count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);



        prev = (Button) view.findViewById (R.id.button1);
        next =(Button) view.findViewById(R.id.button2);
        image = (ImageView) view.findViewById(R.id.imageView);
        prev.setOnClickListener(new OnClickListener() {


            @Override

            public void onClick(View view) {

                image.setImageResource(ima[count]);
                if(count==0){count=4;}
                else {count--;}
                android.view.ViewGroup.LayoutParams layoutParams = image.getLayoutParams();
                layoutParams.width=120;
                layoutParams.height=120;
                image.setLayoutParams(layoutParams);
            }
        });
        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(ima[count]);
                if(count==4){count=0;}
                else{count++;}
                android.view.ViewGroup.LayoutParams layoutParams = image.getLayoutParams();
                layoutParams.width=120;
                layoutParams.height=120;
                image.setLayoutParams(layoutParams);
            }
        });

      return view;
    }

}
