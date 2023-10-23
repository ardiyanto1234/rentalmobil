package com.kelompokc4.myapplication.koneksi;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserMode {

    @Expose
    @SerializedName("id_pelamar")
    private String id_pelamar;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("nama_lengkap")
    private String nama_lengkap;
    @Expose
    @SerializedName("no_telp")
    private String no_telp;

    @Expose
    @SerializedName("alamat")
    private String alamat;


    @Expose
    @SerializedName("email")
    private String email;

   /* @Expose
    @SerializedName("level")
    private String level;*/

 /*   @Expose
    @SerializedName("user_photo")
    private String userPhoto;*/

    public UserMode(String id_pelamar, String username, String password, String nama_lengkap, String no_telp, String alamat, String email) {
        this.id_pelamar = id_pelamar;
        this.username = username;
        this.password = password;
        this.nama_lengkap = nama_lengkap;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.email = email;
    }

    public String getId_pelamar() {
        return id_pelamar;
    }

    public void setId_pelamar(String id_pelamar) {
        this.id_pelamar = id_pelamar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
