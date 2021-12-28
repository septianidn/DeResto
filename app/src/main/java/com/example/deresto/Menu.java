package com.example.deresto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deresto.adapter.MakananAdapter;
import com.example.deresto.model.AuthObject;
import com.example.deresto.model.Makanan;
import com.example.deresto.retrofit.LoginEndPoint;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Menu extends Activity implements MakananAdapter.onMakananViewholderClick{

    RecyclerView rvlistmakanan;
    MakananAdapter makananAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        makananAdapter = new MakananAdapter();
        makananAdapter.setListMakanan(getDataMakanan());

        rvlistmakanan = findViewById(R.id.rvlmenumakanan);
        rvlistmakanan.setAdapter(makananAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvlistmakanan.setLayoutManager(gridLayoutManager);
    }

    public ArrayList<Makanan> getDataMakanan(){
        ArrayList<Makanan> list = new ArrayList<>();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Config.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder
                .client(httpClient.build())
                .build();
        LoginEndPoint loginClient = retrofit.create(LoginEndPoint.class);



//        list.add((new Makanan("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)",6900)));
//        list.add((new Makanan("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)",6900)));
//        list.add((new Makanan("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)",6900)));
//        list.add((new Makanan("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)",6900)));
//        list.add((new Makanan("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)",6900)));
//        list.add((new Makanan("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)",6900)));
//        list.add((new Makanan("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)",6900)));
//        list.add((new Makanan("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)",6900)));

        return list;
    }

    public void Home(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void Cart(View view) {
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }

    public void Chat(View view) {
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);
    }

    public void Profile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void setting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }


}
