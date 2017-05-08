package com.egitim.ahmetmatematikci.leventyadrgadersleri;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class GeriButonuEkleme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geri_butonu_ekleme);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            NavUtils.navigateUpTo(this, i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
