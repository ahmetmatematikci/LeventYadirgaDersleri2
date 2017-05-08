package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastMesaji extends AppCompatActivity {
    Button btn, btnR, btnO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_mesaji);

        btn = (Button)findViewById(R.id.button);
        btnR = (Button)findViewById(R.id.button2);
        btnO = (Button)findViewById(R.id.button3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Toast Basit mesaj..", Toast.LENGTH_LONG).show();

            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView csgb = new ImageView(getApplicationContext());
                csgb.setImageResource(R.drawable.csgb);
                Toast toast = new Toast(getApplicationContext());
                toast.setView(csgb);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();


            }
        });

        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = new TextView(getApplicationContext());

                tv.setText("Bu özel Bir toasttır");
                tv.setBackgroundColor(Color.GREEN);
                tv.setTextColor(Color.parseColor("#01230F"));
                tv.setTextSize(20);
                Toast t = new Toast(getApplicationContext());
                t.setView(tv);
                t.setDuration(Toast.LENGTH_LONG);
                t.show();

            }
        });

    }
}
