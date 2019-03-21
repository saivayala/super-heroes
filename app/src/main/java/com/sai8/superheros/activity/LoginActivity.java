package com.sai8.superheros.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sai8.superheros.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginsigninbutton)
    Button loginbtn;
    @BindView(R.id.loginregisterbutton)
    Button registerbtn;
    @BindView(R.id.loginemail)
    TextInputLayout etemail;
    @BindView(R.id.loginpassword)
    TextInputLayout etpass;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    String email, password;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);


        mAuth = FirebaseAuth.getInstance();


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    protected void loginuser() {
        email = etemail.getEditText().getText().toString().trim();
        password = etpass.getEditText().getText().toString().trim();

        if (email.isEmpty()) {
            etemail.setError(getString(R.string.enter_mail));
            etemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etemail.setError(getString(R.string.enter_valid_mail));
            etemail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etpass.setError(getString(R.string.enter_pwd));
            etpass.requestFocus();
            return;
        }
        if (password.length() < 6) {
            etpass.setError(getString(R.string.enter_peoper_pwd));
            etpass.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    saveuserinfo();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void saveuserinfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("usermail", etemail.getEditText().getText().toString().trim());
        editor.putString("password", etpass.getEditText().getText().toString().trim());
        editor.apply();
    }
}
