package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerOzellestirme extends AppCompatActivity {
    RelativeLayout rl2;
    Spinner sp2;
    String [] renkler = {"Beyaz", "Sarı",  "Kırmızı","Yeşil"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ozellestirme);
        rl2 = (RelativeLayout)findViewById(R.id.rlo);
        sp2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_gorunum ,renkler);
        sp2.setAdapter(adapter);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Renkler seçiliyor" + renkler[position], Toast.LENGTH_LONG).show();

                switch (position) {

                    case 0:
                        rl2.setBackgroundColor(Color.GREEN);


                        break;
                    case 1:
                        rl2.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        rl2.setBackgroundColor(Color.BLUE);
                        break;
                    case 3:
                        rl2.setBackgroundColor(Color.BLACK);
                        break;
                    default:
                        rl2.setBackgroundColor(Color.YELLOW);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
