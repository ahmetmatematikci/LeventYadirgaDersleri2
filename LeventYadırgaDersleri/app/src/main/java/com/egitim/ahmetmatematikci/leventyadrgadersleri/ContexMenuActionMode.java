package com.egitim.ahmetmatematikci.leventyadrgadersleri;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ContexMenuActionMode extends AppCompatActivity {
    TextView tv;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contex_menu_action_mode);

        tv = (TextView)findViewById(R.id.textView2);

        tv.setText(Html.fromHtml(getResources().getString(R.string.html)));
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode!=null) {
                    return  false;
                }
                MyActionModeCallback callback = new MyActionModeCallback();
                actionMode = startSupportActionMode(callback);
                v.setSelected(true);
                return true;
            }
        });

    }

    class MyActionModeCallback implements  ActionMode.Callback {


        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.contex_menu, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.edit:
                    Toast.makeText(getApplicationContext(), "Düzenleme yapıldı", Toast.LENGTH_LONG).show();

                mode.finish();
                    return  true;

                case R.id.ust_sil:
                    Toast.makeText(getApplicationContext(), "Silme y yapıldı", Toast.LENGTH_LONG).show();

                    mode.finish();
                    return  true;

                default:
                    return  false;
            }
            //return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;


        }
    }

}
