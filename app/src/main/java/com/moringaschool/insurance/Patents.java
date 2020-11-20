package com.moringaschool.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Patents extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.eone) Button One;
    @BindView(R.id.etwo) Button Two;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patents);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {

    }
}