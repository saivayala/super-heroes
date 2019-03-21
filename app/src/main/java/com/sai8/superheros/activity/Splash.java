package com.sai8.superheros.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sai8.superheros.R;

import static com.sai8.superheros.networkutils.Network.alert;
import static com.sai8.superheros.networkutils.Network.isConnectedToInternet;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    String email, password;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        auth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                check();
            }
        }, SPLASH_TIME_OUT);
    }

    public void check() {
        if (isConnectedToInternet(Splash.this)) {
            SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            email = sharedPreferences.getString("usermail", "0");
            password = sharedPreferences.getString("password", "0");
            if (email != "0" && password != "0") {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(Splash.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Splash.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            } else {
                Intent loginintent = new Intent(Splash.this, LoginActivity.class);
                startActivity(loginintent);
                finish();
            }
        } else {
            alert(Splash.this);

        }
    }


}
