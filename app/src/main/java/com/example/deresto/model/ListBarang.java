package com.example.deresto.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ListBarang {

    @SerializedName("barang")
    @Expose
    private List<Barang> barang = null;

    public List<Barang> getBarang() {
        return barang;
    }

    public void setBarang(List<Barang> barang) {
        this.barang = barang;
    }

}