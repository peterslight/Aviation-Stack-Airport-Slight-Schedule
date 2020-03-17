package com.peterstev.nc_flightradar.interfaces;

import com.peterstev.nc_flightradar.models.airport.Data;
import com.peterstev.nc_flightradar.models.routes.RouteData;
import com.peterstev.nc_flightradar.utils.Constants;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("airports?access_key=" + Constants.KEY)
    Call<Data> getAirports(@Query("offset") int offset);

    @GET("flights?access_key=" + Constants.KEY)
    Single<RouteData> getRoutes(@Query("dep_iata") String depCode, @Query("arr_iata") String arrCode);

}
