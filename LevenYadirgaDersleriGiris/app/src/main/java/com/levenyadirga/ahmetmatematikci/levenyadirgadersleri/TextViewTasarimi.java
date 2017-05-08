package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewTasarimi extends AppCompatActivity {
    TextView tv, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_tasarimi);
        tv = (TextView)findViewById(R.id.textView) ;
        tv2 = (TextView)findViewById(R.id.textView2) ;
        tv3 = (TextView)findViewById(R.id.textView3) ;



        Typeface font = Typeface.createFromAsset(getAssets(),"harbel.ttf");
        tv.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tazıya dokunulduı", Toast.LENGTH_LONG).show();
            }
        });





    }
}
