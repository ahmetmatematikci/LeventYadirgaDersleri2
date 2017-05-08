package com.levenyadirga.ahmetmatematikci.levenyadirgadersleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class ChecboxKutlu extends AppCompatActivity {
    TextView tv;
    CheckBox ch;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checbox_kutlu);

        ch = (CheckBox)findViewById(R.id.checkBox);
        bt = (Button)findViewById(R.id.button8);
        tv = (TextView)findViewById(R.id.textView4);

      /*  ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean durum = ch.isChecked();
                if (durum)
                    bt.setEnabled(true);
                 else
                bt.setEnabled(false);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt.setEnabled(false);
                ch.setChecked(false);
            }
        });*/

      ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              isChecked = true;
              if (isChecked)
              tv.setText("Deneme");
              else
                  tv.setText("basılıdeğil ");
          }
      });

    }
}
