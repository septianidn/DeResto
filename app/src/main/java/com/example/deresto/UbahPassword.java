package com.example.deresto;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class UbahPassword extends Activity{
    EditText passwordBaru, konfirmasiPassword;
    private String token;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_password);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.deresto.PREFS", MODE_PRIVATE);

        token = sharedPreferences.getString("Token", null);

        passwordBaru = findViewById(R.id.passwordBaru);
        konfirmasiPassword = findViewById(R.id.konfirmasiPassword);
    }

    public void Profile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void EditPassword(View view){
        String password = passwordBaru.getText().toString().trim();
        String konfrimasi = konfirmasiPassword.getText().toString().trim();

        if (validation(password,konfrimasi).equals(1)){
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(Config.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = retrofitBuilder
                    .client(httpClient.build())
                    .build();
            LoginEndPoint regis = retrofit.create(LoginEndPoint.class);

            Call<ResponMessage> editCall = regis.editPassword(token,password);

            editCall.enqueue(new Callback<ResponMessage>() {
                @Override
                public void onResponse(Call<ResponMessage> call, Response<ResponMessage> response) {
                    ResponMessage messageResponse = response.body();
                    if (response.code() == 200) {
                        if (response.isSuccessful()) {

                        Intent intent = new Intent(UbahPassword.this, Profile.class);
                        Toast.makeText(getApplicationContext(), messageResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                        else {
                        Toast.makeText(getApplicationContext(), "Password Gagal Diubah", Toast.LENGTH_SHORT).show();
                    }
                }
                }

                @Override
                public void onFailure(Call<ResponMessage> call, Throwable t) {

                }
            });
        }

    }


    public Integer validation(String password, String konfirmasi){
        Integer valid = 1 ;
        if(password.isEmpty()){

            passwordBaru.getBackground().setColorFilter(getResources().getColor(R.color.quantum_pink), PorterDuff.Mode.SRC_ATOP);
            passwordBaru.setError("Masukkan Password!");
            valid = 0;
        }
        else{
            passwordBaru.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        }

        if(konfirmasi.isEmpty()){
            konfirmasiPassword.getBackground().setColorFilter(getResources().getColor(R.color.quantum_pink), PorterDuff.Mode.SRC_ATOP);
            konfirmasiPassword.setError("Masukkan Konfirmasi Password!");
            valid = 0;
        }
        else{
            konfirmasiPassword.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        }
        if(!password.isEmpty() && !konfirmasi.isEmpty()){
            if(!password.equals(konfirmasi)){
                passwordBaru.getBackground().setColorFilter(getResources().getColor(R.color.quantum_pink), PorterDuff.Mode.SRC_ATOP);
                passwordBaru.setError("Password tidak sesuai!");
                konfirmasiPassword.getBackground().setColorFilter(getResources().getColor(R.color.quantum_pink), PorterDuff.Mode.SRC_ATOP);
                konfirmasiPassword.setError("Password tidak sesuai!");
                valid = 0;
            }
            else{
                passwordBaru.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
                konfirmasiPassword.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
                passwordBaru.setError(null);
                konfirmasiPassword.setError(null);
            }
        }
        return valid;
    }
}
