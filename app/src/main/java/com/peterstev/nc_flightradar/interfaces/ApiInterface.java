package com.peterstev.nc_flightradar.interfaces;

import com.peterstev.nc_flightradar.models.airport.Data;
import com.peterstev.nc_flightradar.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("airports?limit=20&access_key=" + Constants.KEY)
    Call<Data> getAirports(@Query("offset") int offset);
}
