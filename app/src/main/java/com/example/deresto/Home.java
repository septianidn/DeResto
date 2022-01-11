package com.example.deresto;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deresto.adapter.FavoritAdapter;
import com.example.deresto.model.Favorit;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class Home extends Activity implements FavoritAdapter.onFavoritViewholderClick {

    RecyclerView rvlistFavorit;
    FavoritAdapter favoritAdapter;
    TextView namaPengguna;
    private String nama, token, email, no_hp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.deresto.PREFS", MODE_PRIVATE);

        token = sharedPreferences.getString("Token", null);
        nama = sharedPreferences.getString("Nama", null);
        email = sharedPreferences.getString("Email", null);
        no_hp = sharedPreferences.getString("NoHp", null);

        favoritAdapter = new FavoritAdapter();
        favoritAdapter.setListFavorit(getDataFavorit());

        rvlistFavorit = findViewById(R.id.rvfavorit);
        rvlistFavorit.setAdapter(favoritAdapter);
        LinearLayoutManager linearManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvlistFavorit.setLayoutManager(linearManager);

        namaPengguna = findViewById(R.id.namaPengguna);
        namaPengguna.setText(nama);

//        FirebaseMessaging.getInstance().subscribeToTopic("Promo_Notification");
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

    public void Menu1(View view) {
//        ImageView iv;
//        iv = findViewById(R.)
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("kategori", 1);
        startActivity(intent);
    }
    public void Menu2(View view) {
//        ImageView iv;
//        iv = findViewById(R.)
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("kategori", 2);
        startActivity(intent);
    }
    public void Menu3(View view) {
//        ImageView iv;
//        iv = findViewById(R.)
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("kategori", 3);
        startActivity(intent);
    }

//    public void SendNotif(View view){
//        //Toast.makeText(this, "Ini Notifikasi", Toast.LENGTH_SHORT).show();
//
//        Intent mainIntent = new Intent(this, Cart.class);
//
//        PendingIntent mainPendingIntent = PendingIntent.getActivity(
//                this,
//                12345,
//                mainIntent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationManager notificationManager = (NotificationManager)
//                getSystemService(NOTIFICATION_SERVICE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            NotificationChannel notificationChannel =
//                    new NotificationChannel(
//                            "X123",
//                            "Portal Channel",
//                            NotificationManager.IMPORTANCE_DEFAULT);
//
//            notificationManager.createNotificationChannel(notificationChannel);
//        }
//
//        Notification mynotification =
//                new NotificationCompat.Builder(this, "X123")
//                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
//                    .setContentTitle("Pesananmu Sedang di Proses")
//                    .setContentText("Pesananmu sedang dibuat dengan bumbu penuh cinta")
//                    .setContentIntent(mainPendingIntent)
//                    .addAction(R.drawable.ic_baseline_arrow_forward_ios_24, "Buka", mainPendingIntent)
//                    .build();
//
//        notificationManager.notify(123, mynotification);
//    }

}
