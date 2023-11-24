package com.kelompokc4.myapplication.koneksi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponHistori {

    ArrayList<ModelNotifikasi> data;

    public ArrayList<ModelNotifikasi> getData() {
        return data;
    }

    public void setData(ArrayList<ModelNotifikasi> data) {
        this.data = data;
    }
}
