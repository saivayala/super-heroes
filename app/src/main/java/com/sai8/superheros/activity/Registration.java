package com.sai8.superheros.activity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.sai8.superheros.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Registration extends AppCompatActivity {
    protected FirebaseAuth mAuth;
    @BindView(R.id.registeremail)
    TextInputLayout reguser;
    @BindView(R.id.registerpassword)
    TextInputLayout regpwd;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.registerbutton)
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);


        mAuth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    public void registerUser() {
        String username = reguser.getEditText().getText().toString().trim();
        String userpas = regpwd.getEditText().getText().toString().trim();

        if (username.isEmpty()) {
            reguser.setError(getString(R.string.enter_mail));
            reguser.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            reguser.setError(getString(R.string.enter_valid_mail));
            reguser.requestFocus();
            return;
        }
        if (userpas.isEmpty()) {
            regpwd.setError(getString(R.string.enter_pwd));
            regpwd.requestFocus();
            return;
        }
        if (userpas.length() < 6) {
            regpwd.setError(getString(R.string.enter_peoper_pwd));
            regpwd.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(username, userpas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(Registration.this, R.string.user_registerd, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registration.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Registration.this, R.string.something_wrong, Toast.LENGTH_SHORT).show();
                }
                if (task.getException() instanceof FirebaseAuthRecentLoginRequiredException) {
                    Toast.makeText(Registration.this, R.string.already_registerd, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registration.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
