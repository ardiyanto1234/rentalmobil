package com.kelompokc4.myapplication.koneksi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class  UserResponse {

    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("data")
    private UserMode data;

    public UserResponse(String status, String message, UserMode data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserMode getData() {
        return data;
    }

    public void setData(UserMode data) {
        this.data = data;
    }

}
