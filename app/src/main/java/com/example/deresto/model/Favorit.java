package com.example.deresto.model;

public class Favorit {
    public String imgfav;
    public String bintang;
    public String tambah;
    public String menufav;
    public String ratingfav;
    public Integer hargafav;

    public Favorit(){ }

    public Favorit (String imgfav, String menufav, String ratingfav, Integer hargafav) {
        this.imgfav = imgfav;
        this.menufav = menufav;
        this.ratingfav = ratingfav;
        this.hargafav = hargafav;
    }
}
