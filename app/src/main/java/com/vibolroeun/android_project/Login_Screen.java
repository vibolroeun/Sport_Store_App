package com.vibolroeun.android_project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vibolroeun.android_project.R;

public class Login_Screen extends AppCompatActivity {

    private Button loginButton;
    private EditText emailEditLogin;
    private EditText passwordEditLogin;
    private TextView registerText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();

    }

    private void setupUI(){

        loginButton = findViewById(R.id.login_account_btnID);
        emailEditLogin = findViewById(R.id.email_login_txtID);
        passwordEditLogin = findViewById(R.id.password_login_txtID);
        registerText = findViewById(R.id.register_txtID);

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}
