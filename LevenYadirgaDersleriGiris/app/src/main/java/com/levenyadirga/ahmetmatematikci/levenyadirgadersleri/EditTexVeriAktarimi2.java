package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditTexVeriAktarimi2 extends AppCompatActivity {
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tex_veri_aktarimi2);

        tv = (TextView)findViewById(R.id.textView7);
        Bundle gelenVeri = getIntent().getExtras();
        CharSequence gelenYazi = gelenVeri.getCharSequence("deger");
        tv.setText(gelenYazi);


    }
}
