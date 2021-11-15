package com.example.deresto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

}
