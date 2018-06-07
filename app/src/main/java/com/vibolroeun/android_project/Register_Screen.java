package com.vibolroeun.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register_Screen extends AppCompatActivity implements View.OnClickListener{

    private Button registerButton;
    private EditText nameTextEdit;
    private EditText emailTextEdit;
    private EditText passwordTextEdit;
    private EditText phoneTextEdit;
    private TextView loginText;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupUI();
    }

    private void setupUI(){

        registerButton = findViewById(R.id.create_account_btnID);
        registerButton.setOnClickListener(this);

        nameTextEdit = findViewById(R.id.name_register_txtID);
        emailTextEdit = findViewById(R.id.email_register_txtID);
        passwordTextEdit = findViewById(R.id.password_register_txtID);
        phoneTextEdit = findViewById(R.id.phone_register_txtID);
        loginText = findViewById(R.id.login_txtID);
        loginText.setOnClickListener(this);

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //go to login_screen when click already account
                Intent intent = new Intent(Register_Screen.this, Login_Screen.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_txtID:
                //go to login_screen when click already account
                intent = new Intent(Register_Screen.this, Login_Screen.class);
                startActivity(intent); break;
            case R.id.create_account_btnID:
                //go to Introduction_screen when click already account
                intent = new Intent(Register_Screen.this, Introduction_Screen.class);
                startActivity(intent); break;
        }
    }
}
