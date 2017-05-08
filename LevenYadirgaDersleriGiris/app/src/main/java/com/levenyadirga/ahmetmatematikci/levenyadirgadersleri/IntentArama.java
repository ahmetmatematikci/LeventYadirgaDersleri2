package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class IntentArama extends AppCompatActivity {
    EditText et;
    TextView tv;
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_arama);

        et = (EditText)findViewById(R.id.editText2);
        ib = (ImageButton) findViewById(R.id.imageButton);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(et.getText())) {
                    Intent ix = new Intent(Intent.ACTION_CALL);
                    ix.setData(Uri.parse("tel:"+et.getText().toString()));
                    startActivity(ix);

                } else  {
                    Toast.makeText(getApplicationContext(), "Lütefen numara giriniz", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
