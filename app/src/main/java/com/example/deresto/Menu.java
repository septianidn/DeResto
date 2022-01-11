package com.example.deresto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deresto.adapter.MakananAdapter;
import com.example.deresto.model.AuthObject;
import com.example.deresto.model.Barang;
import com.example.deresto.model.ListBarang;
import com.example.deresto.model.Makanan;
import com.example.deresto.retrofit.LoginEndPoint;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Menu extends Activity{

    RecyclerView rvlistmakanan;
    MakananAdapter makananAdapter;
    public int kategori;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();

        kategori = intent.getIntExtra("kategori",0);


        makananAdapter = new MakananAdapter(null);

        rvlistmakanan = findViewById(R.id.rvlmenumakanan);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvlistmakanan.setLayoutManager(gridLayoutManager);

        getDataMakanan();
    }

    public void getDataMakanan(){
        ArrayList<Makanan> list = new ArrayList<>();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Config.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder
                .client(httpClient.build())
                .build();
        LoginEndPoint getBarang = retrofit.create(LoginEndPoint.class);

        Call<ListBarang> item = getBarang.getListBarang(1);

        item.enqueue(new Callback<ListBarang>() {
            @Override
            public void onResponse(Call<ListBarang> call, Response<ListBarang> response) {
                if(response.code() == 200){
                        ListBarang listBarangClass = response.body();
                        List<Barang> listBarang = listBarangClass.getBarang();
                        ArrayList<Makanan> barangArrayList = new ArrayList<>();
                        MakananAdapter makananAdapter = new MakananAdapter(barangArrayList);

                        for (Barang dataBarang: listBarang) {
                            Makanan makanan = new Makanan(
                                    dataBarang.getGambar(),
                                    dataBarang.getDeskripsiBarang(),
                                    dataBarang.getNamaBarang(),
                                    " (120)",
                                    dataBarang.getHargaBarang()
                            );
                            barangArrayList.add(makanan);
                            rvlistmakanan.setAdapter(makananAdapter);
                            makananAdapter.notifyDataSetChanged();
                    }
            }
            }

            @Override
            public void onFailure(Call<ListBarang> call, Throwable t) {

            }
        });

    }

    public void Home(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void cart(View view) {
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
