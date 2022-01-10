package com.example.deresto.retrofit;

import android.media.session.MediaSession;

import com.example.deresto.model.AuthObject;
import com.example.deresto.model.ListBarang;
import com.example.deresto.model.ResponMessage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginEndPoint {
    @FormUrlEncoded
    @POST("login")
    Call<AuthObject> checkLogin(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("logout")
    Call<ResponMessage> logout(@Field("token") String Token);

    @FormUrlEncoded
    @POST("register")
    Call<ResponMessage> register(@Field("nama") String nama, @Field("username") String username,
                                 @Field("email") String email, @Field("password") String password, @Field("no_hp") String no_hp);

    @FormUrlEncoded
    @POST("editProfil")
    Call<ResponMessage> editProfil(@Field("token") String Token, @Field("nama") String nama, @Field("username") String username,
                                 @Field("email") String email,  @Field("no_hp") String no_hp);

    @FormUrlEncoded
    @GET("api/barang/{id_kategori}")
    Call<ListBarang> getListBarang(@Path("id_kategori") Integer id_kategori);

}
