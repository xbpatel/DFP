package com.xbpsolutions.android.gst_crudoilprices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCity {

    @SerializedName("cities")
    @Expose
    private List<String> cities = null;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

}