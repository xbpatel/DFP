package com.xbpsolutions.android.gst_crudoilprices.helpers;

/**
 * Created by excellent-3 on 20/04/17.
 */


public class APIUtils {

    public static final String BASE_URL = "http://fuelpriceindia.herokuapp.com/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
