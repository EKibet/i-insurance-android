package com.moringaschool.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.life) Button mLife;
    @BindView(R.id.patent) Button  mPatent;
    @BindView(R.id.website) Button mWebsite;
    @BindView(R.id.insuarance) Button mInsuarance;
    @BindView(R.id.agent) Button mAgent;
    @BindView(R.id.settings) Button mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        ButterKnife.bind(this);

        mLife.setOnClickListener(this);
        mPatent.setOnClickListener(this);
        mWebsite.setOnClickListener(this);
        mInsuarance.setOnClickListener(this);
        mAgent.setOnClickListener(this);
        mSettings.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mWebsite) {
            flipIt(v);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(browserIntent);
        }
        if (v == mAgent) {
            flipIt(v);
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0712345678"));
            startActivity(intent);
        }
        if (v == mPatent) {
            flipIt(v);
            Intent intent = new Intent(SecondActivity.this, Patents.class);
            startActivity(intent);
        }
        if (v == mLife) {
            flipIt(v);
            Intent intent = new Intent(SecondActivity.this, Personal.class);
            startActivity(intent);
        }

    }
    private void flipIt(final View viewToFlip) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(viewToFlip, "rotationX", 0f, 360f);
        flip.setDuration(500);
        flip.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}