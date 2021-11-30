package com.example.deresto.retrofit;

import com.example.deresto.model.AuthObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginEndPoint {
    @FormUrlEncoded
    @POST("login")
    Call<AuthObject> checkLogin(@Field("username") String username, @Field("password") String password);

}
