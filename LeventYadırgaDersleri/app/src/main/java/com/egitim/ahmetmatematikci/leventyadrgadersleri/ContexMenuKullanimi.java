package com.egitim.ahmetmatematikci.leventyadrgadersleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ContexMenuKullanimi extends AppCompatActivity {
    ListView liste;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case  R.id.duzenle:

                TextView tv = (TextView)menuInfo.targetView;
                Toast.makeText(getApplicationContext(), "Secile personel: " + tv.getText().toString(), Toast.LENGTH_LONG).show();

                return true;

            case R.id.sil :
                TextView tv2 = (TextView)menuInfo.targetView;
                Toast.makeText(getApplicationContext(), "Secile personel: " + tv2.getText().toString(), Toast.LENGTH_LONG).show();

                return true;


            case R.id.paylas:
                TextView tv3 = (TextView)menuInfo.targetView;
                Toast.makeText(getApplicationContext(), "Secile personel: " + tv3.getText().toString(), Toast.LENGTH_LONG).show();


                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contex_menu_kullanimi);

        String [] personel = getResources().getStringArray(R.array.personel);
        liste = (ListView)findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listemizler, personel);
        liste.setAdapter(adapter);

        registerForContextMenu(liste);


    }
}
