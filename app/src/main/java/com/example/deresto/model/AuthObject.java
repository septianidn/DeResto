package com.example.deresto.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthObject {

    @SerializedName("data")
    @Expose
    private DataLogin data;

    public DataLogin getData() {
        return data;
    }

    public void setData(DataLogin dataLogin) {
        this.data = dataLogin;
    }

}