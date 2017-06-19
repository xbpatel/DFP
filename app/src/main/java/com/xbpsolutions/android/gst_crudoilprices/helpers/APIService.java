package com.xbpsolutions.android.gst_crudoilprices.helpers;


import com.xbpsolutions.android.gst_crudoilprices.model.ResponseCity;
import com.xbpsolutions.android.gst_crudoilprices.model.ResponsePriceDiesel;
import com.xbpsolutions.android.gst_crudoilprices.model.ResponsePricePetrol;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by excellent-3 on 20/04/17.
 */

public interface APIService {

    @GET("main/city_list")
    Call<ResponseCity> fetchCities();


    @GET("main/{city}/{type}/{price}")
    Call<ResponsePricePetrol> getPetrolPrice(@Path("city") String city, @Path("type") String type, @Path("price") String price);

    @GET("main/{city}/{type}/{price}")
    Call<ResponsePriceDiesel> getDieselPrice(@Path("city") String city, @Path("type") String type, @Path("price") String price);

}


