package com.example.deresto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deresto.adapter.FavoritAdapter;
import com.example.deresto.model.Favorit;

import java.util.ArrayList;

public class Home extends Activity implements FavoritAdapter.onFavoritViewholderClick {

    RecyclerView rvlistFavorit;
    FavoritAdapter favoritAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        favoritAdapter = new FavoritAdapter();
        favoritAdapter.setListFavorit(getDataFavorit());

        rvlistFavorit = findViewById(R.id.rvfavorit);
        rvlistFavorit.setAdapter(favoritAdapter);
        LinearLayoutManager linearManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvlistFavorit.setLayoutManager(linearManager);

    }

    public ArrayList<Favorit> getDataFavorit(){
        ArrayList<Favorit> list = new ArrayList<>();
        list.add(new Favorit("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)", 6900));
        list.add(new Favorit("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)", 6900));
        list.add(new Favorit("nasi_goreng_homies", "Nasi Goreng Homies", "4.2 (120)", 6900));

        return list;
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

    public void Menu(View view) {
//        ImageView iv;
//        iv = findViewById(R.)
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

}
