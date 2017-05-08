package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class OtomatikDoldurma extends AppCompatActivity {
    AutoCompleteTextView act;
    MultiAutoCompleteTextView mact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otomatik_doldurma);

        act = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        mact = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);

        String [] cihaz = getResources().getStringArray(R.array.cihaz);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, cihaz);
        act.setAdapter(adapter);
        mact.setAdapter(adapter);

        mact.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }
}
