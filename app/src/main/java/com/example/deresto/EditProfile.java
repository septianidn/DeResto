package com.example.deresto;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deresto.model.ResponMessage;
import com.example.deresto.retrofit.LoginEndPoint;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditProfile extends Activity{
    private String nama, token, email, no_hp, username;
    TextView editNama, editUsername, editEmail, editHP;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.deresto.PREFS", MODE_PRIVATE);

        token = sharedPreferences.getString("Token", null);
        nama = sharedPreferences.getString("Nama", null);
        email = sharedPreferences.getString("Email", null);
        no_hp = sharedPreferences.getString("NoHp", null);
        username = sharedPreferences.getString("Username", null);

        editNama = findViewById(R.id.editNama);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editHP = findViewById(R.id.editHP);

        editNama.setText(nama);
        editEmail.setText(email);
        editUsername.setText(username);
        editHP.setText(no_hp);

    }

    public void Cart(View view) {
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }

    public void Chat(View view) {
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);
    }

    public void setting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void Profile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }


    public void edit(View view) {
        String namaEdit = editNama.getText().toString().trim();
        String usernameEdit = editUsername.getText().toString().trim();
        String emailEdit = editEmail.getText().toString().trim();
        String no_hpEdit = editHP.getText().toString().trim();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Config.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder
                .client(httpClient.build())
                .build();
        LoginEndPoint regis = retrofit.create(LoginEndPoint.class);

        Call<ResponMessage> editCall = regis.editProfil(token, namaEdit, usernameEdit, emailEdit,  no_hpEdit);

        editCall.enqueue(new Callback<ResponMessage>() {
            @Override
            public void onResponse(Call<ResponMessage> call, Response<ResponMessage> response) {
                ResponMessage messageResponse = response.body();

                if (response.code() == 200){
                    if (response.isSuccessful()){
                        Intent intent = new Intent(EditProfile.this, Profile.class);
                        intent.putExtra("Nama", namaEdit);
                        intent.putExtra("Username", usernameEdit);
                        intent.putExtra("Email", emailEdit);
                        intent.putExtra("NoHP", no_hpEdit);
                        setResult(RESULT_OK, intent);
                        Toast.makeText(getApplicationContext(), messageResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Data Gagal Diubah", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponMessage> call, Throwable t) {

            }
        });
    }
}
