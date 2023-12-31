package com.kelompokc4.myapplication.koneksi;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitClient {


//    public static final String BASE_URL = "http://172.17.202.135/easydrive/";
    public static final String BASE_URL = "https://driveeasy.tifnganjuk.com/easydrive/";

    //public static final String BASE_URL = "http://172.16.106.185/easydrive/";
    public static final String SUCCESSFUL_RESPONSE = "success";


    @NonNull
    public static RetrofitEndPoint getInstance(){
        return getConnection().create(RetrofitEndPoint.class);
    }

    public static Retrofit getConnection(){

        Gson gson = new GsonBuilder().setLenient().create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS) // Atur waktu timeout koneksi
                .readTimeout(15, TimeUnit.SECONDS)    // Atur waktu timeout baca
                .writeTimeout(15, TimeUnit.SECONDS)   // Atur waktu timeout tulis
                .build();



        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }


}
