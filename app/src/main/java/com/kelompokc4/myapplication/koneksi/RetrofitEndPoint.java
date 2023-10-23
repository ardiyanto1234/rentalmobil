package com.kelompokc4.myapplication.koneksi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitEndPoint {
    @FormUrlEncoded
    @POST("Registrasi.php")
    Call<UserResponse> driveeasy(
            @Field("username") String username,
            @Field("email") String email,
             @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<UserResponse> loginEasyDrive(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("controllers/mobile/users/login.php")
    Call<UserResponse> loginHaqi(
            @Field("email") String username,
            @Field("password") String password
    );

    @GET("users/cek_user.php")
    Call<UserResponse> cekUser(
            @Query("email") String email
    );

    @FormUrlEncoded
    @POST("users/login.php")
    Call<UserResponse> login (
            @Field("email") String email,
            @Field("password") String password
    );


    @FormUrlEncoded
    @POST("google_login.php")
    Call<UserResponse> google_login(
            @Field("email") String email
    );
 /*   @FormUrlEncoded
    @POST("users/login_google.php")
    Call<UsersResponse> loginGoogle(
            @Field("email") String email
    );*/

 /*   @FormUrlEncoded
    @POST("users/register.php")
    Call<UsersResponse> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("full_name") String fullName,
            @Field("password") String password
    );*/

  /*  @FormUrlEncoded
    @POST("users/register_google.php")
    Call<UsersResponse> registerGoogle(
            @Field("username") String username,
            @Field("email") String email,
            @Field("full_name") String fullName,
            @Field("password") String password
    );*/

   /* @FormUrlEncoded
    @POST("users/update_pw.php")
    Call<UsersResponse> updatePassword(
            @Field("email") String email,
            @Field("password") String password
    );*/

   /* @FormUrlEncoded
    @POST("users/update_pp.php")
    Call<UsersResponse> uploadPhotoBase64(
            @Field("email") String email,
            @Field("photo") String photo);*/



}
