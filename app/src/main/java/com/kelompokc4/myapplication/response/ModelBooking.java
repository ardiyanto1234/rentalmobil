package com.kelompokc4.myapplication.response;

import java.sql.Time;

import retrofit2.http.Multipart;

public class ModelBooking {

    private String nama;
    private int id_user;
    private String no_hp;
    private String alamat;
    private String tanggal;
    private String jam;

    private Multipart foto_ktp;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

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

    public Multipart getFoto_ktp() {
        return foto_ktp;
    }

    public void setFoto_ktp(Multipart foto_ktp) {
        this.foto_ktp = foto_ktp;
    }
}
