package com.kelompokc4.myapplication.response;

import java.util.ArrayList;

public class GetMobileResponse {

    private ArrayList<GetMobil> data;

    public GetMobileResponse(ArrayList<GetMobil> data) {
        this.data = data;
    }

    public ArrayList<GetMobil> getData() {
        return data;
    }

    public void setData(ArrayList<GetMobil> data) {
        this.data = data;
    }
}
