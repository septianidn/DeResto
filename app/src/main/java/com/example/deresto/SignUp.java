package com.example.deresto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deresto.model.AuthObject;
import com.example.deresto.model.ResponMessage;
import com.example.deresto.retrofit.LoginEndPoint;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {

    EditText inputEmail, inputUsername, inputNama, inputNoHp, inputPassword, inputConfirmPassword;
    CheckBox sDanK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputEmail = findViewById(R.id.editTextEmail);
        inputUsername = findViewById(R.id.editTextUsername);
        inputNama = findViewById(R.id.editTextNama);
        inputNoHp = findViewById(R.id.editTextPhone);
        inputPassword = findViewById(R.id.editTextPassword);
        inputConfirmPassword = findViewById(R.id.editTextPasswordKonfirmasi);
        sDanK = findViewById(R.id.checkBox);

        sDanK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sDanK.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#FFCC00")));
            }
        });
    }

    public void kembali_landing(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void login(View view) {
        String nama = inputNama.getText().toString().trim();
        String username = inputUsername.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String no_hp = inputNoHp.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        String K_password = inputConfirmPassword.getText().toString().trim();

        if(!sDanK.isChecked()){
            sDanK.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#FF0000")));
        }


        if(sDanK.isChecked()){

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(Config.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = retrofitBuilder
                    .client(httpClient.build())
                    .build();
            LoginEndPoint regis = retrofit.create(LoginEndPoint.class);

            Call<ResponMessage> regisCall = regis.register(nama, username, email, password, no_hp);

            regisCall.enqueue(new Callback<ResponMessage>() {
                @Override
                public void onResponse(Call<ResponMessage> call, Response<ResponMessage> response) {
                    ResponMessage messageResponse = response.body();

                    if (response.code() == 200){
                        if (response.isSuccessful()){
                            Intent intent = new Intent(SignUp.this, Login.class);
                            Toast.makeText(getApplicationContext(), messageResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Register Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponMessage> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}