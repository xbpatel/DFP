package com.xbpsolutions.android.gst_crudoilprices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsePricePetrol {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("petrol")
    @Expose
    private Double price;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}