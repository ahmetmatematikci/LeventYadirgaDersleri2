package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SMSYolla extends AppCompatActivity {
    Button bt ,btGitti;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsyolla);



        bt = (Button)findViewById(R.id.button11);
        tv = (TextView)findViewById(R.id.textView11);
        btGitti = (Button)findViewById(R.id.button12);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence msj = tv.getText();
                smsGonder(msj);
            }



            private void smsGonder(CharSequence msj) {

                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:05555555555"));
                i.putExtra("smsBody", msj);
                startActivity(i);

            }
        });


        btGitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence msaj = tv.getText();


                smsDirekGonder(msaj);
            }


        });
    }

    private void smsDirekGonder(CharSequence msaj) {

        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage("05555555555", null, msaj.toString(), null, null);

        Intent ix = new Intent();

        startActivity(ix);


    }

}



