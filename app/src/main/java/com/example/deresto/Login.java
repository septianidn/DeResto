package com.example.deresto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deresto.model.AuthObject;
import com.example.deresto.model.DataLogin;
import com.example.deresto.retrofit.LoginEndPoint;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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



        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Config.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder
                .client(httpClient.build())
                .build();
        LoginEndPoint loginClient = retrofit.create(LoginEndPoint.class);

        Call <AuthObject> call = loginClient.checkLogin(username, password);

        call.enqueue(new Callback<AuthObject>() {
            @Override
            public void onResponse(Call<AuthObject> call, Response<AuthObject> response) {
                 AuthObject authObject = response.body();

                 if (authObject != null){
                     DataLogin dataLogin = authObject.getData();
                     String username = dataLogin.getUsername();

                     SharedPreferences sharedPreferences = getSharedPreferences("com.example.deresto.PREFS",MODE_PRIVATE);
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     String token = dataLogin.getToken();
                     String nama = dataLogin.getNama();
                     String email = dataLogin.getEmail();
                     String no_hp = dataLogin.getNoHp();

                     editor.putString("Token", token);
                     editor.putString("Nama", nama);
                     editor.putString("Email", email);
                     editor.putString("NoHp", no_hp);
                     editor.putString("Username", username);
                     editor.apply();

                     Toast.makeText(getApplicationContext(), "Selamat Datang "+nama, Toast.LENGTH_SHORT).show();

                     Intent intent = new Intent(getApplicationContext(), Home.class);
                     startActivity(intent);
                     finish();
                 }
                 else {
                     Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
                 }

            }

            @Override
            public void onFailure(Call<AuthObject> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Akses  gagal", Toast.LENGTH_SHORT).show();

            }
        });

//        if(username.equals("admin") && password.equals("admin123")){
//            Intent intent = new Intent(this, Home.class);
//            startActivity(intent);
//            finish();
//
//        }else{
//            Toast.makeText(this, "Password atau Username Salah!", Toast.LENGTH_SHORT).show();
//        }


    }
}