package com.kelompokc4.myapplication.response;

public class model_det_mobil {

    private String jumlah_kursi;
    private String  Bahan_bakar;
    private String isi_silinder;
    private String plat;
    private String gambar_mobil;
    private String type;
    private String warna;
    private String thn_produksi;

    public model_det_mobil(String jumlah_kursi, String bahan_bakar, String isi_silinder, String plat, String type, String warna, String thn_produksi, String gambar_mobil) {
        this.jumlah_kursi = jumlah_kursi;
        Bahan_bakar = bahan_bakar;
        this.isi_silinder = isi_silinder;
        this.gambar_mobil = gambar_mobil;
        this.plat = plat;
        this.type = type;
        this.warna = warna;
        this.thn_produksi = thn_produksi;
    }

    public String getJumlah_kursi() {
        return jumlah_kursi;
    }

    public void setJumlah_kursi(String jumlah_kursi) {
        this.gambar_mobil = gambar_mobil;
    } public String getGambar_mobil() { return gambar_mobil;
    }

    public void setGambar_mobil(String gambar_mobil) {
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
}
