package com.moringaschool.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Patents extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.exp1) Button One;
    @BindView(R.id.exp2) Button Two;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patents);
        ButterKnife.bind(this);

        One.setOnClickListener(this);
        Two.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == One) {
            flipIt(v);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(browserIntent);
        }
        if (v == Two) {
            flipIt(v);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(browserIntent);
        }
    }
    private void flipIt(final View viewToFlip) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(viewToFlip, "rotationX", 0f, 360f);
        flip.setDuration(500);
        flip.start();
    }
}