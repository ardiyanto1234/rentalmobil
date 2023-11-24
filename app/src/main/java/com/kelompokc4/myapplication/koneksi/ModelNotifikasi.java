package com.kelompokc4.myapplication.koneksi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelNotifikasi {

    @Expose
    @SerializedName("tanggal")
    private String tanggal;
    @Expose
    @SerializedName("jam")
    private String jam;
    @Expose
    @SerializedName("merk")
    private String merk;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
}
