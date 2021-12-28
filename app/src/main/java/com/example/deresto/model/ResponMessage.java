package com.example.deresto.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponMessage {
    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage(){

        return message;
    }
}
