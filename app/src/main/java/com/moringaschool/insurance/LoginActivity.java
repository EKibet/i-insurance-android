package com.moringaschool.insurance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.login1) Button mLogin;
    @BindView(R.id.password1) EditText mPass;
    @BindView(R.id.email1) EditText mEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        mLogin.setOnClickListener(this);

}


    @Override
    public void onClick(View view) {
        if (view == mLogin){
            flipIt(view);
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }



    private void flipIt(final View viewToFlip) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(viewToFlip, "rotationX", 0f, 360f);
        flip.setDuration(500);
        flip.start();
    }
}


//
//        mLogin = (Button)findViewById(R.id.passwordLoginButton);
//                mPass = (EditText)findViewById(R.id.password);
//                mEmail = (EditText)findViewById(R.id.email);

//    private void login() {
//        String email = mEmail.getText().toString().trim();
//        String password = mPass.getText().toString().trim();
//        if (password.equals("")) {
//            mPass.setError("Password cannot be blank");
//            return;
//        }
//        mAuthProgressDialog.show();
//
//        mLogin.setOnClickListener(v -> {
//            if(mPass.getText().toString().equals("admin") &&
//                    mEmail.getText().toString().equals("admin")) {
//                Toast.makeText(getApplicationContext(),
//                        "Redirecting...",Toast.LENGTH_SHORT).show();
//            }else {
//                Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
//            }
//
//        }