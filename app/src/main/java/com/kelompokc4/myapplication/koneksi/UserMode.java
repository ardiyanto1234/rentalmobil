package com.kelompokc4.myapplication.koneksi;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserMode {

    @Expose
    @SerializedName("id_user")
    private int id_user;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("alamat")
    private String alamat;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("password")
    private String password;

    public String getAlamat() {
        return alamat;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}