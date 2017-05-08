package com.egitim.ahmetmatematikci.leventyadrgadersleri;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class UygulamaOrnegi extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    Button btn;
    int count;
    RelativeLayout rl;
boolean sesDurumu , titresimDurumu;
    SharedPreferences preferences, ayarlar;

    @Override
    protected void onPause() {
        SharedPreferences.Editor  editor = preferences.edit();
        editor.putInt("count_anahtari", count);
        editor.commit();
        super.onPause();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uygulama_ornegi);
        rl = (RelativeLayout)findViewById(R.id.relativ);
        btn = (Button)findViewById(R.id.button6);
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ayarlar = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        ayarlariYukle();

        count = preferences.getInt("count_anahtari", 0);
        btn.setText("" + count);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                btn.setText("" + count);

            }
        });
    }

    private void ayarlariYukle() {
        String pos = ayarlar.getString("arkaplan", "5");
        switch (Integer.valueOf(pos)) {
            case 0:
                rl.setBackgroundColor(Color.RED);
                break;
            case 1:
                rl.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                rl.setBackgroundColor(Color.BLUE);
                break;
            case 3:
                rl.setBackgroundColor(Color.YELLOW);
                break;
            case 4:
                rl.setBackgroundColor(Color.CYAN);
                break;
            case 5:
                rl.setBackgroundColor(Color.WHITE);
                break;
            case 6:
                rl.setBackgroundColor(Color.BLACK);
                break;
            default:
                rl.setBackgroundColor(Color.GRAY);


                 }
        sesDurumu = ayarlar.getBoolean("ses", false);
        titresimDurumu  = ayarlar.getBoolean("titresim", false);
        ayarlar.registerOnSharedPreferenceChangeListener(UygulamaOrnegi.this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settign) {
            Intent intent = new Intent(getApplicationContext(), Ayarlar.class);
            startActivity(intent);
            return  true;
        }

        if (id == R.id.sifirla) {
            count = 0;
            btn.setText(" " + count);

            return  true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        ayarlariYukle();

    }
}
