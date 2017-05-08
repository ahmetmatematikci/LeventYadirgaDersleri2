package com.egitim.ahmetmatematikci.bataryagsterge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.bat_icon);
        tv = (TextView)findViewById(R.id.textView);

        this.registerReceiver(this.batarya_bilgi, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));




    }
    private  BroadcastReceiver batarya_bilgi = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            tv.setText("% " + level);

            if (level > 90) {
                iv.setImageResource(R.mipmap.bat4);
            } else if (level <=90 && level > 60 ) {
                iv.setImageResource(R.mipmap.bat2);
            } else if (level<=60 && level >40) {
                iv.setImageResource(R.mipmap.bat1);
            } else if (level<=40 && level > 30 ) {
                iv.setImageResource(R.mipmap.bat0);
            } else if (level <30){
                iv.setImageResource(R.mipmap.batemphty);
            }

        }
    };


}
