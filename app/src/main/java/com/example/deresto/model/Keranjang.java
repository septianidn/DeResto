package com.example.deresto.model;

public class Keranjang {
    public Integer quantity;
    public String menu;
    public String nama;
    public Integer price;

    public Keranjang() { }

    public Keranjang(Integer quantity, String menu, String nama, Integer price) {
        this.quantity = quantity;
        this.nama = nama;
        this.menu = menu;
        this.price = price;
    }
}
