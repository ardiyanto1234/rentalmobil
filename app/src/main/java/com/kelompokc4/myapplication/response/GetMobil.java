package com.kelompokc4.myapplication.response;

public class GetMobil {
    private int id_mobil, id_detail_mobil;
    private String merk, gambar_mobil;

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
