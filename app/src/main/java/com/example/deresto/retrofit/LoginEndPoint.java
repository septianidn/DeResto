package com.example.deresto.retrofit;

import com.example.deresto.model.AuthObject;
import com.example.deresto.model.ResponMessage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginEndPoint {
    @FormUrlEncoded
    @POST("login")
    Call<AuthObject> checkLogin(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<ResponMessage> register(@Field("nama") String nama, @Field("username") String username,
                                 @Field("email") String email, @Field("password") String password, @Field("no_hp") String no_hp);

}
