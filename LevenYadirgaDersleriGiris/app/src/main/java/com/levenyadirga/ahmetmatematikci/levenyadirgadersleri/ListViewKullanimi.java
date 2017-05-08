package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewKullanimi extends AppCompatActivity {
    String [] iller = getResources().getStringArray(R.array.sehirler);
    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_kullanimi);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,iller);

        ls.setAdapter(adapter);
         ls = (ListView)findViewById(R.id.ls);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Se.ilen eleman " + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}
