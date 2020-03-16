package com.peterstev.nc_flightradar.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.models.airport.Data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;


@Dao
public interface AirportDao {
    @Insert
    Completable insert(Airport airport);

    @Insert
    Completable insertAll(List<Airport> airport);

    @Query("DELETE FROM airport_table")
    Completable deleteAllAirports();

    @Query("SELECT * FROM airport_table ORDER BY id DESC")
    Flowable<List<Airport>> getAllAirports();
}
