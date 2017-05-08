package com.elfeneri.ahmetmatematikci.elfeneri;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btAc, btKapa, btCikis;
    boolean flashAc = false;
    TextView tvAcik, tvKapali;


    Camera cam = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAc = (Button)findViewById(R.id.button);
        btKapa = (Button)findViewById(R.id.button2);
        btCikis = (Button)findViewById(R.id.button3);
        tvAcik = (TextView)findViewById(R.id.textView2);
        tvKapali = (TextView)findViewById(R.id.textView3);

        btAc.setOnClickListener(this);
        btKapa.setOnClickListener(this);
        btCikis.setOnClickListener(this);


        tvAcik.setVisibility(View.INVISIBLE);
        tvKapali.setVisibility(View.INVISIBLE);

    }




    @Override
    public void onClick(View v) {
        if(!flashAc) {
            tvAcik.setVisibility(View.VISIBLE);
            tvKapali.setVisibility(View.INVISIBLE);

        } else {
            tvAcik.setVisibility(View.INVISIBLE);
            tvKapali.setVisibility(View.VISIBLE);

        }
        switch (v.getId()) {




            case R.id.button:
                //Toast.makeText(getApplicationContext(), "Aç butonuna basıldı", Toast.LENGTH_LONG).show();
                if (!flashAc) {

                    if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {

                        cam = Camera.open();
                        cam.cancelAutoFocus();
                        Camera.Parameters p = cam.getParameters();
                        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        cam.setParameters(p);
                        cam.startPreview();
                        flashAc = true;



                        return;
                    }

                }

                break;


            case R.id.button2:
                // Toast.makeText(getApplicationContext(), "Kapa butonuna basıldı", Toast.LENGTH_LONG).show();
                if (flashAc) {

                    if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                        cam.stopPreview();
                        cam.release();
                        cam = null;



                        tvKapali.setVisibility(View.VISIBLE);

                        flashAc = false;
                        return;

                    }
                }

                break;

            case  R.id.button3:

                System.exit(0);

                break;


        }
    }
}

