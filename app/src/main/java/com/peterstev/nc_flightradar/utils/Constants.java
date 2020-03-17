package com.peterstev.nc_flightradar.utils;

import android.util.Log;

public class Constants {
    public static final String DATABASE_NAME = "flight_db";
    public static final String AIRPORT_TABLE = "airport_table";
    public static final String KEY = "8af4718ee5137993b907457ef78447a5";
    public static final String BASE_URL = "http://api.aviationstack.com/v1/";
    public static final String DEPARTURES_KEY = "departures";
    public static final String ARRIVALS_KEY = "arrivals";

    public static void LOGGER(String message) {
        Log.d("TAG", message);
    }
}
