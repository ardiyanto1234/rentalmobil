package com.kelompokc4.myapplication.response;

import java.util.List;

public class ResponseBooking {

    String message,status;

    List<ModelBooking> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ModelBooking> getData() {
        return data;
    }

    public void setData(List<ModelBooking> data) {
        this.data = data;
    }
}
