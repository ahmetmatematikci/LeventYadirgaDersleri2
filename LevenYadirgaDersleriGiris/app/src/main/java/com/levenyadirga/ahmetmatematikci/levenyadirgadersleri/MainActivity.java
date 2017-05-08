package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String[] sayfalar = {"ToastMesaji", "ButonKullanimi","TextViewTasarimi","OtomatikDoldurma"
    ,"ChecboxKutlu","SpinnerCokluListe","SpinnerOzellestirme","ListViewKullanimi","EditTexVeriAktarimi"
    ,"IntentArama", "WebSitesiAcma","PaylasButonu","SMSYolla", "MailYolla","OptinsMenuOlusturma",
            "ActionBarOzel","ContextMenuOlusturma"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, sayfalar));


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String sayfa = sayfalar[position];
        Class gis;

        try {
            gis = Class.forName("com.levenyadirga.ahmetmatematikci.levenyadirgadersleri." + sayfa);
            Intent i = new Intent(MainActivity.this, gis);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
