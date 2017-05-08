package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MailYolla extends AppCompatActivity {
    Button bt;
    EditText email, baslik, icerik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_yolla);

        email = (EditText)findViewById(R.id.editText4);
        baslik = (EditText)findViewById(R.id.editText5);
        icerik = (EditText)findViewById(R.id.editText6);

        bt = (Button)findViewById(R.id.button13);
        
  
        
        

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adres = email.getText().toString();
                String konu =  baslik.getText().toString();
                String yazi = icerik.getText().toString();
                
                mailGonder(adres, konu, yazi);
            }

            private void mailGonder(String adres, String konu, String yazi) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{adres});
                i.putExtra(Intent.EXTRA_SUBJECT, konu);
                i.putExtra(Intent.EXTRA_TEXT, yazi);

                try {
                    startActivity(i);
                }catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Hata oluştu \n" +e.getMessage(), Toast.LENGTH_LONG ).show();
                }
            }
        });
    }
}
