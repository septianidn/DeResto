package com.example.deresto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.deresto.adapter.KeranjangAdapter;
import com.example.deresto.model.Keranjang;

import java.util.ArrayList;

public class Cart extends AppCompatActivity implements KeranjangAdapter.onKeranjangViewHolderClick{

    RecyclerView rvListKeranjang;
    KeranjangAdapter keranjangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        keranjangAdapter =  new KeranjangAdapter();
        keranjangAdapter.setListKeranjang(getDataKeranjang());
        keranjangAdapter.setListener(this);

        rvListKeranjang = findViewById(R.id.rvlistkeranjang);
        rvListKeranjang.setAdapter(keranjangAdapter);
        LinearLayoutManager linearManager = new LinearLayoutManager(this);
        rvListKeranjang.setLayoutManager(linearManager);
    }
    public ArrayList<Keranjang> getDataKeranjang(){
        ArrayList<Keranjang> list = new ArrayList<>();
        list.add(new Keranjang(1,"nasi_goreng_homies","Nasi Goreng Homies", 6900));
        list.add(new Keranjang(1,"nasi_goreng_homies","Nasi Goreng Homies", 6900));
        list.add(new Keranjang(1,"nasi_goreng_homies","Nasi Goreng Homies", 6900));
        list.add(new Keranjang(1,"nasi_goreng_homies","Nasi Goreng Homies", 6900));

        return list;
    }

    @Override
    public void onClick(View view, Keranjang keranjang) {
        String message = "Menu anda adalah "+keranjang.nama;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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

    public void Home(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}