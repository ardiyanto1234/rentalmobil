package com.kelompokc4.myapplication.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMobil {
    private int id_mobil, id_detail_mobil;
    private String merk;
    private String gambar_mobil;
    private String jumlah_kursi;
    @Expose
    @SerializedName("bahan_bakar")
    private String  Bahan_bakar;
    private String isi_silinder;
    private String plat;
    private String type;
    private String warna;
    private String thn_produksi;

    public String getJumlah_kursi() {
        return jumlah_kursi;
    }

    public void setJumlah_kursi(String jumlah_kursi) {
        this.jumlah_kursi = jumlah_kursi;
    }
    public String getgambar_mobil() { return gambar_mobil;}
    public void setgambar_mobil(String gambar_mobil) {
        this.gambar_mobil = gambar_mobil;
    }
    public String getBahan_bakar() {
        return Bahan_bakar;
    }

    public void setBahan_bakar(String bahan_bakar) {
        Bahan_bakar = bahan_bakar;
    }

    public String getIsi_silinder() {
        return isi_silinder;
    }

    public void setIsi_silinder(String isi_silinder) {
        this.isi_silinder = isi_silinder;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getThn_produksi() {
        return thn_produksi;
    }

    public void setThn_produksi(String thn_produksi) {
        this.thn_produksi = thn_produksi;
    }

    public int getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(int id_mobil) {
        this.id_mobil = id_mobil;
    }

    public int getId_detail_mobil() {
        return id_detail_mobil;
    }

    public void setId_detail_mobil(int id_detail_mobil) {
        this.id_detail_mobil = id_detail_mobil;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getGambar_mobil() {
        return gambar_mobil;
    }

    public void setGambar_mobil(String gambar_mobil) {
        this.gambar_mobil = gambar_mobil;
    }


}
