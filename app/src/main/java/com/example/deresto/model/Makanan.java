package com.example.deresto.model;

public class Makanan {
    public String imgmakanan;
    public String star;
    public String deskripsi;
    public String plus;
    public String menumakanan;
    public String ratingmakanan;
    public Integer hargamakanan;

    public Makanan() { }

    public Makanan (String imgmakanan, String deskripsi, String menumakanan, String ratingmakanan, Integer hargamakanan){
        this.imgmakanan = imgmakanan;
        this.deskripsi = deskripsi;
        this.menumakanan = menumakanan;
        this.ratingmakanan = ratingmakanan;
        this.hargamakanan = hargamakanan;
    }
}
