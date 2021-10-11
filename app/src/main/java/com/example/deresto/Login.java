package com.example.deresto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void kembali_landing(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void login(View view) {

        EditText editUsername;
        EditText editPassword;

        editUsername = findViewById(R.id.editTextTextPersonName);
        editPassword = findViewById(R.id.editTextTextPassword);

        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if(username.equals("admin") && password.equals("admin123")){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(this, "Password atau Username Salah!", Toast.LENGTH_SHORT).show();
        }


    }
}