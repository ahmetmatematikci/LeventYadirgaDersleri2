package com.egitim.ahmetmatematikci.leventyadrgadersleri;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class DialogPencere extends AppCompatActivity {
    String [] renkler  = {"Kırmızı", "Yeşil", "Mavi","Sarı","Turkuaz", "Pembe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_pencere);
    }


    public void  onClickB(View v) {

        switch (v.getId()) {

            case R.id.button:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("UYarı");
                builder.setMessage("Silmek istediğinzden Eminmisiniz");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setCancelable(false);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //evet butonu  işlemleri
                        Toast.makeText(getApplicationContext(), "Evet Butonuna Tıkladı", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Hayır Tıklanınca Yapualcakalr
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();


                break;

            case R.id.button2:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Liste Şeklinde Dialog");
                builder1.setItems(renkler, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Seçilen Renk" + renkler[which], Toast.LENGTH_LONG).show();

                    }
                });
                AlertDialog alertDialog1 = builder1.create();
                alertDialog1.show();


                break;

            case R.id.button3:
                final Dialog dialog2 = new Dialog(this);
                dialog2.setTitle("Custom Dialog");
                dialog2.setContentView(R.layout.custom_dialog);
                Button kaydet =(Button)dialog2.findViewById(R.id.button4);
                Button vazgec =(Button)dialog2.findViewById(R.id.button5);
                DatePicker datePicker = (DatePicker)dialog2.findViewById(R.id.datePicker);
                kaydet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "İleride veri tabanına katdedilecel", Toast.LENGTH_LONG).show();
                        dialog2.dismiss();

                    }
                });

                vazgec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "İleride veri tabanına İptal edilecek", Toast.LENGTH_LONG).show();
                        dialog2.cancel();
                    }
                });

                dialog2.show();
                break;

        }

    }

}
