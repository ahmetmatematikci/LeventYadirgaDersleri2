package com.egitim.ahmetmatematikci.leventyadrgadersleri;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] sayfalar = {"ContexMenuKullanimi", "ContexMenuActionMode","DialogPencere","UygulamaOrnegi",
    "GeriButonuEkleme","XMLParse","MeterialDesign","ScrolingBar", "DaireselAnimasyon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.listemiz, sayfalar));

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String sayfa = sayfalar[position];
        Class gis;

        try {
            gis = Class.forName("com.egitim.ahmetmatematikci.leventyadrgadersleri." + sayfa);
            Intent i = new Intent(getApplicationContext(), gis);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Sayfa Bulunamadı", Toast.LENGTH_LONG).show();
        }
    }
}
