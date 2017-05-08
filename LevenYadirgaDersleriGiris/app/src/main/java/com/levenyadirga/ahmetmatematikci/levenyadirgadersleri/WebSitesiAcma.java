package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WebSitesiAcma extends AppCompatActivity {
    TextView tv;
    String site = "https://www.youtube.com/watch?v=hPlCe8cVqCA&list=PL9qDMO9EzLX25NTHm0q7svKLx__OZY8-e&index=40";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_sitesi_acma);

        tv = (TextView)findViewById(R.id.textView9);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(site));
                startActivity(i);
            }
        });
    }
}
