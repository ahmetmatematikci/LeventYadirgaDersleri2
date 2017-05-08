package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class SpinnerCokluListe extends AppCompatActivity {
    RelativeLayout rl;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_coklu_liste);
        sp = (Spinner)findViewById(R.id.spinner);
        rl = (RelativeLayout)findViewById(R.id.rl);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        rl.setBackgroundColor(Color.GREEN);

                        break;
                    case 1:
                        rl.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        rl.setBackgroundColor(Color.BLUE);
                        break;
                    case 3:
                        rl.setBackgroundColor(Color.BLACK);
                        break;
                    default:
                        rl.setBackgroundColor(Color.YELLOW);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
