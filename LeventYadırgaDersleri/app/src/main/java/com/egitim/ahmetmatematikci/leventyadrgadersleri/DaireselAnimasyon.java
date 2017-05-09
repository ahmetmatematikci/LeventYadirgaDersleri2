package com.egitim.ahmetmatematikci.leventyadrgadersleri;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DaireselAnimasyon extends AppCompatActivity {
    LinearLayout ly;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairesel_animasyon);
        ly = (LinearLayout)findViewById(R.id.linery);
        tv = (TextView)findViewById(R.id.textView);
    }

    public void onClickAc(View view) {
        if (view.getVisibility() != View.VISIBLE) {
            int cx = view.getLeft() + 4*view.getRight()/4;
            int cy = view.getTop() + 4*view.getBottom()/5;
            int radius = Math.max(view.getWidth(), view.getHeight());


            Animator animator = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                animator = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, radius);
            } else {
                tv.setText("Sdk nız 21 den küçük bu yzüden animasyon çalışmıyor");

            }

                    view.setVisibility(View.VISIBLE);
            animator.start();

        }



    }

    public void onClickKapa(final View view) {
        if (view.getVisibility() == View.VISIBLE) {
            int cx = view.getLeft() + 4*view.getRight()/4;
            int cy = view.getTop() + 4*view.getBottom()/5;
            int radius = Math.max(view.getWidth(), view.getHeight());


            Animator animator = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                animator = ViewAnimationUtils.createCircularReveal(view, cx, cy, radius, 0);
            } else {
                tv.setText("Sdk nız 21 den küçük bu yzüden animasyon çalışmıyor");

            }
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.INVISIBLE);
                }
            });
            animator.start();
        }

    }
}
