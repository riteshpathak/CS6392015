package com.example.ritesh.practicalpart;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    View view;
    public MainActivityFragment() {
    }

   public Double francs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_main, container, false);
        Button b=(Button)view.findViewById(R.id.button);

        b.setOnClickListener(this);

        return view;
    }



        @Override
        public void onClick(View v) {
            EditText txt=(EditText)view.findViewById(R.id.editText);
            EditText newCurrency=(EditText)view.findViewById(R.id.editText);
            String fin="";
            if(txt.getText()!=null) {
                Double dollar = Double.parseDouble(txt.getText().toString());
                francs = (dollar * 439.36);
                fin = (francs).toString();
            }
            else
            fin="Please enter a value";

            newCurrency.setText(fin.toString());
        }

}
