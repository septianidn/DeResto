package com.example.deresto.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListBarang {

    @SerializedName("barang")
    @Expose
    private Barang barang;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

}