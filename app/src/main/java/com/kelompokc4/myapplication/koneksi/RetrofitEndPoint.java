package com.kelompokc4.myapplication.koneksi;

import com.kelompokc4.myapplication.response.Detailresponmobil;
import com.kelompokc4.myapplication.response.EmailCheckResponse;
import com.kelompokc4.myapplication.response.GetMobil;
import com.kelompokc4.myapplication.response.GetMobileResponse;
import com.kelompokc4.myapplication.response.ResponseBooking;
import com.kelompokc4.myapplication.response.ResponseTiimer;
import com.kelompokc4.myapplication.response.VerifyResponse;
import com.kelompokc4.myapplication.response.getEmailRegis;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitEndPoint {
    @FormUrlEncoded
    @POST("Register.php")
    Call<UserResponse> driveeasy(
            @Field("username") String username,
            @Field("email") String email,
            @Field("alamat") String alamat,
            @Field("password") String password
    );
@Multipart
    @POST("Booking.php")
    Call<ResponseBooking>PesanMobil(
             @Part("nama") String nama,
             @Part("no_hp") String no_hp,
             @Part("alamat") String alamat,
             @Part("tanggal") String tanggal,
             @Part("jam") String jam,
             @Part MultipartBody.Part foto_ktp,
             @Part("id_user") String id_user,
             @Part("id_mobil") String id_mobil
    );


    @FormUrlEncoded
    @POST("login.php")
    Call<UserResponse> loginEasyDrive(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("updatesandi.php")
    Call<UserResponse> gantiSandi(
            @Field("email") String email,
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
    @POST("Login_goggle.php")
    Call<UserResponse> google_login(
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("Ulasan.php")
    Call<UserResponse> ulasan(
            @Field("text_ulasan") String ulasan,
            @Field("id_user") int id_user
    );
 /*   @FormUrlEncoded
    @POST("users/login_google.php")
    Call<UsersResponse> loginGoogle(
            @Field("email") String email
    );*/

//    @FormUrlEncoded
//    @POST("users/register_google.php")
//    Call<UsersResponse> registerGoogle(
//            @Field("username") String username,
//            @Field("email") String email,
//            @Field("full_name") String fullName,
//            @Field("password") String password
//    );*/

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


    @FormUrlEncoded
    @POST("mail.php")
    Call<VerifyResponse> sendEmail(
            @Field("email") String email,
            @Field("type") String type,
            @Field("action") String action
    );


    @GET("ambil_data_mobil.php")
    Call<Detailresponmobil> ambildatamobil();

    @GET("getMobil.php")
    Call<GetMobileResponse> getMobil();

    @GET("getMobil4.php")
    Call<GetMobileResponse> ambildatamobil4(

    );

    @GET("getEmailRegis.php")
    Call<List<getEmailRegis>> getEmailRegis();
    @GET("checkEmail.php")
    Call<EmailCheckResponse> checkEmail(@Query("email") String email);

    @FormUrlEncoded
    @POST("editprofil.php")
    Call<UserResponse> editprofil(
            @Field("id_user") String iduser,
            @Field("username") String username,
            @Field("email") String email,
            @Field("alamat") String alamat
    );
@FormUrlEncoded
    @POST("histori.php")
    Call<ResponHistori> histori(
            @Field("id_user") String iduser
    );
@FormUrlEncoded
    @POST("startTimer.php")
    Call<ResponseTiimer> startTimer(
            @Field("id_mobil") String id_mobil
    );


}
