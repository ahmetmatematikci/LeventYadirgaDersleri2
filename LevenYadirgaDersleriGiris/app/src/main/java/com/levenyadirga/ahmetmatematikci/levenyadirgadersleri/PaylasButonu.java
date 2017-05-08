package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaylasButonu extends AppCompatActivity {

    TextView tv;
    Button bt;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paylas_butonu);

       tv = (TextView)findViewById(R.id.textView10);
        bt  = (Button)findViewById(R.id.button10);
        et = (EditText)findViewById(R.id.editText3);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence mesaj = et.getText().toString();
                paylasMesaj(mesaj);
            }

            private void paylasMesaj(CharSequence mesaj) {

                Intent paylasIntent = new Intent(Intent.ACTION_SEND);
                paylasIntent.setType("text/plain");
                paylasIntent.putExtra(Intent.EXTRA_TEXT, mesaj);
                startActivity(Intent.createChooser(paylasIntent, "paylaşın"));
            }
        });
    }
}
