package com.example.deresto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.deresto.adapter.KeranjangAdapter;
import com.example.deresto.model.Keranjang;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    RecyclerView rvListKeranjang;
    KeranjangAdapter keranjangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        keranjangAdapter =  new KeranjangAdapter();
        keranjangAdapter.setListKeranjang(getDataKeranjang());

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
}