package com.example.deresto;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class Profile extends Activity {

    private String nama, token, email, no_hp, username;
    private TextView namaGede;
    TextView profilNama, profilUsername, profilEmail, profilHP;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.deresto.PREFS", MODE_PRIVATE);

         token = sharedPreferences.getString("Token", null);
         nama = sharedPreferences.getString("Nama", null);
         email = sharedPreferences.getString("Email", null);
         no_hp = sharedPreferences.getString("NoHp", null);
         username = sharedPreferences.getString("Username", null);

         profilNama = findViewById(R.id.profilNama);
         namaGede = findViewById(R.id.namaGede);
        profilEmail = findViewById(R.id.profilEmail);
        profilUsername = findViewById(R.id.profilUsername);
        profilHP = findViewById(R.id.profilHP);

        profilNama.setText(nama);
        profilUsername.setText(username);
        profilEmail.setText(email);
        profilHP.setText(no_hp);
        namaGede.setText(nama);



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

    public void EditProfile(View view) {
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    public void kembali_landing(View view) {

        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Yakin mau keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                                .baseUrl(Config.API_BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create());

                        Retrofit retrofit = retrofitBuilder
                                .client(httpClient.build())
                                .build();
                        LoginEndPoint logout = retrofit.create(LoginEndPoint.class);

                        Call<ResponMessage> call = logout.logout(token);

                        call.enqueue(new Callback<ResponMessage>() {
                            @Override
                            public void onResponse(Call<ResponMessage> call, Response<ResponMessage> response) {
                                if (response.code() == 200){
                                    if (response.isSuccessful()){
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                        finish();
                                        startActivity(intent);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponMessage> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }


    public void UbahPassword(View view) {
        Intent intent = new Intent(this, UbahPassword.class);
        startActivity(intent);
    }


}
